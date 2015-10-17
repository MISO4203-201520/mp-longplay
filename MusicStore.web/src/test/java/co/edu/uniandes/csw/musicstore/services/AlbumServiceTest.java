/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO; 
import co.edu.uniandes.csw.musicstore.providers.EJBExceptionMapper; 
import co.edu.uniandes.csw.musicstore.services.AlbumService; 
import static com.sun.xml.ws.security.impl.policy.Constants.Created;
import java.io.File; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List; 
import javax.ws.rs.client.Client; 
import javax.ws.rs.client.ClientBuilder; 
import javax.ws.rs.client.Entity; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 
import org.codehaus.jackson.map.ObjectMapper; 
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
import org.junit.Test; 
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


/**
 *
 * @author if.garcia11
 */
@RunWith(Arquillian.class)
public class AlbumServiceTest {
    
    public static final String DEPLOY = "Prueba";  
    public static String URLRESOURCES = "src/main/webapp"; 
    public static String URLBASE = "http://localhost:8080/MusicStore.web/webresources"; 
    public static String PATHALBUM = "/albums";
    public static ArrayList<AlbumDTO> oraculo = new ArrayList<AlbumDTO>();
    @Deployment  
    public static WebArchive createDeployment() { 
    
      MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        WebArchive war = ShrinkWrap 
                // Nombre del Proyecto "Bookbasico.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "MusicStore.web.war") 
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV) 
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.musicstore:MusicStore.logic:1.0") 
                        .resolveAsFiles()) 
                // Se agregan los compilados de los paquetes de servicios 
                .addPackage(AlbumService.class.getPackage()) 
                .addPackage(EJBExceptionMapper.class.getPackage()) 
                // El archivo que contiene la configuracion a la base de datos.  
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml") 
                // El archivo beans.xml es necesario para injeccion de dependencias.  
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml")) 
                // El archivo web.xml es necesario para el despliegue de los servlets 
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml")); 

        return war; 
    }
    @BeforeClass 
    public static void setUp() { 
        for (int i = 0; i < 5; i++) { 
            PodamFactory factory = new PodamFactoryImpl(); 
            AlbumDTO album = factory.manufacturePojo(AlbumDTO.class); 
            oraculo.add(album); 
            System.out.println("oraculo "+album.getName());
        } 
    }
    @Test 
    @RunAsClient 
    public void t1CreateBookService() throws IOException { 
        AlbumDTO album = oraculo.get(0); 
        Client cliente = ClientBuilder.newClient(); 
      
        Response response = cliente.target(URLBASE + PATHALBUM) 
                .request() 
                .post(Entity.entity(album, MediaType.APPLICATION_JSON));
        /*
        AlbumDTO albumTest = (AlbumDTO) response.readEntity(AlbumDTO.class); 
        Assert.assertEquals(album.getName(), albumTest.getName()); 
        Assert.assertEquals(album.getRelease(), albumTest.getRelease()); 
        Assert.assertEquals(album.getId(), album.getId()); 
        Assert.assertEquals(album.getCover(), album.getCover()); 
        Assert.assertEquals(album.getSingle(), album.getSingle()); 
        Assert.assertEquals(album.getId(), album.getId()); 
        Assert.assertEquals(album.getArtist(), album.getArtist()); 
        Assert.assertEquals(album.getAwards(), album.getAwards()); 
        Assert.assertEquals(album.getHistoricReview(), album.getHistoricReview()); 
        Assert.assertEquals(Created, response.getStatus()); 
        */
        
    }
    
}
