package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchasePersistence;
import static co.edu.uniandes.csw.musicstore.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class) 
public class PurchasePersistenceTest {
    public static final String DEPLOY = "Prueba"; 
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PurchaseEntity.class.getPackage())
                .addPackage(PurchasePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PurchasePersistence purchasePersistence;
    
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
        em.createQuery("delete from PurchaseEntity").executeUpdate();
    }
    
    private List<PurchaseEntity> data = new ArrayList<PurchaseEntity>();
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setCVC(generateRandom(String.class));
            entity.setCardNumber(generateRandom(String.class));
            entity.setExpirationDate(generateRandom(String.class));
            entity.setId(generateRandom(Long.class));
            entity.setIva(generateRandom(Float.class));
            entity.setNameCardOwner(generateRandom(String.class));
            entity.setPaymentMethod(generateRandom(String.class));
            entity.setTotal(generateRandom(Float.class));
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createClientTest() {
        PurchaseEntity newEntity = new PurchaseEntity();
        newEntity.setCVC(generateRandom(String.class));
        newEntity.setCardNumber(generateRandom(String.class));
        newEntity.setExpirationDate(generateRandom(String.class));
        newEntity.setId(generateRandom(Long.class));
        newEntity.setIva(generateRandom(Float.class));
        newEntity.setNameCardOwner(generateRandom(String.class));
        newEntity.setPaymentMethod(generateRandom(String.class));
        newEntity.setTotal(generateRandom(Float.class));

        PurchaseEntity result = purchasePersistence.create(newEntity);

        Assert.assertNotNull(result);

        PurchaseEntity entity = em.find(PurchaseEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCVC(), entity.getCVC());
        Assert.assertEquals(newEntity.getCardNumber(), entity.getCardNumber());
        Assert.assertEquals(newEntity.getExpirationDate(), entity.getExpirationDate());
        Assert.assertEquals(newEntity.getCardNumber(), entity.getCardNumber());
    }
    
}
