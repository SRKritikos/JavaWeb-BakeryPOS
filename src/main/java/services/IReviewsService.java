/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.entities.Customer;
import data.entities.Product;
import data.entities.Productreview;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface IReviewsService {

  public Productreview saveProductReview(Product product, Customer customer, String reviewText, int numberStars);

  public List<Productreview> getReviewsByProduct(Product p);
}
