/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import services.ICateringOrderService;
import services.ICustomerService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="user")
@SessionScoped
public class UserBean implements IUserBean {

    @EJB
    private ICateringOrderService orderservice;
    @EJB
    private ICustomerService customerservice;
    private Customer customer;
    private Cateringorder currentCateringOrder;
    private Double cartTotal;
    
    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Cateringorder getCurrentCateringOrder() {
        return currentCateringOrder;
    }

    @Override
    public void setCurrentCateringOrder(Cateringorder currentCateringOrder) {
        this.currentCateringOrder = currentCateringOrder;
    }

    @Override
    public Double getCartTotal() {
        return cartTotal;
    }

    @Override
    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }
    

    @Override
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
    }

    @Override
    public void updateCustomerOrder(Cateringorder order) {
        if (order == null) {
            order  = this.orderservice.createNewCateringOrder(new Date(), null, null, customer, new ArrayList<CateringorderProduct>());    
        }
        List<Cateringorder> customerOrders = customer.getCateringorderList();
        customerOrders.add(order);
        this.customer.setCateringorderList(customerOrders);
        this.customerservice.saveCustomer(customer);
        this.currentCateringOrder = order;
        this.cartTotal =  order.getCateringorderProductList().stream()
                    .mapToDouble(cor -> cor.getProduct().getPrice().doubleValue())
                    .sum();
    }

    @Override
    public void setOrderservice(ICateringOrderService orderservice) {
        this.orderservice = orderservice;
    }

    @Override
    public void setCustomerservice(ICustomerService customerservice) {
        this.customerservice = customerservice;
    }
    
    
    
    
    
}
