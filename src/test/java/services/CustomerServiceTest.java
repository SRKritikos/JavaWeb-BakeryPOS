/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.dao.CustomerDAOImpl;
import data.entities.Customer;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Steven Kritikos
 */
public class CustomerServiceTest {

  private CustomerService instance;
  private CustomerDAOImpl customerDAO;

  @Before
  public void setUp() {
    this.customerDAO = Mockito.mock(CustomerDAOImpl.class);
    this.instance = new CustomerService();
    this.instance.setCustomerDAO(customerDAO);
  }

  @After
  public void cleanUp() {

  }

  @Test
  public void testSaveCustomer() {
    Customer c = new Customer("1");
    Mockito.when(this.customerDAO.edit(c)).thenReturn(true);
    boolean result = this.instance.saveCustomer(c);
    assertTrue(result);
  }

  @Test
  public void testGetCustomerById() {
    Customer expectedValue = new Customer("1");
    Mockito.when(this.customerDAO.find("1")).thenReturn(expectedValue);
    Customer result = this.instance.getCustomerById(expectedValue.getCustomerId());
    assertEquals(expectedValue, result);
  }

}
