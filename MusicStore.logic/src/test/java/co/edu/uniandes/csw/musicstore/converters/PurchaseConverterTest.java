/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.entities.ClientEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
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
public class PurchaseConverterTest {
    
    public PurchaseConverterTest() {
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
     * Test of refEntity2DTO method, of class PurchaseConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        PurchaseEntity entity = null;
        PurchaseDTO expResult = null;
        PurchaseDTO result = PurchaseConverter.refEntity2DTO(entity);
        PurchaseDTO result2 = PurchaseConverter.refEntity2DTO(new PurchaseEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        PurchaseDTO dto = null;
        PurchaseEntity expResult = null;
        PurchaseEntity result = PurchaseConverter.refDTO2Entity(dto);
        PurchaseEntity result2 = PurchaseConverter.refDTO2Entity(new PurchaseDTO());
        assertNull(dto);
    }

    /**
     * Test of basicDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        PurchaseDTO dto = null;
        PurchaseEntity expResult = null;
        PurchaseEntity result = PurchaseConverter.basicDTO2Entity(dto);
        PurchaseEntity result2 = PurchaseConverter.basicDTO2Entity(new PurchaseDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class PurchaseConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        PurchaseEntity entity = null;
        PurchaseDTO expResult = null;
        PurchaseDTO result = PurchaseConverter.fullEntity2DTO(entity);
        PurchaseDTO result2 = PurchaseConverter.fullEntity2DTO(new PurchaseEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        PurchaseDTO dto = null;
        PurchaseEntity expResult = null;
        PurchaseEntity result = PurchaseConverter.fullDTO2Entity(dto);
        PurchaseEntity result2 = PurchaseConverter.fullDTO2Entity(new PurchaseDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class PurchaseConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<PurchaseEntity> entities = null;
        List<PurchaseDTO> expResult = null;
        List<PurchaseDTO> result = PurchaseConverter.listEntity2DTO(entities);
        List<PurchaseDTO> result2 = PurchaseConverter.listEntity2DTO(new ArrayList<PurchaseEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<PurchaseDTO> dtos = null;
        List<PurchaseEntity> expResult = null;
        List<PurchaseEntity> result = PurchaseConverter.listDTO2Entity(dtos);
        List<PurchaseEntity> result2 = PurchaseConverter.listDTO2Entity(new ArrayList<PurchaseDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        PurchaseDTO dto = null;
        ClientEntity parent = null;
        PurchaseEntity expResult = null;
        PurchaseEntity result = PurchaseConverter.childDTO2Entity(new PurchaseDTO(), new ClientEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class PurchaseConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<PurchaseDTO> dtos = null;
        ClientEntity parent = null;
        List<PurchaseEntity> expResult = null;
        List<PurchaseEntity> result = PurchaseConverter.childListDTO2Entity(dtos, parent);
        List<PurchaseEntity> result2 = PurchaseConverter.childListDTO2Entity(new ArrayList<PurchaseDTO>(), new ClientEntity());
        assertNull(dtos);
    }
    
}
