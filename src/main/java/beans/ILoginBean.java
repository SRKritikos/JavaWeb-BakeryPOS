/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import services.ICustomerService;

/**
 *
 * @author Steven
 */
@Local
public interface ILoginBean {

  public void setUsername(String username);

  public String getUsername();

  public void setPassword(String password);

  public String getPassword();

  public String login();

  public void setCustomerService(ICustomerService customerservice);

  public void setUser(UserBean user);

  public UserBean getUser();
}
