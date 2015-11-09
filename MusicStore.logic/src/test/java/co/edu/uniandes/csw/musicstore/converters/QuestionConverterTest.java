/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author c.baquero10
 */
@RunWith(Arquillian.class)
public class QuestionConverterTest {
    
    public QuestionConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of refEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        QuestionEntity entity = null;
        QuestionDTO expResult = null;
        QuestionDTO result = QuestionConverter.refEntity2DTO(entity);
        QuestionDTO result2 = QuestionConverter.refEntity2DTO(new QuestionEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity expResult = null;
        QuestionEntity result = QuestionConverter.refDTO2Entity(dto);
        QuestionEntity result2 = QuestionConverter.refDTO2Entity(new QuestionDTO());
        assertNull(dto);
    }

    /**
     * Test of basicDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity expResult = null;
        QuestionEntity result = QuestionConverter.basicDTO2Entity(dto);
        QuestionEntity result2 = QuestionConverter.basicDTO2Entity(new QuestionDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        QuestionEntity entity = null;
        QuestionDTO expResult = null;
        QuestionDTO result = QuestionConverter.fullEntity2DTO(entity);
        QuestionDTO result2 = QuestionConverter.fullEntity2DTO(new QuestionEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity expResult = null;
        QuestionEntity result = QuestionConverter.fullDTO2Entity(dto);
        QuestionEntity result2 = QuestionConverter.fullDTO2Entity(new QuestionDTO());
        assertEquals(expResult, result);
    }

    /**
     * Test of listEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<QuestionEntity> entities = null;
        List<QuestionDTO> expResult = null;
        List<QuestionDTO> result = QuestionConverter.listEntity2DTO(entities);
        List<QuestionDTO> result2 = QuestionConverter.listEntity2DTO(new ArrayList<QuestionEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<QuestionDTO> dtos = null;
        List<QuestionEntity> expResult = null;
        List<QuestionEntity> result = QuestionConverter.listDTO2Entity(dtos);
        List<QuestionEntity> result2 = QuestionConverter.listDTO2Entity(new ArrayList<QuestionDTO>());
        assertNull(dtos);
    }
    
}
