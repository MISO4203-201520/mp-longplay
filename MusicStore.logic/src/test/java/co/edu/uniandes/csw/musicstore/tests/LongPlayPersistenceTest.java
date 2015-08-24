package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.persistence.LongPlayPersistence;
import static co.edu.uniandes.csw.musicstore.tests._TestUtil.*;
import java.util.ArrayList;
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
 * @generated
 */
@RunWith(Arquillian.class)
public class LongPlayPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(LongPlayEntity.class.getPackage())
                .addPackage(LongPlayPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private LongPlayPersistence longPlayPersistence;

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
        em.createQuery("delete from LongPlayEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<LongPlayEntity> data = new ArrayList<LongPlayEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            LongPlayEntity entity = new LongPlayEntity();
            entity.setName(generateRandom(String.class));
            entity.setPrice(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createLongPlayTest() {
        LongPlayEntity newEntity = new LongPlayEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Integer.class));

        LongPlayEntity result = longPlayPersistence.create(newEntity);

        Assert.assertNotNull(result);

        LongPlayEntity entity = em.find(LongPlayEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getLongPlaysTest() {
        List<LongPlayEntity> list = longPlayPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (LongPlayEntity ent : list) {
            boolean found = false;
            for (LongPlayEntity entity : data) {
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
    public void getLongPlayTest() {
        LongPlayEntity entity = data.get(0);
        LongPlayEntity newEntity = longPlayPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPrice(), newEntity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void deleteLongPlayTest() {
        LongPlayEntity entity = data.get(0);
        longPlayPersistence.delete(entity.getId());
        LongPlayEntity deleted = em.find(LongPlayEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateLongPlayTest() {
        LongPlayEntity entity = data.get(0);

        LongPlayEntity newEntity = new LongPlayEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Integer.class));

        longPlayPersistence.update(newEntity);

        LongPlayEntity resp = em.find(LongPlayEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getPrice(), resp.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getLongPlayPaginationTest() {
        //Page 1
        List<LongPlayEntity> ent1 = longPlayPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<LongPlayEntity> ent2 = longPlayPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (LongPlayEntity ent : ent1) {
            boolean found = false;
            for (LongPlayEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (LongPlayEntity ent : ent2) {
            boolean found = false;
            for (LongPlayEntity entity : data) {
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
        List<LongPlayEntity> cache = new ArrayList<LongPlayEntity>();
        List<LongPlayEntity> list = longPlayPersistence.findByName(name);

        for (LongPlayEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (LongPlayEntity ent : list) {
            boolean found = false;
            for (LongPlayEntity cacheEntity : cache) {
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
