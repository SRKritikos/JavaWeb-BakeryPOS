/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Steven Kritikos
 */
public class CustomerDAOImplTest {
    CustomerDAOImpl instance;
    EntityManager em;
    IDatabaseConnection con;
    
    @Before
    public void setUp() {
        em = Mockito.mock(EntityManager.class);
        con = Mockito.mock(IDatabaseConnection.class);
        UserTransaction utx = Mockito.mock(UserTransaction.class);
        Mockito.when(con.getConnection()).thenReturn(em);
        Mockito.when(con.getTransaction()).thenReturn(utx);
        this.instance = new CustomerDAOImpl(con);
        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(em.getTransaction()).thenReturn(transaction);
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    /**
     * Make sure create dbCustomer returns true
     */
    @Test
    public void createTest() {
        Customer customer = new Customer();
        boolean success = this.instance.create(customer);
        assertEquals(true, success);
    }
    
    /**
     * Make sure delete dbCustomer returns true
     */
    @Test
    public void editTest() {
        Customer customer =  new Customer();
        boolean success = this.instance.delete(customer);
        assertEquals(true, success);
    }
    
    /**
     * Test that find returns instance of Customer
     */
    @Test
    public void findTest() {
        String id = UUID.randomUUID().toString();
        Customer dbCustomer = new Customer(id);
        Mockito.when(em.find(Customer.class, id)).thenReturn(dbCustomer);
        Customer result = this.instance.find(id);
        assertEquals(result, dbCustomer);
    }
    
    /**
     * Test that getAll returns a list of Customer
     */
    @Test
    public void getAllTest() {
        List<Customer> dbCustomers = new ArrayList<>();
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(query.getResultList()).thenReturn(dbCustomers);
        Mockito.when(em.createNamedQuery("Customer.findAll")).thenReturn(query);
        List<Customer> result = this.instance.getAll();
        assertEquals(result, dbCustomers);
    }
    
}
