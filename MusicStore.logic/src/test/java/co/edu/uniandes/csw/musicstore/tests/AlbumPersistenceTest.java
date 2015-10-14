package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AlbumPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AlbumEntity.class.getPackage())
                .addPackage(AlbumPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private AlbumPersistence albumPersistence;

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
            entity.setAwards(generateRandom(String.class)); //new attribute
            entity.setHistoricReview(generateRandom(String.class)); //new attribute
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createAlbumTest() {
        AlbumEntity newEntity = new AlbumEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setCover(generateRandom(String.class));
        newEntity.setRelease(generateRandom(Date.class));
        newEntity.setSingle(generateRandom(Boolean.class));
        newEntity.setArtist(generateRandom(String.class));
        newEntity.setAwards(generateRandom(String.class));
        newEntity.setHistoricReview(generateRandom(String.class));
        AlbumEntity result = albumPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AlbumEntity entity = em.find(AlbumEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCover(), entity.getCover());
        Assert.assertEquals(newEntity.getRelease(), entity.getRelease());
        Assert.assertEquals(newEntity.getSingle(), entity.getSingle());
        Assert.assertEquals(newEntity.getArtist(), entity.getArtist());
        Assert.assertEquals(newEntity.getAwards(), entity.getAwards());
        Assert.assertEquals(newEntity.getHistoricReview(), entity.getHistoricReview());

        
    }

    /**
     * @generated
     */
    @Test
    public void getAlbumsTest() {
        List<AlbumEntity> list = albumPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (AlbumEntity ent : list) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        AlbumEntity newEntity = albumPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getCover(), newEntity.getCover());
        Assert.assertEquals(entity.getRelease(), newEntity.getRelease());
        Assert.assertEquals(entity.getSingle(), newEntity.getSingle());
        Assert.assertEquals(entity.getArtist(), newEntity.getArtist());
        Assert.assertEquals(entity.getAwards(), newEntity.getAwards());
        Assert.assertEquals(entity.getHistoricReview(), newEntity.getHistoricReview());
    }

    /**
     * @generated
     */
    @Test
    public void deleteAlbumTest() {
        AlbumEntity entity = data.get(0);
        albumPersistence.delete(entity.getId());
        AlbumEntity deleted = em.find(AlbumEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateAlbumTest() {
        AlbumEntity entity = data.get(0);

        AlbumEntity newEntity = new AlbumEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setCover(generateRandom(String.class));
        newEntity.setRelease(generateRandom(Date.class));
        newEntity.setSingle(generateRandom(Boolean.class));
        newEntity.setArtist(generateRandom(String.class));
        newEntity.setAwards(generateRandom(String.class));
        newEntity.setHistoricReview(generateRandom(String.class));
        albumPersistence.update(newEntity);

        AlbumEntity resp = em.find(AlbumEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getCover(), resp.getCover());
        Assert.assertEquals(newEntity.getRelease(), resp.getRelease());
        Assert.assertEquals(newEntity.getSingle(), resp.getSingle());
        Assert.assertEquals(newEntity.getArtist(), resp.getArtist());
        Assert.assertEquals(newEntity.getAwards(), resp.getAwards());
        Assert.assertEquals(newEntity.getHistoricReview(), resp.getHistoricReview());

    }

    /**
     * @generated
     */
    @Test
    public void getAlbumPaginationTest() {
        //Page 1
        List<AlbumEntity> ent1 = albumPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<AlbumEntity> ent2 = albumPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (AlbumEntity ent : ent1) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (AlbumEntity ent : ent2) {
            boolean found = false;
            for (AlbumEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        List<AlbumEntity> list = albumPersistence.findByName(name);

        for (AlbumEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (AlbumEntity ent : list) {
            boolean found = false;
            for (AlbumEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
