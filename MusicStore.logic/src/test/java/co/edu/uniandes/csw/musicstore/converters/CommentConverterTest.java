/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
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
public class CommentConverterTest {
    
    public CommentConverterTest() {
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
     * Test of refEntity2DTO method, of class CommentConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        CommentEntity entity = null;
        CommentDTO expResult = null;
        CommentDTO result = CommentConverter.refEntity2DTO(entity);
        CommentDTO result2 = CommentConverter.refEntity2DTO(new CommentEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        CommentDTO dto = null;
        CommentEntity expResult = null;
        CommentEntity result = CommentConverter.refDTO2Entity(dto);
        CommentEntity result2 = CommentConverter.refDTO2Entity(new CommentDTO());
        assertNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class CommentConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        CommentEntity entity = null;
        CommentDTO expResult = null;
        CommentDTO result = CommentConverter.basicEntity2DTO(entity);
        CommentDTO result2 = CommentConverter.basicEntity2DTO(new CommentEntity());
        assertNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        CommentDTO dto = null;
        CommentEntity expResult = null;
        CommentEntity result = CommentConverter.basicDTO2Entity(dto);
        CommentEntity result2 = CommentConverter.basicDTO2Entity(new CommentDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class CommentConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        CommentEntity entity = null;
        CommentDTO expResult = null;
        CommentDTO result = CommentConverter.fullEntity2DTO(entity);
        CommentDTO result2 = CommentConverter.fullEntity2DTO(new CommentEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        CommentDTO dto = null;
        CommentEntity expResult = null;
        CommentEntity result = CommentConverter.fullDTO2Entity(dto);
        CommentEntity result2 = CommentConverter.fullDTO2Entity(new CommentDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class CommentConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<CommentEntity> entities = null;
        List<CommentDTO> expResult = null;
        List<CommentDTO> result = CommentConverter.listEntity2DTO(entities);
        List<CommentDTO> result2 = CommentConverter.listEntity2DTO(new ArrayList<CommentEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<CommentDTO> dtos = null;
        List<CommentEntity> expResult = null;
        List<CommentEntity> result = CommentConverter.listDTO2Entity(dtos);
        List<CommentEntity> result2 = CommentConverter.listDTO2Entity(new ArrayList<CommentDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        CommentDTO dto = null;
        CommentEntity expResult = null;
        CommentEntity result2 = CommentConverter.childDTO2Entity(new CommentDTO(), new LongPlayEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class CommentConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<CommentDTO> dtos = null;
        LongPlayEntity parent = null;
        List<CommentEntity> expResult = null;
        List<CommentEntity> result = CommentConverter.childListDTO2Entity(dtos, parent);
        List<CommentEntity> result2 = CommentConverter.childListDTO2Entity(new ArrayList<CommentDTO>(), new LongPlayEntity());
        assertNull(dtos);
    }
    
}
