package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.api.ISongLogic;
import co.edu.uniandes.csw.musicstore.converters.SongConverter;
import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
import co.edu.uniandes.csw.musicstore.persistence.SongPersistence;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import co.edu.uniandes.csw.musicstore.ejbs.SongLogic;
import co.edu.uniandes.csw.musicstore.entities.SongEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author je.barrera11
 */
@RunWith(Arquillian.class)
public class SongLogicTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(SongEntity.class.getPackage())
                .addPackage(SongDTO.class.getPackage())
                .addPackage(SongConverter.class.getPackage())
                .addPackage(SongLogic.class.getPackage())
                .addPackage(ISongLogic.class.getPackage())
                .addPackage(SongPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private ISongLogic songLogic;

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
        em.createQuery("delete from SongEntity").executeUpdate();
    }

    private List<SongEntity> data = new ArrayList<SongEntity>();

    private SongDTO createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        SongDTO testObject = factory.manufacturePojo(SongDTO.class);
        return testObject;
    }

    private void insertData() {

        for (int i = 0; i < 3; i++) {
            SongEntity entity = SongConverter.basicDTO2Entity(createTestObject());
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createSongTest() {

        SongDTO dto = createTestObject();
        SongDTO result = songLogic.createSong(dto);

        Assert.assertNotNull(result);
        SongEntity entity = em.find(SongEntity.class, result.getId());

        Assert.assertEquals(dto.getTitle(), entity.getTitle());
    }

    @Test
    public void getSongsTest() {

        List<SongDTO> list = songLogic.getSongs(null, null);

        Assert.assertEquals(data.size(), list.size());
        for (SongDTO dto : list) {
            boolean found = false;
            for (SongEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }

            Assert.assertTrue(found);
        }
    }

    @Test
    public void getSongTest() {

        SongEntity entity = data.get(0);
        SongDTO dto = songLogic.getSong(entity.getId());

        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getTitle(), entity.getTitle());
    }

    @Test
    public void deleteSongTest() {

        SongEntity entity = data.get(0);
        songLogic.deleteSong(entity.getId());
        SongEntity deleted = em.find(SongEntity.class, entity.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void updateSongTest() {

        SongEntity entity = data.get(0);
        SongDTO dto = createTestObject();
        dto.setId(entity.getId());
        songLogic.updateSong(dto);
        SongEntity resp = em.find(SongEntity.class, entity.getId());

        Assert.assertEquals(dto.getTitle(), resp.getTitle());
    }
}
