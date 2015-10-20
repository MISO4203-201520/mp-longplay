package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchaseDetailPersistence;
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
public class PurchaseDetailPersistenceTest {
    public static final String DEPLOY = "Prueba"; 
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PurchaseDetailEntity.class.getPackage())
                .addPackage(PurchaseDetailPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PurchaseDetailPersistence purchasePersistence;
    
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
        em.createQuery("delete from PurchaseDetailEntity").executeUpdate();
    }
    
    private List<PurchaseDetailEntity> data = new ArrayList<PurchaseDetailEntity>();
    
    private PurchaseDetailEntity createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        PurchaseDetailEntity testObject = factory.manufacturePojo(PurchaseDetailEntity.class);
        return testObject;
    }
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PurchaseDetailEntity entity = createTestObject();
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createPurchaseDetailTest() {

        PurchaseDetailEntity newEntity = createTestObject();
        PurchaseDetailEntity result = purchasePersistence.create(newEntity);

        Assert.assertNotNull(result);
        PurchaseDetailEntity entity = em.find(PurchaseDetailEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());
        Assert.assertEquals(newEntity.getQuantity(), entity.getQuantity());
        Assert.assertEquals(newEntity.getConfirmObservations(), entity.getConfirmObservations());
    }

    @Test
    public void getPurchaseDetailTest() {

        List<PurchaseDetailEntity> list = purchasePersistence.findAll(null, null);

        Assert.assertEquals(data.size(), list.size());
        for (PurchaseDetailEntity newEntity : list) {
            boolean found = false;
            for (PurchaseDetailEntity entity : data) {
                if (newEntity.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }


    @Test
    public void deletePurchaseDetailTest() {

        PurchaseDetailEntity entity = data.get(0);
        purchasePersistence.delete(entity.getId());
        PurchaseDetailEntity deleted = em.find(PurchaseDetailEntity.class, entity.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void updatePurchaseDetailTest() {

        PurchaseDetailEntity entity = data.get(0);
        PurchaseDetailEntity newEntity = createTestObject();
        newEntity.setId(entity.getId());
        purchasePersistence.update(newEntity);
        PurchaseDetailEntity resp = em.find(PurchaseDetailEntity.class, entity.getId());

        Assert.assertEquals(resp.getId(), entity.getId());

    }
}