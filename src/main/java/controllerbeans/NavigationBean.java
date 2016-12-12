/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "navigation")
@RequestScoped
public class NavigationBean implements INavigationBean {

  @Override
  public String goToHome() {
    return "home.xhtml";
  }

  @Override
  public String goToCatering() {
    return "catering.xhtml";
  }

  @Override
  public String goToCheckout() {
    return "checkout.xhtml";
  }
  
 

}
