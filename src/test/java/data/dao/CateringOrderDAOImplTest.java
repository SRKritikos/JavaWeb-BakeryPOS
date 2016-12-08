/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Cateringorder;
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
public class CateringOrderDAOImplTest {

  CateringOrderDAOImpl instance;
  EntityManager em;
  IDatabaseConnection con;

  @Before
  public void setUp() {
    em = Mockito.mock(EntityManager.class);
    con = Mockito.mock(IDatabaseConnection.class);
    UserTransaction utx = Mockito.mock(UserTransaction.class);
    Mockito.when(con.getConnection()).thenReturn(em);
    Mockito.when(con.getTransaction()).thenReturn(utx);
    this.instance = new CateringOrderDAOImpl(con);
    EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
    Mockito.when(em.getTransaction()).thenReturn(transaction);

  }

  @After
  public void tearDown() {
  }

  /**
   * Make sure create dbCateringOrder returns true
   */
  @Test
  public void createTest() {
    Cateringorder cateringOrder = new Cateringorder();
    boolean success = this.instance.create(cateringOrder);
    assertEquals(true, success);
  }

  /**
   * Make sure delete dbCateringOrder returns true
   */
  @Test
  public void editTest() {
    Cateringorder cateringOrder = new Cateringorder();
    boolean success = this.instance.delete(cateringOrder);
    assertEquals(true, success);
  }

  /**
   * Test that find returns an instance of Cateringorder
   */
  @Test
  public void findTest() {
    String id = UUID.randomUUID().toString();
    Cateringorder dbCateringOrder = new Cateringorder(id);
    Mockito.when(em.find(Cateringorder.class, id)).thenReturn(dbCateringOrder);
    Cateringorder result = this.instance.find(id);
    assertEquals(result, dbCateringOrder);
  }

  /**
   * Test that getAll returns an array list of Cateringorder
   */
  @Test
  public void getAllTest() {
    List<Cateringorder> dbCateringOrder = new ArrayList<>();
    TypedQuery query = Mockito.mock(TypedQuery.class);
    Mockito.when(query.getResultList()).thenReturn(dbCateringOrder);
    Mockito.when(em.createNamedQuery("Cateringorder.findAll")).thenReturn(query);
    List<Cateringorder> result = this.instance.getAll();
    assertEquals(result, dbCateringOrder);
  }
}
