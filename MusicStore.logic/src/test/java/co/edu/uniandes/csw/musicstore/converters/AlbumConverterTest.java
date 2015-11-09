/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
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
public class AlbumConverterTest {
    
    public AlbumConverterTest() {
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
     * Test of refEntity2DTO method, of class AlbumConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        AlbumEntity entity = null;
        AlbumDTO expResult = null;
        AlbumDTO result = AlbumConverter.refEntity2DTO(entity);
        AlbumDTO result2 = AlbumConverter.refEntity2DTO(new AlbumEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class AlbumConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        AlbumDTO dto = null;
        AlbumEntity expResult = null;
        AlbumEntity result = AlbumConverter.refDTO2Entity(dto);
        AlbumEntity result2 = AlbumConverter.refDTO2Entity(new AlbumDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class AlbumConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        AlbumEntity entity = null;
        AlbumDTO expResult = null;
        AlbumDTO result = AlbumConverter.fullEntity2DTO(entity);
        AlbumDTO result2 = AlbumConverter.fullEntity2DTO(new AlbumEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class AlbumConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        AlbumDTO dto = null;
        AlbumEntity expResult = null;
        AlbumEntity result = AlbumConverter.fullDTO2Entity(dto);
        AlbumEntity result2 = AlbumConverter.fullDTO2Entity(new AlbumDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class AlbumConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<AlbumEntity> entities = null;
        List<AlbumDTO> expResult = null;
        List<AlbumDTO> result = AlbumConverter.listEntity2DTO(entities);
        List<AlbumDTO> result2 = AlbumConverter.listEntity2DTO(new ArrayList<AlbumEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class AlbumConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<AlbumDTO> dtos = null;
        List<AlbumEntity> expResult = null;
        List<AlbumEntity> result = AlbumConverter.listDTO2Entity(dtos);
        List<AlbumEntity> result2 = AlbumConverter.listDTO2Entity(new ArrayList<AlbumDTO>());
        assertNull(dtos);
    }
    
}
