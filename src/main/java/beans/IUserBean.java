/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Cateringorder;
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
    public void setCurrentCateringOrder(Cateringorder cateringorder);
    public Cateringorder getCurrentCateringOrder();
    public void setCartTotal(Double cartTotal);
    public Double getCartTotal();
}
