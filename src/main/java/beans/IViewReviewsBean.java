/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Product;
import data.entities.Productreview;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IViewReviewsBean {

  public List<Productreview> getProductReviews();

  public void setProductReviews(List<Productreview> productReviews);

  public Product getProductBeingReviewed();

  public void setProductBeingReviewed(Product productBeingReviewed);
}
