/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.ProviderEntity;
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
public class LongPlayConverterTest {
    
    public LongPlayConverterTest() {
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
     * Test of refEntity2DTO method, of class LongPlayConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        LongPlayEntity entity = null;
        LongPlayDTO expResult = null;
        LongPlayDTO result = LongPlayConverter.refEntity2DTO(entity);
        LongPlayDTO result2 = LongPlayConverter.refEntity2DTO(new LongPlayEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class LongPlayConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        LongPlayDTO dto = null;
        LongPlayEntity expResult = null;
        LongPlayEntity result = LongPlayConverter.refDTO2Entity(dto);
        LongPlayEntity result2 = LongPlayConverter.refDTO2Entity(new LongPlayDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class LongPlayConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        LongPlayEntity entity = null;
        LongPlayDTO expResult = null;
        LongPlayDTO result = LongPlayConverter.fullEntity2DTO(entity);
        LongPlayDTO result2 = LongPlayConverter.fullEntity2DTO(new LongPlayEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class LongPlayConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        LongPlayDTO dto = null;
        LongPlayEntity expResult = null;
        LongPlayEntity result = LongPlayConverter.fullDTO2Entity(dto);
        LongPlayEntity result2 = LongPlayConverter.fullDTO2Entity(new LongPlayDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class LongPlayConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<LongPlayEntity> entities = null;
        List<LongPlayDTO> expResult = null;
        List<LongPlayDTO> result = LongPlayConverter.listEntity2DTO(entities);
        List<LongPlayDTO> result2 = LongPlayConverter.listEntity2DTO(new ArrayList<LongPlayEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class LongPlayConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<LongPlayDTO> dtos = null;
        List<LongPlayEntity> expResult = null;
        List<LongPlayEntity> result = LongPlayConverter.listDTO2Entity(dtos);
        List<LongPlayEntity> result2 = LongPlayConverter.listDTO2Entity(new ArrayList<LongPlayDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class LongPlayConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        LongPlayDTO dto = null;
        ProviderEntity parent = null;
        LongPlayEntity expResult = null;
        LongPlayEntity result = LongPlayConverter.childDTO2Entity(new LongPlayDTO(), new ProviderEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class LongPlayConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<LongPlayDTO> dtos = null;
        ProviderEntity parent = null;
        List<LongPlayEntity> expResult = null;
        List<LongPlayEntity> result = LongPlayConverter.childListDTO2Entity(dtos, parent);
        List<LongPlayEntity> result2 = LongPlayConverter.childListDTO2Entity(new ArrayList<LongPlayDTO>(), new ProviderEntity());
        assertNull(dtos);
    }
    
}
