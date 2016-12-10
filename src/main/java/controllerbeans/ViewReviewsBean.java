/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Product;
import data.entities.Productreview;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "viewreviews")
@SessionScoped
public class ViewReviewsBean implements IViewReviewsBean, Serializable {

  private List<Productreview> productReviews;
  private Product productBeingReviewed;

  @Override
  public List<Productreview> getProductReviews() {
    return productReviews;
  }

  @Override
  public void setProductReviews(List<Productreview> productReviews) {
    this.productReviews = productReviews;
  }

  @Override
  public Product getProductBeingReviewed() {
    return productBeingReviewed;
  }

  @Override
  public void setProductBeingReviewed(Product productBeingReviewed) {
    this.productBeingReviewed = productBeingReviewed;
  }

}
