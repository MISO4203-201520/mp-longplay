package co.edu.uniandes.csw.musicstore.tests;
import co.edu.uniandes.csw.musicstore.api.ICommentLogic;
import co.edu.uniandes.csw.musicstore.converters.CommentConverter;
import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.ejbs.CommentLogic;
import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
import co.edu.uniandes.csw.musicstore.persistence.CommentPersistence;

import uk.co.jemos.podam.api.PodamFactory; 
import uk.co.jemos.podam.api.PodamFactoryImpl; 


import static co.edu.uniandes.csw.musicstore.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 *
 * @author va.bastidas10
 */
@RunWith(Arquillian.class) 
public class CommentLogicTest {
    public static final String DEPLOY = "Prueba"; 
     
    @Deployment 
    public static WebArchive createDeployment() { 
    return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war") 
                .addPackage(CommentEntity.class.getPackage()) 
                .addPackage(CommentDTO.class.getPackage()) 
                .addPackage(CommentConverter.class.getPackage()) 
                .addPackage(CommentLogic.class.getPackage()) 
                .addPackage(ICommentLogic.class.getPackage()) 
                .addPackage(CommentPersistence.class.getPackage()) 
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml") 
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml"); 
    } 
    
    @Inject
    private ICommentLogic commentLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    UserTransaction utx; 

    @Before 
    public void configTest() { 
        try { 
            utx.begin(); 
            clearData(); 
            insertData(); 
            utx.commit(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            try { 
                utx.rollback(); 
            } catch (Exception e1) { 
                e1.printStackTrace(); 
            } 
        } 
    }
    
    private void clearData() { 
        em.createQuery("delete from CommentEntity").executeUpdate(); 
    } 
    private List data = new ArrayList(); 
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            PodamFactory factory = new PodamFactoryImpl(); 
            CommentEntity entity = CommentConverter.basicDTO2Entity(factory.manufacturePojo(CommentDTO.class)); 
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    @Test
    public void createCommentTest() {
        
        PodamFactory factory = new PodamFactoryImpl();
        CommentDTO dto = factory.manufacturePojo(CommentDTO.class);
        CommentDTO result = commentLogic.createComment(dto);
        Assert.assertNotNull(result);
        CommentEntity entity = em.find(CommentEntity.class, result.getId());

        Assert.assertEquals(dto.getDescription(), entity.getDescription());
        Assert.assertEquals(dto.getClient(), entity.getClient());
        Assert.assertEquals(dto.getLongPlay(), entity.getLongPlay());
        Assert.assertEquals(dto.getIdPadre(), entity.getIdPadre());
        
    }
}
