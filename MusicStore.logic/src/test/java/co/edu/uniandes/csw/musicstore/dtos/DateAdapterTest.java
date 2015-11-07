/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;

import java.util.Date;
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
public class DateAdapterTest {
    
    public DateAdapterTest() {
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
     * Test of unmarshal method, of class DateAdapter.
     */
    @Test
    public void testUnmarshal() throws Exception {
        System.out.println("unmarshal");
        String v = "1990-12-1";
        DateAdapter instance = new DateAdapter();
        Date expResult = null;
        Date result = instance.unmarshal(v);
        assertNotNull(v);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of marshal method, of class DateAdapter.
     */
    @Test
    public void testMarshal() throws Exception {
        System.out.println("marshal");
        Date v = new Date();
        DateAdapter instance = new DateAdapter();
        String expResult = "";
        String result = instance.marshal(v);
        assertNotNull(v);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
