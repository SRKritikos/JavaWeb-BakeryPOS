/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Customer;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface IUserBean {
    public Customer getCustomer();
    public void setCustomer(Customer customer);
    public String logout();
}