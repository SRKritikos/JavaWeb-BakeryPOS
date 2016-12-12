/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import controllerbeans.CheckoutBean;
import controllerbeans.UserBean;
import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Paymentmethod;
import data.entities.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import services.ICateringOrderService;

/**
 *
 * @author Steven Kritikos
 */
public class CheckoutBeanTest {
  private CheckoutBean instace;
  private UserBean userbean;
  private ICateringOrderService orderservice;
  
  @Before
  public void setUp() {
    this.userbean = Mockito.mock(UserBean.class);
    this.orderservice = Mockito.mock(ICateringOrderService.class);
    this.instace = new CheckoutBean();
    this.instace.setUserbean(userbean);
    this.instace.setOrderservice(orderservice);
    
  }
  
  @After
  public void cleanUp() {
    
  }
  
  @Test
  public void testPlaceOrder() {
    Paymentmethod paymentMethod = new Paymentmethod("1");
    Cateringorder cateringorder = new Cateringorder("1");
    Mockito.when(this.userbean.getCurrentCateringOrder()).thenReturn(cateringorder);
    Mockito.when(this.userbean.getCurrentPaymentMethod()).thenReturn(paymentMethod);
    Mockito.when(this.orderservice.processOrder(Matchers.any(Cateringorder.class), Matchers.any(Paymentmethod.class)))
            .thenReturn(Boolean.TRUE);
    
  }
  
}
