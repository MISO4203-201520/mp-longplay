/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;

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
 * @author if.garcia11
 */
@RunWith(Arquillian.class)
public class UserDTOTest {
    
    public UserDTOTest() {
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
     * Test of getName method, of class UserDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getName();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setName method, of class UserDTO.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserDTO instance = new UserDTO();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUserName method, of class UserDTO.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getUserName();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUserName method, of class UserDTO.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        UserDTO instance = new UserDTO();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassword method, of class UserDTO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getPassword();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPassword method, of class UserDTO.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserDTO instance = new UserDTO();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class UserDTO.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getEmail();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class UserDTO.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserDTO instance = new UserDTO();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isRememberMe method, of class UserDTO.
     */
    @Test
    public void testIsRememberMe() {
        System.out.println("isRememberMe");
        UserDTO instance = new UserDTO();
        boolean expResult = false;
        boolean result = instance.isRememberMe();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRememberMe method, of class UserDTO.
     */
    @Test
    public void testSetRememberMe() {
        System.out.println("setRememberMe");
        boolean rememberMe = false;
        UserDTO instance = new UserDTO();
        instance.setRememberMe(rememberMe);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRole method, of class UserDTO.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getRole();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRole method, of class UserDTO.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        UserDTO instance = new UserDTO();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastName method, of class UserDTO.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        UserDTO instance = new UserDTO();
        String expResult = "";
        String result = instance.getLastName();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setLastName method, of class UserDTO.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        UserDTO instance = new UserDTO();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
