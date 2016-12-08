/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Customer;
import data.entities.Paymentmethod;
import data.entities.Product;
import data.entities.Productreview;
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

/**
 *
 * @author Steven Kritikos
 */
public class ProductReviewDAOImplTest {

  ProductReviewDAOImpl instance;
  EntityManager em;
  IDatabaseConnection con;

  @Before
  public void setUp() {
    em = Mockito.mock(EntityManager.class);
    con = Mockito.mock(IDatabaseConnection.class);
    UserTransaction utx = Mockito.mock(UserTransaction.class);
    Mockito.when(con.getConnection()).thenReturn(em);
    Mockito.when(con.getTransaction()).thenReturn(utx);
    this.instance = new ProductReviewDAOImpl(con);
    EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
    Mockito.when(em.getTransaction()).thenReturn(transaction);
  }

  @After
  public void tearDown() {
  }

  /**
   * Make sure create dbProduct returns true
   */
  @Test
  public void createTest() {
    Productreview productreview = new Productreview();
    boolean success = this.instance.create(productreview);
    assertEquals(true, success);
  }

  /**
   * Make sure delete dbProduct returns true
   */
  @Test
  public void editTest() {
    Productreview productreview = new Productreview();
    boolean success = this.instance.delete(productreview);
    assertEquals(true, success);
  }

  /**
   * Test that find returns instance of Product
   */
  @Test
  public void findTest() {
    String id = UUID.randomUUID().toString();
    Productreview dbProductreview = new Productreview(id);
    Mockito.when(em.find(Productreview.class, id)).thenReturn(dbProductreview);
    Productreview result = this.instance.find(id);
    assertEquals(result, dbProductreview);
  }

  /**
   * Test that getAll returns a list of Product
   */
  @Test
  public void getAllTest() {
    List<Productreview> dbProductreview = new ArrayList<>();
    TypedQuery query = Mockito.mock(TypedQuery.class);
    Mockito.when(query.getResultList()).thenReturn(dbProductreview);
    Mockito.when(em.createNamedQuery("Productreview.findAll")).thenReturn(query);
    List<Productreview> result = this.instance.getAll();
    assertEquals(result, dbProductreview);
  }
}
