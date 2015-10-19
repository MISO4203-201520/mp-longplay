package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.providers.EJBExceptionMapper;
import static co.edu.uniandes.csw.musicstore.services.AlbumServiceTest.PATHALBUM;
import static co.edu.uniandes.csw.musicstore.services.AlbumServiceTest.URLBASE;
import static co.edu.uniandes.csw.musicstore.services.AlbumServiceTest.oraculo;
import static com.sun.xml.ws.security.impl.policy.Constants.Created;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

@RunWith(Arquillian.class)
public class PurchaseServiceTest {
    
    public static final String DEPLOY = "Prueba";
    public static String URLRESOURCES = "src/main/webapp";
    public static String URLBASE = "http://localhost:8181/MusicStore.web/webresources";
    public static String PATHPURCHASE = "/purchases";
    public static ArrayList<PurchaseDTO> oraculo = new ArrayList<PurchaseDTO>();
    
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
            PurchaseDTO purchase = factory.manufacturePojo(PurchaseDTO.class); 
            oraculo.add(purchase); 
            System.out.println("oraculo "+purchase.getCardNumber());
        } 
    }
    @Test 
    @RunAsClient 
    public void t1CreatePurchaseService() throws IOException { 
        PurchaseDTO purchase = oraculo.get(0); 
        Client cliente = ClientBuilder.newClient(); 
      
        Response response = cliente.target(URLBASE + PATHPURCHASE) 
                .request() 
                .post(Entity.entity(purchase, MediaType.APPLICATION_JSON));
        /*
        PurchaseDTO purchaseTest = (PurchaseDTO) response.readEntity(PurchaseDTO.class); 
        
        Assert.assertEquals(purchase.getCVC(), purchaseTest.getCVC());
        Assert.assertEquals(purchase.getCardNumber(), purchaseTest.getCardNumber());
        Assert.assertEquals(purchase.getClient(), purchaseTest.getClient());
        Assert.assertEquals(purchase.getDate(), purchaseTest.getDate());
        Assert.assertEquals(purchase.getExpirationDate(), purchaseTest.getExpirationDate());
        Assert.assertEquals(purchase.getId(), purchaseTest.getId());
        Assert.assertEquals(purchase.getIva(), purchaseTest.getIva());
        Assert.assertEquals(purchase.getNameCardOwner(), purchaseTest.getNameCardOwner());
        Assert.assertEquals(purchase.getPaymentMethod(), purchaseTest.getPaymentMethod());
        Assert.assertEquals(purchase.getPurchaseDetail(), purchaseTest.getPurchaseDetail());
        Assert.assertEquals(purchase.getTotal(), purchaseTest.getTotal());
        
        Assert.assertEquals(Created, response.getStatus());
        */
    }
}
