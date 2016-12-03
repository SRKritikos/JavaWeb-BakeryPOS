/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Customer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="user")
@SessionScoped
public class UserBean implements IUserBean {

    private Customer customer;
    
    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
    }
    
}
