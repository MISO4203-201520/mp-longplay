package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.api.IPurchaseLogic; 
import co.edu.uniandes.csw.musicstore.converters.PurchaseConverter;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import co.edu.uniandes.csw.musicstore.ejbs.PurchaseLogic;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchasePersistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
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
public class PurchaseLogicTest {

    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PurchaseEntity.class.getPackage())
                .addPackage(PurchaseDTO.class.getPackage())
                .addPackage(PurchaseConverter.class.getPackage())
                .addPackage(PurchaseLogic.class.getPackage())
                .addPackage(IPurchaseLogic.class.getPackage())
                .addPackage(PurchasePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IPurchaseLogic purchaseLogic;
    
    @PersistenceContext
    private javax.persistence.EntityManager em;
    
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
            PodamFactory factory = new PodamFactoryImpl(); 
            PurchaseEntity entity = PurchaseConverter.basicDTO2Entity(factory.manufacturePojo(PurchaseDTO.class)); 
            em.persist(entity); 
            data.add(entity);
        }
    }
    
    @Test
    public void createPurchaseTest() {
        
        PodamFactory factory = new PodamFactoryImpl();
        PurchaseDTO dto = factory.manufacturePojo(PurchaseDTO.class);
        PurchaseDTO result = purchaseLogic.createPurchase(dto);
        Assert.assertNotNull(result);
        PurchaseEntity entity = em.find(PurchaseEntity.class, result.getId());
        
        Assert.assertEquals(dto.getCVC(), entity.getCVC());
        Assert.assertEquals(dto.getCardNumber(), entity.getCardNumber());
        Assert.assertEquals(dto.getExpirationDate(), entity.getExpirationDate());
        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getIva(), entity.getIva());
        Assert.assertEquals(dto.getNameCardOwner(), entity.getNameCardOwner());
        Assert.assertEquals(dto.getPaymentMethod(), entity.getPaymentMethod());
        Assert.assertEquals(dto.getTotal(), entity.getTotal());
    }
    
    private PurchaseDTO createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        PurchaseDTO testObject = factory.manufacturePojo(PurchaseDTO.class);
        return testObject;
    }
   

    @Test
    public void getPurchaseTest() {

        PurchaseEntity entity = data.get(0);
        PurchaseDTO newEntity = purchaseLogic.getPurchase(entity.getId());

        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getCardNumber(), entity.getCardNumber());
    }

    @Test
    public void deletePurchaseTest() {

        PurchaseEntity entity = data.get(0);
        purchaseLogic.deletePurchase(entity.getId());
        PurchaseEntity deleted = em.find(PurchaseEntity.class, entity.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void updatePurchaseTest() {
        
        PurchaseEntity entity = data.get(0);
        PurchaseDTO newEntity = createTestObject();
        newEntity.setId(entity.getId());
        purchaseLogic.updatePurchase(newEntity);
        PurchaseEntity resp = em.find(PurchaseEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getCardNumber(), resp.getCardNumber());
    }
    
    @Test
    public void confirmOrderTest()    
    {
      PodamFactory factory = new PodamFactoryImpl();
      PurchaseDetailDTO newEntity = factory.manufacturePojo(PurchaseDetailDTO.class);
      newEntity.setPurchase(factory.manufacturePojo(PurchaseDTO.class));
      PurchaseDetailDTO result = purchaseLogic.confirmOrder(newEntity);
      Assert.assertNotNull(result);
      PurchaseDetailEntity entity= em.find(PurchaseDetailEntity.class, result.getId());
      Date newEntityDate = newEntity.getConfirmDate();
      //ignore time
      newEntityDate.setHours(0);
      newEntityDate.setMinutes(0);
      newEntityDate.setSeconds(0);
      Assert.assertEquals(newEntityDate.toString(), entity.getConfirmDate().toString());
      Assert.assertEquals(newEntity.getIsConfirm(), entity.getIsConfirm());
        
    }
    
    @Test
    public void cancelOrderTest()    
    {
      PodamFactory factory = new PodamFactoryImpl();
      PurchaseDetailDTO newEntity = factory.manufacturePojo(PurchaseDetailDTO.class);
      newEntity.setPurchase(factory.manufacturePojo(PurchaseDTO.class));
      PurchaseDetailDTO result = purchaseLogic.cancelOrder(newEntity);
      Assert.assertNotNull(result);
      PurchaseDetailEntity entity= em.find(PurchaseDetailEntity.class, result.getId());
      Assert.assertEquals(newEntity.getConfirmObservations(), entity.getConfirmObservations());
      Assert.assertEquals(newEntity.getIsConfirm(), entity.getIsConfirm());
    }
}