/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import services.ICateringOrderService;
import services.IProductService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "removeproductfromorder")
@RequestScoped
public class RemoveProductFromOrderBean implements IRemoveProductFromOrderBean {

  @EJB
  private IProductService productservice;
  @EJB
  private ICateringOrderService orderservice;
  @ManagedProperty(value = "#{user}")
  private UserBean userbean;

  @Override
  public IProductService getProductservice() {
    return productservice;
  }

  @Override
  public void setProductservice(IProductService productservice) {
    this.productservice = productservice;
  }

  public ICateringOrderService getOrderservice() {
    return orderservice;
  }

  @Override
  public void setOrderservice(ICateringOrderService orderservice) {
    this.orderservice = orderservice;
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
  public void removeProductFromOrder() {
    String idClicked = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("removeProductId");
    Product product = this.productservice.getProductById(idClicked);
    Cateringorder order = this.userbean.getCurrentCateringOrder();
    CateringorderProduct orderProductRemoved = this.orderservice.removeFromCateringOrderProduct(product, order);
    if (orderProductRemoved != null) {
      if (order.getCateringorderProductList().contains(orderProductRemoved)) {
        order.getCateringorderProductList()
                .set(order.getCateringorderProductList().indexOf(orderProductRemoved), orderProductRemoved);
      } else {
        order.getCateringorderProductList().add(orderProductRemoved);
      }
      this.userbean.updateCustomerOrder(order);
    }
  }

}
