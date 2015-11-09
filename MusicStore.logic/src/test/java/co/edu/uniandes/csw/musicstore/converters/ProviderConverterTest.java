/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.ProviderDTO;
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
public class ProviderConverterTest {
    
    public ProviderConverterTest() {
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
     * Test of refEntity2DTO method, of class ProviderConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ProviderEntity entity = null;
        ProviderDTO expResult = null;
        ProviderDTO result = ProviderConverter.refEntity2DTO(entity);
        ProviderDTO result2 = ProviderConverter.refEntity2DTO(new ProviderEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ProviderConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ProviderDTO dto = null;
        ProviderEntity expResult = null;
        ProviderEntity result = ProviderConverter.refDTO2Entity(dto);
        ProviderEntity result2 = ProviderConverter.refDTO2Entity(new ProviderDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ProviderConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ProviderEntity entity = null;
        ProviderDTO expResult = null;
        ProviderDTO result = ProviderConverter.fullEntity2DTO(entity);
        ProviderDTO result2 = ProviderConverter.fullEntity2DTO(new ProviderEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ProviderConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ProviderDTO dto = null;
        ProviderEntity expResult = null;
        ProviderEntity result = ProviderConverter.fullDTO2Entity(dto);
        ProviderEntity result2 = ProviderConverter.fullDTO2Entity(new ProviderDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ProviderConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ProviderEntity> entities = null;
        List<ProviderDTO> expResult = null;
        List<ProviderDTO> result = ProviderConverter.listEntity2DTO(entities);
        List<ProviderDTO> result2 = ProviderConverter.listEntity2DTO(new ArrayList<ProviderEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ProviderConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ProviderDTO> dtos = null;
        List<ProviderEntity> expResult = null;
        List<ProviderEntity> result = ProviderConverter.listDTO2Entity(dtos);
        List<ProviderEntity> result2 = ProviderConverter.listDTO2Entity(new ArrayList());
        assertNull(dtos);
    }
    
}
