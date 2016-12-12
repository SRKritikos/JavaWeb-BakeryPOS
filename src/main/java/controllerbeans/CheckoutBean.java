/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllerbeans;

import data.entities.Cateringorder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.CheckoutProduct;
import services.ICateringOrderService;

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
  private final Double TAX = .13D;
  private Double taxCalculated;
  private Double finalTotalAmount;
  private List<CheckoutProduct> checkoutProductList;
  @EJB
  private ICateringOrderService orderservice;

  @PostConstruct
  @Override
  public void init() {
    if (this.userbean.getCurrentPaymentMethod() == null) {
      this.canCheckoutClass = "disabled";
    } else {
      this.canCheckoutClass = "active";
      this.buildCheckoutProductList(this.userbean.getCurrentCateringOrder());
      this.taxCalculated = this.userbean.getCartTotal() * TAX;
      this.finalTotalAmount = this.userbean.getCartTotal() + this.taxCalculated;
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

  @Override
  public Double getTaxCalculated() {
    return taxCalculated;
  }

  @Override
  public void setTaxCalculated(Double taxCalculated) {
    this.taxCalculated = taxCalculated;
  }

  @Override
  public Double getFinalTotalAmount() {
    return finalTotalAmount;
  }

  @Override
  public void setFinalTotalAmount(Double finalTotalAmount) {
    this.finalTotalAmount = finalTotalAmount;
  }

  @Override
  public List<CheckoutProduct> getConfirmOrdersModel() {
    return checkoutProductList;
  }

  @Override
  public void setConfirmOrdersModel(List<CheckoutProduct> confirmOrdersModel) {
    this.checkoutProductList = confirmOrdersModel;
  }

  public void setOrderservice(ICateringOrderService orderservice) {
    this.orderservice = orderservice;
  }
  
  private void buildCheckoutProductList(Cateringorder order) {
    this.checkoutProductList = new ArrayList<>();
    order.getCateringorderProductList().stream()
            .map(cop -> cop.getProduct())
            .forEach(product -> {
              this.checkoutProductList.addAll(order.getCateringorderProductList().stream()
                      .filter(cop -> cop.getProduct().equals(product))
                      .map(filteredCop -> new CheckoutProduct(filteredCop.getProduct().getProductName(),
                              filteredCop.getQuantity(),
                              filteredCop.getProduct().getPrice().doubleValue() * filteredCop.getQuantity()))
                      .collect(Collectors.toList()));
            });
  }

  @Override
  public String placeOrder() {
    boolean success = this.orderservice.processOrder(this.userbean.getCurrentCateringOrder(), this.userbean.getCurrentPaymentMethod());
    if (success) {
      List<Cateringorder> customerOrderList = this.orderservice.getCateringOrdersForCustomer(this.userbean.getCustomer());
      if (!customerOrderList.isEmpty()) {
        this.userbean.updateCustomerOrder(
          customerOrderList
              .parallelStream()
              .sorted((o1, o2) -> o1.getDateCreated().compareTo(o2.getDateCreated()))
              .collect(Collectors.toList())
              .get(0)
        );
      } else {
        this.userbean.addCustomerOrder(null);
      }
      return "catering.xhtml";
    } else {
      return "checkout.xhtml";     
    }
    
  }


  
  
}
