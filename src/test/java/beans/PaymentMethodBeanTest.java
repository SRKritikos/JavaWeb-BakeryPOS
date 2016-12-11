/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import config.PaymentMethod;
import controllerbeans.PaymentMethodBean;
import controllerbeans.UserBean;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import services.ICustomerService;
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
    Paymentmethod paymentMethod = new Paymentmethod("1");
    String expectedResult = "checkout.xhtml";
    List<Paymentmethod> paymentMethods = Arrays.asList(paymentMethod);
    Customer customer = new Customer("1");
    customer.setPaymentmethodList(paymentMethods);
    this.instance.setPaymentType("Visa");
    Mockito.when(this.paymentService.addNewPaymentForCustomer(
            Matchers.any(Customer.class), Matchers.anyString(), Matchers.anyString(), Matchers.anyString(), Matchers.anyBoolean(), Matchers.any(PaymentMethod.class)))
            .thenReturn(paymentMethod);
    Mockito.when(this.paymentService.getPaymentMethodsForCustomer(Matchers.any(Customer.class))).thenReturn(paymentMethods);
    Mockito.when(this.userBean.getCustomer()).thenReturn(customer);
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
  
  @Test
  public void testInit() {
    String expectedCVV = "111";
    Date date = new Date();
    String expectedCardNumber = "123456";
    String expectedPaymentType = "Visa";
    Paymentmethod paymentMethod =  new Paymentmethod("1");
    paymentMethod.setIsPreferred(Boolean.TRUE);
    paymentMethod.setPaymentType(expectedCVV);
    paymentMethod.setCardCvv(expectedPaymentType);
    paymentMethod.setCardNumber(expectedCardNumber);
    paymentMethod.setDateTo(date);
    Mockito.when(this.userBean.getCurrentPaymentMethod()).thenReturn(paymentMethod);
    this.instance.init();
    assertNotNull(this.instance.getCardCVV());
    assertNotNull(this.instance.getCardNumber());
    assertNotNull(this.instance.getExpiryMonth());
    assertNotNull(this.instance.getExpiryYear());
    assertNotNull(this.instance.getPaymentType());
    assertTrue(this.instance.isIsPrefered());
   
  }
}
