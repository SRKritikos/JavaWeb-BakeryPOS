/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Cateringorder;
import data.entities.Product;
import data.entities.Productcategory;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.CateringProduct;
import services.ICateringOrderService;
import services.ICustomerService;
import services.IProductService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "catering")
@RequestScoped
public class CateringBean implements ICateringBean {

  private Map<Productcategory, List<CateringProduct>> cateringModel;
  private List<Cateringorder> userOrders;
  private String currentOrderId;
  @EJB
  private IProductService productservice;
  @EJB
  private ICateringOrderService orderservice;
  @ManagedProperty("#{user}")
  private UserBean user;

  @Override
  public Map<Productcategory, List<CateringProduct>> getCateringModel() {
    List<Product> productsList = this.productservice.getAllProducts();
    Cateringorder userOrder = this.user.getCurrentCateringOrder();
    this.cateringModel = productsList.parallelStream()
            .map(p -> new CateringProduct(0, p, p.getCategoryId()))
            .collect(Collectors.groupingBy(CateringProduct::getCategory));
    this.cateringModel.entrySet().parallelStream()
            .forEach(entry -> entry.getValue().stream()
                    .forEach(cp -> userOrder.getCateringorderProductList().stream()
                            .filter(cop -> cop.getProduct().equals(cp.getProduct()))
                            .findFirst()
                            .ifPresent(foundP -> cp.setQty(foundP.getQuantity()))
                    )
            );
    return cateringModel;
  }

  @Override
  public String makeNewOrder() {
    this.user.addCustomerOrder(null);
    return "catering.xhtml";
  }

  @Override
  public void changeOrder() {
    Cateringorder order = this.orderservice.getCateringOrderById(currentOrderId);
    this.user.updateCustomerOrder(order);
  }

  @Override
  public void setCateringModel(Map<Productcategory, List<CateringProduct>> cateringModel) {
    this.cateringModel = cateringModel;
  }

  @Override
  public List<Cateringorder> getUserOrders() {
    this.userOrders = this.orderservice.getCateringOrdersForCustomer(this.user.getCustomer());
    return userOrders;
  }

  @Override
  public void setUserOrders(List<Cateringorder> userOrders) {
    this.userOrders = userOrders;
  }

  @Override
  public String getCurrentOrderId() {
    this.currentOrderId = this.user.getCurrentCateringOrder().getCateringId();
    return currentOrderId;
  }

  @Override
  public void setCurrentOrderId(String currentOrderId) {
    this.currentOrderId = currentOrderId;
  }

  @Override
  public UserBean getUser() {
    return user;
  }

  @Override
  public void setUser(UserBean user) {
    this.user = user;
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
  public void setOrderservice(ICateringOrderService orderservice) {
    this.orderservice = orderservice;
  }

}
