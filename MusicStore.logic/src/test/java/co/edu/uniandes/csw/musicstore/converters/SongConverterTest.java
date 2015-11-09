/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.SongEntity;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author c.baquero10
 */
@RunWith(Arquillian.class)
public class SongConverterTest {
    
    public SongConverterTest() {
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
     * Test of refEntity2DTO method, of class SongConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        SongEntity entity = null;
        SongDTO expResult = null;
        SongDTO result = SongConverter.refEntity2DTO(entity);
        SongDTO result2 = SongConverter.refEntity2DTO(new SongEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        SongDTO dto = null;
        SongEntity expResult = null;
        SongEntity result = SongConverter.refDTO2Entity(dto);
        SongEntity result2 = SongConverter.refDTO2Entity(new SongDTO());
        assertNull(dto);
    }

    /**
     * Test of basicDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        SongDTO dto = null;
        SongEntity expResult = null;
        SongEntity result = SongConverter.basicDTO2Entity(dto);
        SongEntity result2 = SongConverter.basicDTO2Entity(new SongDTO());
        assertEquals(expResult, result);
    }

    /**
     * Test of fullEntity2DTO method, of class SongConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        SongEntity entity = null;
        SongDTO expResult = null;
        SongDTO result = SongConverter.fullEntity2DTO(entity);
        SongDTO result2 = SongConverter.fullEntity2DTO(new SongEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        SongDTO dto = null;
        SongEntity expResult = null;
        SongEntity result = SongConverter.fullDTO2Entity(dto);
        SongEntity result2 = SongConverter.fullDTO2Entity(new SongDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class SongConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<SongEntity> entities = null;
        List<SongDTO> expResult = null;
        List<SongDTO> result = SongConverter.listEntity2DTO(entities);
        List<SongDTO> result2 = SongConverter.listEntity2DTO(new ArrayList<SongEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<SongDTO> dtos = null;
        List<SongEntity> expResult = null;
        List<SongEntity> result = SongConverter.listDTO2Entity(dtos);
        List<SongEntity> result2 = SongConverter.listDTO2Entity(new ArrayList<SongDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        SongDTO dto = null;
        LongPlayEntity parent = null;
        SongEntity expResult = null;
        SongEntity result = SongConverter.childDTO2Entity(new SongDTO(), new LongPlayEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class SongConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<SongDTO> dtos = null;
        LongPlayEntity parent = null;
        List<SongEntity> expResult = null;
        List<SongEntity> result = SongConverter.childListDTO2Entity(new ArrayList<SongDTO>(), new LongPlayEntity());
        assertNull(dtos);
    }
    
}
