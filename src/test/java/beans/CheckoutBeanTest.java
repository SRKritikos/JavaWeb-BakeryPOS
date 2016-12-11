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
import org.mockito.Mockito;

/**
 *
 * @author Steven Kritikos
 */
public class CheckoutBeanTest {
  private CheckoutBean instace;
  private UserBean userbean;
  
  @Before
  public void setUp() {
    this.userbean = Mockito.mock(UserBean.class);
    this.instace = new CheckoutBean();
    this.instace.setUserbean(userbean);
  }
  
  @After
  public void cleanUp() {
    
  }
  
  @Test
  public void testInit() {
//    Product p1 = new Product("1");
//    p1.setPrice(BigDecimal.ONE);
//    Cateringorder co1 = new Cateringorder("1");
//    CateringorderProduct cop1 = new CateringorderProduct(p1.getProductId(), co1.getCateringId());
//    cop1.setQuantity(1);
//    Product p2 = new Product("2");
//    p1.setPrice(BigDecimal.ONE);
//    Cateringorder co2 = new Cateringorder("2");
//    CateringorderProduct cop2 = new CateringorderProduct(p2.getProductId(), co2.getCateringId());
//    cop2.setQuantity(1);
//    List<CateringorderProduct> copList = Arrays.asList(cop1, cop2);
//    Cateringorder order = new Cateringorder("3");
//    order.setCateringorderProductList(copList);
//    order.getCateringorderProductList().stream().filter(cop -> cop.getProduct().equals(p1));
//    Mockito.when(this.userbean.getCurrentPaymentMethod()).thenReturn(new Paymentmethod("1"));
//    Mockito.when(this.userbean.getCurrentCateringOrder()).thenReturn(order);
//    this.instace.init();
//    assertNotNull(this.instace.getTaxCalculated());
//    assertNotNull(this.instace.getFinalTotalAmount());
//    assertNotNull(this.instace.getConfirmOrdersModel());
  }
  
}
