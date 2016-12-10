/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import controllerbeans.PaymentMethodBean;
import controllerbeans.UserBean;
import data.entities.Customer;
import data.entities.Paymentmethod;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import services.IPaymentMethodService;

/**
 *
 * @author Steven Kritikos
 */
public class PaymentMethodBeanTest {
  private PaymentMethodBean instance;
  private IPaymentMethodService paymentService;
  private UserBean userBean;
  
  @Before
  public void setUp() {
    this.paymentService = Mockito.mock(IPaymentMethodService.class);
    this.userBean= Mockito.mock(UserBean.class);
    this.instance = new PaymentMethodBean();
    this.instance.setPaymentService(paymentService);
    this.instance.setUserbean(userBean);
  }
  
  @After
  public void cleanUp() {
    
  }
  
  @Test
  public void testSetAndGetCardNumer() {
    String expectedResult = "12343";
    this.instance.setCardNumber(expectedResult);
    String result = this.instance.getCardNumber();
    assertEquals(expectedResult, result);
  }
  
  @Test
  public void testSetAndGetCVV() {
    String expectedResult = "123";
    this.instance.setCardCVV(expectedResult);
    String result = this.instance.getCardCVV();
    assertEquals(expectedResult, result);
  }
  
  @Test
  public void testSetAndGetExpiryMonth() {
    String expectedResult = "05";
    this.instance.setExpiryMonth(expectedResult);
    String result = this.instance.getExpiryMonth();
    assertEquals(expectedResult, result);
  }
  
  @Test
  public void testSetAndGetExpiryYear() {
    String expectedResult = "16";
    this.instance.setExpiryYear(expectedResult);
    String result = this.instance.getExpiryYear();
    assertEquals(expectedResult, result);
  }
  
  @Test
  public void testaddPaymentMethod() {
    String expectedResult = "checkout.xhtml";
    Mockito.when(this.paymentService.addNewPaymentForCustomer(
            Matchers.any(Customer.class), Matchers.anyString(), Matchers.anyString(), Matchers.anyString()))
            .thenReturn(new Paymentmethod("1"));
    String result = this.instance.addPaymentMethod();
    assertEquals(expectedResult, result);
  }
  
  @Test
  public void testSetAndGetPaymentType() {
    String expectedResult = "VISA";
    this.instance.setPaymentType(expectedResult);
    String result = this.instance.getPaymentType();
    assertEquals(expectedResult, result);
  }
}
