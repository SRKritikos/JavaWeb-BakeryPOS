/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import services.ICateringOrderService;
import services.ICustomerService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Steven Kritikos
 */
public class UserBeantest {

  private UserBean instance;
  private ICustomerService customerservice;
  private ICateringOrderService orderservice;

  @Before
  public void setUp() {
    this.instance = new UserBean();
    this.customerservice = Mockito.mock(ICustomerService.class);
    this.orderservice = Mockito.mock(ICateringOrderService.class);
    this.instance.setCustomerservice(customerservice);
    this.instance.setOrderservice(orderservice);
  }

  @Test
  public void testSetAndGetCustomer() {
    Customer expectedResult = new Customer("1");
    this.instance.setCustomer(expectedResult);
    Customer result = this.instance.getCustomer();
    assertEquals(expectedResult, result);
  }

  @Test
  public void testSetAndGetCateringOrder() {
    Cateringorder expectedResult = new Cateringorder("1");
    this.instance.setCurrentCateringOrder(expectedResult);
    Cateringorder result = this.instance.getCurrentCateringOrder();
    assertEquals(expectedResult, result);
  }

  @Test
  public void testSetAndGetCartTotal() {
    Double expectedResult = 1D;
    this.instance.setCartTotal(expectedResult);
    Double result = this.instance.getCartTotal();
    assertEquals(expectedResult, result);
  }

  @Test
  public void testUpdateCustomerOrder() {
    Cateringorder expectedResult = new Cateringorder("1");
    Mockito.when(this.orderservice.createNewCateringOrder(Matchers.any(Date.class), Matchers.isNull(Date.class), Matchers.isNull(Paymentmethod.class), Matchers.any(Customer.class), Matchers.anyListOf(CateringorderProduct.class)))
            .thenReturn(expectedResult);
    Customer customer = this.instance.getCustomer();
    Mockito.when(customer.getCateringorderList()).thenReturn(new ArrayList<Cateringorder>());
    assertNotNull(this.instance.getCurrentCateringOrder());
  }
}
