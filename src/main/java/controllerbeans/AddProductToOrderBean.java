/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Product;
import java.util.List;
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
@ManagedBean(name = "addproducttoorder")
@RequestScoped
public class AddProductToOrderBean implements IAddProductToOrderBean {

  @EJB
  private ICateringOrderService orderservice;
  @EJB
  private IProductService productservice;
  @ManagedProperty(value = "#{user}")
  private UserBean userbean;

  @Override
  public UserBean getUserbean() {
    return userbean;
  }

  @Override
  public void setUserbean(UserBean userbean) {
    this.userbean = userbean;
  }

  @Override
  public void setOrderservice(ICateringOrderService orderservice) {
    this.orderservice = orderservice;
  }

  @Override
  public ICateringOrderService getOrderservice() {
    return this.orderservice;
  }

  @Override
  public IProductService getProductservice() {
    return productservice;
  }

  @Override
  public void setProductservice(IProductService productservice) {
    this.productservice = productservice;
  }

  @Override
  public void addProductToOrder() {
    String idClicked = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("addProductId");
    Product product = this.productservice.getProductById(idClicked);
    Cateringorder order = this.userbean.getCurrentCateringOrder();
    CateringorderProduct orderProductAdded = this.orderservice.addToCateringOrderProducts(product, order);
    if (orderProductAdded != null) {
      if (order.getCateringorderProductList().contains(orderProductAdded)) {
        order.getCateringorderProductList()
                .set(order.getCateringorderProductList().indexOf(orderProductAdded), orderProductAdded);
      } else {
        order.getCateringorderProductList().add(orderProductAdded);
      }
      this.userbean.updateCustomerOrder(order);
    }
  }

}
