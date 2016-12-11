/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllerbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="checkout")
@RequestScoped
public class CheckoutBean implements ICheckoutBean {
  @ManagedProperty(value="#{user}")
  private UserBean userbean;
  private String canCheckoutClass;

  @PostConstruct
  public void init() {
    if (this.userbean.getCurrentPaymentMethod() == null) {
      this.canCheckoutClass = "disabled";
    } else {
      this.canCheckoutClass = "active";
    }
  }
  
  @Override
  public UserBean getUserbean() {
    return userbean;
  }

  @Override
  public void setUserbean(UserBean userbean) {
    this.userbean = userbean;
  }

  @Override
  public String getCanCheckoutClass() {
    return canCheckoutClass;
  }

  @Override
  public void setCanCheckoutClass(String canCheckoutClass) {
    this.canCheckoutClass = canCheckoutClass;
  }
  
  
}
