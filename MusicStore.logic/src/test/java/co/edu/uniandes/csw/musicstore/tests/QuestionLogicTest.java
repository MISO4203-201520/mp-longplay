/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.tests;

import co.edu.uniandes.csw.musicstore.api.IQuestionLogic;
import co.edu.uniandes.csw.musicstore.converters.QuestionConverter;
import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
import co.edu.uniandes.csw.musicstore.persistence.QuestionPersistence;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.runner.RunWith;
//import uk.co.jemos.podam.api.PodamFactory;
//import uk.co.jemos.podam.api.PodamFactoryImpl;
import co.edu.uniandes.csw.musicstore.ejbs.QuestionLogic;
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
public class QuestionLogicTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(QuestionEntity.class.getPackage())
                .addPackage(QuestionDTO.class.getPackage())
                .addPackage(QuestionConverter.class.getPackage())
                .addPackage(QuestionLogic.class.getPackage())
                .addPackage(IQuestionLogic.class.getPackage())
                .addPackage(QuestionPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IQuestionLogic questionLogic;

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
        em.createQuery("delete from QuestionEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<QuestionEntity> data = new ArrayList<QuestionEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            /*PodamFactory factory = new PodamFactoryImpl();
            QuestionEntity entity = QuestionConverter.basicDTO2Entity(factory.manufacturePojo(QuestionDTO.class));
            em.persist(entity);
            data.add(entity);*/
        }
    }

    /**
     * @generated
     */
    @Test
    public void createLongPlayTest() {

        /*PodamFactory factory = new PodamFactoryImpl();
        QuestionDTO dto = factory.manufacturePojo(QuestionDTO.class);
        QuestionDTO result = questionLogic.createQuestion(dto);
        Assert.assertNotNull(result);
        QuestionEntity entity = em.find(QuestionEntity.class, result.getId());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());*/
    }

}
