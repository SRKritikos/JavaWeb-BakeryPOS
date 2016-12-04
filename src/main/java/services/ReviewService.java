/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import data.dao.ProductReviewDAOImpl;
import data.entities.Customer;
import data.entities.Product;
import data.entities.Productreview;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class ReviewService implements IReviewsService{
    
    @EJB
    ProductReviewDAOImpl reviewDAO;
    
    
    @Override
    public Productreview saveProductReview(Product product, Customer customer, String reviewText, int numberStars) {
        Productreview newReview = new Productreview(UUID.randomUUID().toString());
        newReview.setCustomerId(customer);
        newReview.setNumberStars(numberStars);
        newReview.setProductId(product);
        newReview.setReviewText(reviewText);
        newReview.setReviewDate(new Date());
        boolean success = this.reviewDAO.create(newReview);
        if (!success)
            newReview = null;
        
        return newReview;
    }

    public void setReviewDAO(ProductReviewDAOImpl reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    @Override
    public List<Productreview> getReviewsByProduct(Product p) {
        List<Productreview> rtVl = this.reviewDAO.getReviewsByProduct(p.getProductId());
        return rtVl;
    }
    
    
    
}
