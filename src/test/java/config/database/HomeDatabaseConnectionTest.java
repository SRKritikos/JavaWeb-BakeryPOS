/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
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
    UserTransaction utx;
    public HomeDatabaseConnectionTest() {
    }
    
    @Before
    public void setUp() {
        em = Mockito.mock(EntityManager.class);
        utx = Mockito.mock(UserTransaction.class);
        instance = new HomeDatabaseConnection();
        instance.setUtx(utx);
        instance.setEm(em);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class HomeDatabaseConnection.
     * Make sure em is not null
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");      
        EntityManager result = instance.getConnection();
        assertNotNull(result);
    }
    
    
    @Test
    public void testGetTransaction() {
        System.out.println("getTransaction");
        UserTransaction result = instance.getTransaction();
        assertNotNull(result);
    }
}
