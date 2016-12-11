/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import config.PaymentMethod;
import data.dao.PaymentDAOImpl;
import data.dao.PaymentMethodDAOImplTest;
import data.entities.Customer;
import data.entities.Paymentmethod;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 *
 * @author Steven Kritikos
 */
public class PaymentMethodServiceTest {
  private PaymentMethodService instance;
  private PaymentDAOImpl paymentDAO;
  
  @Before
  public void setUp() {
    this.instance = new PaymentMethodService();
    this.paymentDAO = Mockito.mock(PaymentDAOImpl.class);
    this.instance.setPaymentDAO(paymentDAO);
  }
  
  @After
  public void cleanUp() {
    
  }
  
  @Test 
  public void testAddNewPaymentForCustomer() {
    Mockito.when(this.paymentDAO.create(Matchers.any(Paymentmethod.class))).thenReturn(Boolean.TRUE);
    Paymentmethod result = this.instance.addNewPaymentForCustomer(new Customer("1"), "1234", "111", "1216", true, PaymentMethod.Visa);
    assertNotNull(result);
  }
}
