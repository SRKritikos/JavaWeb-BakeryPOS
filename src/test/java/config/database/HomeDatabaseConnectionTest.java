/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Steven
 */
public class HomeDatabaseConnectionTest {
    EntityManager em;
    HomeDatabaseConnection instance;
    public HomeDatabaseConnectionTest() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class HomeDatabaseConnection.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");      
        em = Mockito.mock(EntityManager.class);
        instance = new HomeDatabaseConnection();
        instance.setEm(em);
        EntityManager result = instance.getConnection();
        assertNotNull(result);
    }
    
}
