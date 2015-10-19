package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.persistence.CommentPersistence;
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
import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
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
public class CommentPersistenceTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CommentEntity.class.getPackage())
                .addPackage(CommentPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private CommentPersistence commentPersistence;

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

    private List<CommentEntity> data = new ArrayList<CommentEntity>();

    private CommentEntity createTestObject() {

        PodamFactory factory = new PodamFactoryImpl();
        CommentEntity testObject = factory.manufacturePojo(CommentEntity.class);
        return testObject;
    }

    private void insertData() {

        for (int i = 0; i < 3; i++) {
            CommentEntity entity = createTestObject();
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createCommentTest() {

        CommentEntity newEntity = createTestObject();
        CommentEntity result = commentPersistence.create(newEntity);

        Assert.assertNotNull(result);
        CommentEntity entity = em.find(CommentEntity.class, result.getId());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getClient(), entity.getClient());
        Assert.assertEquals(newEntity.getLongPlay(), entity.getLongPlay());
        Assert.assertEquals(newEntity.getIdPadre(), entity.getIdPadre());
    }

}
