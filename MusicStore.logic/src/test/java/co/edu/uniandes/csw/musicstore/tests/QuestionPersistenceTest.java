package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.persistence.QuestionPersistence;
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
import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
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
public class QuestionPersistenceTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(QuestionEntity.class.getPackage())
                .addPackage(QuestionPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private QuestionPersistence questionPersistence;

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
        em.createQuery("delete from QuestionEntity").executeUpdate();
    }

    private List<QuestionEntity> data = new ArrayList<QuestionEntity>();

    private QuestionEntity createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        QuestionEntity testObject = factory.manufacturePojo(QuestionEntity.class);
        return testObject;
    }

    private void insertData() {

        for (int i = 0; i < 3; i++) {
            QuestionEntity entity = createTestObject();
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createQuestionTest() {

        QuestionEntity newEntity = createTestObject();
        QuestionEntity result = questionPersistence.create(newEntity);

        Assert.assertNotNull(result);
        QuestionEntity entity = em.find(QuestionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
    }

    @Test
    public void getQuestionsTest() {

        List<QuestionEntity> list = questionPersistence.findAll(null, null);

        Assert.assertEquals(data.size(), list.size());
        for (QuestionEntity newEntity : list) {
            boolean found = false;
            for (QuestionEntity entity : data) {
                if (newEntity.getId().equals(entity.getId())) {
                    found = true;
                }
            }

            Assert.assertTrue(found);
        }
    }

    @Test
    public void getQuestionTest() {

        QuestionEntity entity = data.get(0);
        QuestionEntity newEntity = questionPersistence.find(entity.getId());

        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
    }

    @Test
    public void deleteQuestionTest() {

        QuestionEntity entity = data.get(0);
        questionPersistence.delete(entity.getId());
        QuestionEntity deleted = em.find(QuestionEntity.class, entity.getId());

        Assert.assertNull(deleted);
    }

    @Test
    public void updateQuestionTest() {

        QuestionEntity entity = data.get(0);
        QuestionEntity newEntity = createTestObject();
        newEntity.setId(entity.getId());
        questionPersistence.update(newEntity);
        QuestionEntity resp = em.find(QuestionEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDescription(), resp.getDescription());
    }
}
