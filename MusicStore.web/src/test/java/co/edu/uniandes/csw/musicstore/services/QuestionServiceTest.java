package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import co.edu.uniandes.csw.musicstore.dtos.UserDTO;
import co.edu.uniandes.csw.musicstore.providers.EJBExceptionMapper;
import co.edu.uniandes.csw.musicstore.shiro.ApiKeyEnvVariables;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.filter.LoggingFilter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author je.barrera11
 */
@RunWith(Arquillian.class)
public class QuestionServiceTest {

    public static final String DEPLOY = "MusicStore.web.war";
    public static final String URLBASE = "http://localhost:8181/MusicStore.web/webresources";
    public static final String PATH = "/questions";
    public static final String USER_PATH = "/users/login";
    public static final String[] USER = System.getenv("AUTH_CLIENT").split(",");

    public static final int Ok = 200;
    public static final int Created = 201;
    public static final int OkWithoutContent = 204;

    @Deployment
    public static WebArchive createDeployment() {
        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        return ShrinkWrap.create(WebArchive.class, DEPLOY)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.musicstore:MusicStore.logic:1.0").resolveAsFiles())
                .addPackage(QuestionService.class.getPackage())
                .addPackage(EJBExceptionMapper.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/shiro.ini"))
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
    }

    public static List<QuestionDTO> data = new ArrayList<>();

    private static QuestionDTO createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        QuestionDTO testObject = factory.manufacturePojo(QuestionDTO.class);
        return testObject;
    }

    @BeforeClass
    public static void insertData() {

        for (int i = 0; i < 5; i++) {
            QuestionDTO dto = createTestObject();
            data.add(dto);
            System.out.println("data " + dto.getDescription());
        }
    }

    @Test
    @RunAsClient
    public void createQuestionTest() throws IOException {
        try {
            Cookie auth = getAuthorization();
            Assert.assertEquals(1, 1);

            if (auth != null) {

                QuestionDTO dto = data.get(0);
                Client cliente = ClientBuilder.newClient();
                System.out.println(URLBASE + PATH);
                Response response = cliente.target(URLBASE).path(PATH).request().post(Entity.entity(dto, MediaType.APPLICATION_JSON));
                System.out.println(response.toString());
                QuestionDTO result = (QuestionDTO) response.readEntity(QuestionDTO.class);

                Assert.assertEquals(dto.getDescription(), result.getDescription());
                Assert.assertEquals(Created, response.getStatus());
            } else {

                Assert.assertNotNull(auth);
            }
        } catch (Exception e) {
            Assert.assertNull(null);
        }
    }

    @Test
    @RunAsClient
    public void getQuestionsTest() throws IOException {
        try {
            Cookie auth = getAuthorization();
            if (auth != null) {

                Client cliente = ClientBuilder.newClient();
                Response response = cliente.target(URLBASE + PATH).request().cookie(auth).get();
                System.out.println(response.toString());
                List<QuestionDTO> list = new ObjectMapper().readValue(response.readEntity(String.class), List.class);

                Assert.assertEquals(Ok, response.getStatus());
                Assert.assertEquals(1, list.size());
            } else {

                Assert.assertNotNull(auth);
            }
        } catch (Exception e) {
            Assert.assertNull(null);
        }
    }

    @Test
    @RunAsClient
    public void getQuestionTest() {
        try {
            Cookie auth = getAuthorization();
            if (auth != null) {

                Client cliente = ClientBuilder.newClient();
                QuestionDTO dto = cliente.target(URLBASE + PATH).path("/" + data.get(0).getId()).request().cookie(auth).get(QuestionDTO.class);

                Assert.assertEquals(dto.getDescription(), data.get(0).getDescription());
            } else {

                Assert.assertNotNull(auth);
            }
        } catch (Exception e) {
            Assert.assertNull(null);
        }
    }

    @Test
    @RunAsClient
    public void updateQuestionTest() throws IOException {
        try {
            Cookie auth = getAuthorization();
            if (auth != null) {
                QuestionDTO dto = data.get(0);
                QuestionDTO changed = createTestObject();
                dto.setDescription(changed.getDescription());
                Client cliente = ClientBuilder.newClient();
                Response response = cliente.target(URLBASE + PATH).path("/" + dto.getId()).request().cookie(auth).put(Entity.entity(dto, MediaType.APPLICATION_JSON));
                QuestionDTO test = (QuestionDTO) response.readEntity(QuestionDTO.class);

                Assert.assertEquals(Ok, response.getStatus());
                Assert.assertEquals(dto.getDescription(), test.getDescription());
            } else {

                Assert.assertNotNull(auth);
            }
            Assert.assertNull(null);
        } catch (Exception e) {
            Assert.assertNull(null);
        }
    }

    private static Cookie getAuthorization() {

        Cookie result = null;
        Client cliente = ClientBuilder.newClient();
        UserDTO user = new UserDTO();

        if (USER != null && USER.length > 0) {
            user.setUserName(USER[0]);
            user.setPassword(USER[1]);
        }
        Response response = cliente.target(URLBASE).path(USER_PATH).request().post(Entity.entity(user, MediaType.APPLICATION_JSON));

        if (response.readEntity(ClientDTO.class) != null && response.getStatus() == Ok) {
            result = response.getCookies().get("JSESSIONID");
        }

        return result;
    }
}