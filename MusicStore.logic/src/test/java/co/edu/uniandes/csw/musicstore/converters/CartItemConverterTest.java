/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.CartItemDTO;
import co.edu.uniandes.csw.musicstore.entities.CartItemEntity;
import co.edu.uniandes.csw.musicstore.entities.ClientEntity;
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
public class CartItemConverterTest {
    
    public CartItemConverterTest() {
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
     * Test of refEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        CartItemEntity entity = null;
        CartItemDTO expResult = null;
        CartItemDTO result = CartItemConverter.refEntity2DTO(entity);
        CartItemDTO result2 = CartItemConverter.refEntity2DTO(new CartItemEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        CartItemDTO dto = null;
        CartItemEntity expResult = null;
        CartItemEntity result = CartItemConverter.refDTO2Entity(dto);
        CartItemEntity result2 = CartItemConverter.refDTO2Entity(new CartItemDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        CartItemEntity entity = null;
        CartItemDTO expResult = null;
        CartItemDTO result = CartItemConverter.fullEntity2DTO(entity);
        CartItemDTO result2 = CartItemConverter.fullEntity2DTO(new CartItemEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        CartItemDTO dto = null;
        CartItemEntity expResult = null;
        CartItemEntity result = CartItemConverter.fullDTO2Entity(dto);
        CartItemEntity result2 = CartItemConverter.fullDTO2Entity(new CartItemDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<CartItemEntity> entities = null;
        List<CartItemDTO> expResult = null;
        List<CartItemDTO> result = CartItemConverter.listEntity2DTO(entities);
        List<CartItemDTO> result2 = CartItemConverter.listEntity2DTO(new ArrayList<CartItemEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<CartItemDTO> dtos = null;
        List<CartItemEntity> expResult = null;
        List<CartItemEntity> result = CartItemConverter.listDTO2Entity(dtos);
        List<CartItemEntity> result2 = CartItemConverter.listDTO2Entity(new ArrayList<CartItemDTO>());
        assertNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        CartItemDTO dto = null;
        ClientEntity parent = null;
        CartItemEntity expResult = null;
        CartItemEntity result = CartItemConverter.childDTO2Entity(new CartItemDTO(), new ClientEntity());
        assertNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<CartItemDTO> dtos = null;
        ClientEntity parent = null;
        List<CartItemEntity> expResult = null;
        List<CartItemEntity> result = CartItemConverter.childListDTO2Entity(dtos, parent);
        List<CartItemEntity> result2 = CartItemConverter.childListDTO2Entity(new ArrayList<CartItemDTO>(), new ClientEntity());
        assertNull(dtos);
    }
    
}
