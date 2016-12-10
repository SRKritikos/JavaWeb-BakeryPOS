/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Cateringorder;
import data.entities.Customer;
import javax.ejb.Local;
import services.ICateringOrderService;
import services.ICustomerService;

/**
 *
 * @author Steven
 */
@Local
public interface IUserBean {

  public Customer getCustomer();

  public void setCustomer(Customer customer);

  public String logout();

  public void setCurrentCateringOrder(Cateringorder cateringorder);

  public Cateringorder getCurrentCateringOrder();

  public void setCartTotal(Double cartTotal);

  public Double getCartTotal();

  public void addCustomerOrder(Cateringorder order);

  public void updateCustomerOrder(Cateringorder order);

  public void setOrderservice(ICateringOrderService orderservice);

  public void setCustomerservice(ICustomerService customerservice);
}
