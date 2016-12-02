package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steven Kritikos
 */
public class PaymentMethodDAOImplTest {
    PaymentDAOImpl instance;
    EntityManager em;
    IDatabaseConnection con;
    
    @Before
    public void setUp() {
        em = Mockito.mock(EntityManager.class);
        con = Mockito.mock(IDatabaseConnection.class);
        UserTransaction utx = Mockito.mock(UserTransaction.class);
        Mockito.when(con.getConnection()).thenReturn(em);
        Mockito.when(con.getTransaction()).thenReturn(utx);
        this.instance = new PaymentDAOImpl(con);
        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(em.getTransaction()).thenReturn(transaction);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Make sure create dbPaymentMetthod returns true
     */
    @Test
    public void createTest() {
        Paymentmethod paymentMethod = new Paymentmethod();
        boolean success = this.instance.create(paymentMethod);
        assertEquals(true, success);
    }
    
    /**
     * Make sure delete dbPaymentmethod returns true
     */
    @Test
    public void editTest() {
        Paymentmethod paymentMethod =  new Paymentmethod();
        boolean success = this.instance.delete(paymentMethod);
        assertEquals(true, success);
    }
    
    /**
     * Test that find returns instance of Paymentmethod
     */
    @Test
    public void findTest() {
        String id = UUID.randomUUID().toString();
        Paymentmethod dbPaymentmethod = new Paymentmethod(id);
        Mockito.when(em.find(Paymentmethod.class, id)).thenReturn(dbPaymentmethod);
        Paymentmethod result = this.instance.find(id);
        assertEquals(result, dbPaymentmethod);
    }
    
    /**
     * Test that getAll returns a list of Paymentmethod
     */
    @Test
    public void getAllTest() {
        List<Paymentmethod> dbPaymentmethod = new ArrayList<>();
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(query.getResultList()).thenReturn(dbPaymentmethod);
        Mockito.when(em.createNamedQuery("Paymentmethod.findAll")).thenReturn(query);
        List<Paymentmethod> result = this.instance.getAll();
        assertEquals(result, dbPaymentmethod);
    }
}
