/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
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
public class PurchaseDetailConverterTest {
    
    public PurchaseDetailConverterTest() {
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
     * Test of refEntity2DTO method, of class PurchaseDetailConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        PurchaseDetailEntity entity = null;
        PurchaseDetailDTO expResult = null;
        PurchaseDetailDTO result = PurchaseDetailConverter.refEntity2DTO(entity);
        PurchaseDetailDTO result2 = PurchaseDetailConverter.refEntity2DTO(new PurchaseDetailEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        PurchaseDetailDTO dto = null;
        PurchaseDetailEntity expResult = null;
        PurchaseDetailEntity result = PurchaseDetailConverter.refDTO2Entity(dto);
        PurchaseDetailEntity result2 = PurchaseDetailConverter.refDTO2Entity(new PurchaseDetailDTO());
        assertNull(dto);
    }

    /**
     * Test of basicDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        PurchaseDetailDTO dto = null;
        PurchaseDetailEntity expResult = null;
        PurchaseDetailEntity result = PurchaseDetailConverter.basicDTO2Entity(dto);
        PurchaseDetailEntity result2 = PurchaseDetailConverter.basicDTO2Entity(new PurchaseDetailDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class PurchaseDetailConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        PurchaseDetailEntity entity = null;
        PurchaseDetailDTO expResult = null;
        PurchaseDetailDTO result = PurchaseDetailConverter.fullEntity2DTO(entity);
        PurchaseDetailDTO result2 = PurchaseDetailConverter.fullEntity2DTO(new PurchaseDetailEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        PurchaseDetailDTO dto = null;
        PurchaseDetailEntity expResult = null;
        PurchaseDetailEntity result = PurchaseDetailConverter.fullDTO2Entity(dto);
        PurchaseDetailEntity result2 = PurchaseDetailConverter.fullDTO2Entity(new PurchaseDetailDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class PurchaseDetailConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<PurchaseDetailEntity> entities = null;
        List<PurchaseDetailDTO> expResult = null;
        List<PurchaseDetailDTO> result = PurchaseDetailConverter.listEntity2DTO(entities);
        List<PurchaseDetailDTO> result2 = PurchaseDetailConverter.listEntity2DTO(new ArrayList<PurchaseDetailEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<PurchaseDetailDTO> dtos = null;
        List<PurchaseDetailEntity> expResult = null;
        List<PurchaseDetailEntity> result = PurchaseDetailConverter.listDTO2Entity(dtos);
        List<PurchaseDetailEntity> result2 = PurchaseDetailConverter.listDTO2Entity(new ArrayList<PurchaseDetailDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        PurchaseDetailDTO dto = null;
        PurchaseEntity parent = null;
        PurchaseDetailEntity expResult = null;
        PurchaseDetailEntity result = PurchaseDetailConverter.childDTO2Entity(new PurchaseDetailDTO(), new PurchaseEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class PurchaseDetailConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<PurchaseDetailDTO> dtos = null;
        PurchaseEntity parent = null;
        List<PurchaseDetailEntity> expResult = null;
        List<PurchaseDetailEntity> result = PurchaseDetailConverter.childListDTO2Entity(new ArrayList<PurchaseDetailDTO>(), new PurchaseEntity());
        assertNull(dtos);
    }
    
}
