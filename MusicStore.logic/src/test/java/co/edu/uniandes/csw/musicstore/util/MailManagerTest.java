/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.util;

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
public class MailManagerTest {
    
    public MailManagerTest() {
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
     * Test of generateAndSendEmail method, of class MailManager.
     */
    @Test
    public void testGenerateAndSendEmail() {
        System.out.println("generateAndSendEmail");
        String message = "";
        String emailRecipient = "";
        String subject = "";
        MailManager.generateAndSendEmail(message, emailRecipient, subject);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
