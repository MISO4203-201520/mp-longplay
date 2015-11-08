package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.ejbs.AlbumLogic;
import co.edu.uniandes.csw.musicstore.api.IAlbumLogic;
import co.edu.uniandes.csw.musicstore.api.ILongPlayLogic;
import co.edu.uniandes.csw.musicstore.api.IPurchaseLogic;
import co.edu.uniandes.csw.musicstore.converters.AlbumConverter;
import co.edu.uniandes.csw.musicstore.converters.LongPlayConverter;
import co.edu.uniandes.csw.musicstore.converters.PurchaseConverter;
import co.edu.uniandes.csw.musicstore.converters.PurchaseDetailConverter;
import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import co.edu.uniandes.csw.musicstore.ejbs.LongPlayLogic;
import co.edu.uniandes.csw.musicstore.ejbs.PurchaseLogic;
import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.AlbumPersistence;
import static co.edu.uniandes.csw.musicstore.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AlbumLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AlbumEntity.class.getPackage())
                .addPackage(AlbumDTO.class.getPackage())
                .addPackage(AlbumConverter.class.getPackage())
                .addPackage(AlbumLogic.class.getPackage())
                .addPackage(IAlbumLogic.class.getPackage())
                .addPackage(AlbumPersistence.class.getPackage())
                .addPackage(LongPlayDTO.class.getPackage())
                .addPackage(LongPlayEntity.class.getPackage())
                .addPackage(PurchaseEntity.class.getPackage())
                .addPackage(PurchaseDetailEntity.class.getPackage())
                .addPackage(PurchaseDTO.class.getPackage())
                .addPackage(PurchaseDetailDTO.class.getPackage())
                .addPackage(LongPlayLogic.class.getPackage())
                .addPackage(PurchaseLogic.class.getPackage())
                .addPackage(PurchaseConverter.class.getPackage())
                .addPackage(PurchaseDetailConverter.class.getPackage())
                .addPackage(LongPlayConverter.class.getPackage())
                .addPackage(ILongPlayLogic.class.getPackage())
                .addPackage(IPurchaseLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IAlbumLogic albumLogic;
    
    @Inject
    private ILongPlayLogic longPlayLogic;

    @Inject
    private IPurchaseLogic purchaseLogic;
    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
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

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from AlbumEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<AlbumEntity> data = new ArrayList<AlbumEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            AlbumEntity entity = new AlbumEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setCover(generateRandom(String.class));
        	entity.setRelease(generateRandom(Date.class));
        	entity.setSingle(generateRandom(Boolean.class));
        	entity.setArtist(generateRandom(String.class));
                entity.setAwards(generateRandom(String.class));
                entity.setHistoricReview(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createAlbumTest() {
        AlbumDTO dto = new AlbumDTO();
        dto.setName(generateRandom(String.class));
        dto.setCover(generateRandom(String.class));
        dto.setRelease(generateRandom(Date.class));
        dto.setSingle(generateRandom(Boolean.class));
        dto.setArtist(generateRandom(String.class));
        dto.setAwards(generateRandom(String.class));
        dto.setHistoricReview(generateRandom(String.class));
        AlbumDTO result = albumLogic.createAlbum(dto);

        Assert.assertNotNull(result);

        AlbumEntity entity = em.find(AlbumEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getCover(), entity.getCover());
        Assert.assertEquals(dto.getRelease(), entity.getRelease());
        Assert.assertEquals(dto.getSingle(), entity.getSingle());
        Assert.assertEquals(dto.getArtist(), entity.getArtist());
        Assert.assertEquals(dto.getAwards(), entity.getAwards());
        Assert.assertEquals(dto.getHistoricReview(), entity.getHistoricReview());

        
    }

    /**
     * @generated
     */
    @Test
    public void getAlbumsTest() {
        List<AlbumDTO> list = albumLogic.getAlbums(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (AlbumDTO dto : list) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getAlbumTest() {
        AlbumEntity entity = data.get(0);
        AlbumDTO dto = albumLogic.getAlbum(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getCover(), dto.getCover());
        Assert.assertEquals(entity.getRelease(), dto.getRelease());
        Assert.assertEquals(entity.getSingle(), dto.getSingle());
        Assert.assertEquals(entity.getArtist(), dto.getArtist());
        Assert.assertEquals(entity.getAwards(), dto.getAwards());
        Assert.assertEquals(entity.getHistoricReview(), dto.getHistoricReview());

    }

    /**
     * @generated
     */
    @Test
    public void deleteAlbumTest() {
        AlbumEntity entity = data.get(0);
        albumLogic.deleteAlbum(entity.getId());
        AlbumEntity deleted = em.find(AlbumEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateAlbumTest() {
        AlbumEntity entity = data.get(0);

        AlbumDTO dto = new AlbumDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setCover(generateRandom(String.class));
        dto.setRelease(generateRandom(Date.class));
        dto.setSingle(generateRandom(Boolean.class));
        dto.setArtist(generateRandom(String.class));
        dto.setAwards(generateRandom(String.class));
        dto.setHistoricReview(generateRandom(String.class));

        albumLogic.updateAlbum(dto);

        AlbumEntity resp = em.find(AlbumEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getCover(), resp.getCover());
        Assert.assertEquals(dto.getRelease(), resp.getRelease());
        Assert.assertEquals(dto.getSingle(), resp.getSingle());
        Assert.assertEquals(dto.getArtist(), resp.getArtist());
        Assert.assertEquals(dto.getAwards(), resp.getAwards());
        Assert.assertEquals(dto.getHistoricReview(), resp.getHistoricReview());


    }

    /**
     * @generated
     */
    @Test
    public void getAlbumPaginationTest() {
        //Page 1
        List<AlbumDTO> dto1 = albumLogic.getAlbums(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<AlbumDTO> dto2 = albumLogic.getAlbums(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (AlbumDTO dto : dto1) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (AlbumDTO dto : dto2) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void findByName() {
        String name = data.get(0).getName();
        List<AlbumEntity> cache = new ArrayList<AlbumEntity>();
        List<AlbumDTO> list = albumLogic.findByName(name);

        for (AlbumEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (AlbumDTO dto : list) {
            boolean found = false;
            for (AlbumEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
    
    //@Test
    public void getTopSellerAlbums()
    {
      //Setup albums
      List<AlbumDTO> listAlbums = albumLogic.getAlbums(0, 5);
      
      if(listAlbums.size()>2)
      {
          //Albums
          AlbumDTO album1 = listAlbums.get(0);
          AlbumDTO album2 = listAlbums.get(1);
          AlbumDTO album3 = listAlbums.get(2);
          
          //Purchase
          PurchaseDTO purchase = new PurchaseDTO();
          ArrayList<PurchaseDetailDTO> detList = new ArrayList<PurchaseDetailDTO>();
          //DetailsAlbum1
          for (int i = 0; i < 3; i++) {
            PurchaseDetailDTO det = new PurchaseDetailDTO();
            LongPlayDTO dto = new LongPlayDTO();
            dto.setName(generateRandom(String.class));
            dto.setPrice(generateRandom(Integer.class));
            dto.setAlbum(album1);
            det.setLongPlay(longPlayLogic.createLongPlay(dto));
            detList.add(det);
          }
           //DetailsAlbum2
          for (int i = 0; i < 2; i++) {
            PurchaseDetailDTO det = new PurchaseDetailDTO();
            LongPlayDTO dto = new LongPlayDTO();
            dto.setName(generateRandom(String.class));
            dto.setPrice(generateRandom(Integer.class));
            dto.setAlbum(album2);
            det.setLongPlay(longPlayLogic.createLongPlay(dto));
            detList.add(det);
          }
           //DetailsAlbum3
          for (int i = 0; i < 1; i++) {
            PurchaseDetailDTO det = new PurchaseDetailDTO();
            LongPlayDTO dto = new LongPlayDTO();
            dto.setName(generateRandom(String.class));
            dto.setPrice(generateRandom(Integer.class));
            dto.setAlbum(album3);
            det.setLongPlay(longPlayLogic.createLongPlay(dto));
            detList.add(det);
          }
          purchase.setPurchaseDetail(detList);
          purchaseLogic.createPurchase(purchase);
          
          List<AlbumDTO> top =albumLogic.getTopSellerAlbums();
          Assert.assertEquals(top.get(0).getName(), album1.getName());
          Assert.assertEquals(top.get(1).getName(), album2.getName());
          Assert.assertEquals(top.get(2).getName(), album3.getName());
          
      }
        
    }
}
