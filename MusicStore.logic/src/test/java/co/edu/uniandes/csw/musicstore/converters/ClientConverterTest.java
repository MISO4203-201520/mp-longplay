/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
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
public class ClientConverterTest {
    
    public ClientConverterTest() {
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
     * Test of refEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ClientEntity entity = null;
        ClientDTO expResult = null;
        ClientDTO result = ClientConverter.refEntity2DTO(entity);
        ClientDTO result2 = ClientConverter.refEntity2DTO(new ClientEntity());
        assertNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ClientDTO dto = null;
        ClientEntity expResult = null;
        ClientEntity result = ClientConverter.refDTO2Entity(dto);
        ClientEntity result2 = ClientConverter.refDTO2Entity(new ClientDTO());
        assertNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ClientEntity entity = null;
        ClientDTO expResult = null;
        ClientDTO result = ClientConverter.fullEntity2DTO(entity);
        ClientDTO result2 = ClientConverter.fullEntity2DTO(new ClientEntity());
        assertNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ClientDTO dto = null;
        ClientEntity expResult = null;
        ClientEntity result = ClientConverter.fullDTO2Entity(dto);
        ClientEntity result2 = ClientConverter.fullDTO2Entity(new ClientDTO());
        assertNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ClientEntity> entities = null;
        List<ClientDTO> expResult = null;
        List<ClientDTO> result = ClientConverter.listEntity2DTO(entities);
        List<ClientDTO> result2 = ClientConverter.listEntity2DTO(new ArrayList<ClientEntity>());
        assertNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ClientDTO> dtos = null;
        List<ClientEntity> expResult = null;
        List<ClientEntity> result = ClientConverter.listDTO2Entity(dtos);
        List<ClientEntity> result2 = ClientConverter.listDTO2Entity(new ArrayList<ClientDTO>());
        assertNull(dtos);
    }
    
}
