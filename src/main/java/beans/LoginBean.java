/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Cateringorder;
import data.entities.Customer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import services.ICustomerService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="login")
@ViewScoped
public class LoginBean implements ILoginBean {
    private String username;
    private String password;
    @EJB
    private ICustomerService customerservice;
    @ManagedProperty(value="#{user}")
    private UserBean user;
    
    @PostConstruct
    public void init() {
        this.username = "default customer";
        this.password = "pwd1";
    }
    
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setPassword(String password) {
        this.password =  password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String login() {
        Customer customer = customerservice.getCustomerByName(username);
        if (customer != null) {
            this.user.setCustomer(customer);
            List<Cateringorder> customerOrder = customer.getCateringorderList();
            if (customerOrder.isEmpty()) {
                
            }
            return "home.xhtml";
        }
        return "login.xhtml";
    }

    @Override
    public void setCustomerService(ICustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @Override
    public UserBean getUser() {
        return user;
    }

    @Override
    public void setUser(UserBean user) {
        this.user = user;
    }


}
