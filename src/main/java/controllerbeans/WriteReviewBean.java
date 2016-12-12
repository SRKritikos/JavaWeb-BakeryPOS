/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Customer;
import data.entities.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import services.ICustomerService;
import services.IProductService;
import services.IReviewsService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "writereview")
@RequestScoped
public class WriteReviewBean implements IWriteReviewBean {

  private String reviewText;
  private int numStars;
  private String productId;
  @ManagedProperty(value = "#{user}")
  private UserBean user;
  @EJB
  private IReviewsService reviewservice;
  @EJB
  private ICustomerService customerservice;
  @EJB
  private IProductService productservice;

  @Override
  public void setReviewText(String text) {
    this.reviewText = text;
  }

  @Override
  public String getReviewText() {
    return reviewText;
  }

  @Override
  public void setNumStars(int numStars) {
    this.numStars = numStars;
  }

  @Override
  public int getNumStars() {
    return numStars;
  }

  @Override
  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Override
  public String getProductId() {
    return productId;
  }

  @Override
  public String submitReview() {
    Product product = this.productservice.getProductById(productId);
    this.reviewservice.saveProductReview(product, this.user.getCustomer(), reviewText, numStars);
    return "home.xhtml";
  }

  @Override
  public void setReviewservice(IReviewsService reviewservice) {
    this.reviewservice = reviewservice;
  }

  public void setCustomerservice(ICustomerService customerservice) {
    this.customerservice = customerservice;
  }

  @Override
  public void setProductservice(IProductService productservice) {
    this.productservice = productservice;
  }

  @Override
  public IReviewsService getReviewservice() {
    return reviewservice;
  }

  @Override
  public ICustomerService getCustomerservice() {
    return customerservice;
  }

  @Override
  public IProductService getProductservice() {
    return productservice;
  }

  @Override
  public void setUser(UserBean user) {
    this.user = user;
  }

  @Override
  public UserBean getUser() {
    return user;
  }

}
