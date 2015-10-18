package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchasePersistence;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
    
    private PurchaseEntity createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        PurchaseEntity testObject = factory.manufacturePojo(PurchaseEntity.class);
        return testObject;
    }
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PurchaseEntity entity = createTestObject();
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createPurchaseTest() {

        PurchaseEntity newEntity = createTestObject();
        PurchaseEntity result = purchasePersistence.create(newEntity);

        Assert.assertNotNull(result);
        PurchaseEntity entity = em.find(PurchaseEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCardNumber(), entity.getCardNumber());
    }

    @Test
    public void getPurchasesTest() {

        List<PurchaseEntity> list = purchasePersistence.findAll(null, null);

        Assert.assertEquals(data.size(), list.size());
        for (PurchaseEntity newEntity : list) {
            boolean found = false;
            for (PurchaseEntity entity : data) {
                if (newEntity.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPurchaseTest() {

        PurchaseEntity entity = data.get(0);
        PurchaseEntity newEntity = purchasePersistence.find(entity.getId());

        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getCardNumber(), entity.getCardNumber());
    }

    @Test
    public void deletePurchaseTest() {

        PurchaseEntity entity = data.get(0);
        purchasePersistence.delete(entity.getId());
        PurchaseEntity deleted = em.find(PurchaseEntity.class, entity.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void updatePurchaseTest() {

        PurchaseEntity entity = data.get(0);
        PurchaseEntity newEntity = createTestObject();
        newEntity.setId(entity.getId());
        purchasePersistence.update(newEntity);
        PurchaseEntity resp = em.find(PurchaseEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getCardNumber(), resp.getCardNumber());
    }
}
