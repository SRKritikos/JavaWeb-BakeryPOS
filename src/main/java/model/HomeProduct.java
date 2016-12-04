/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import data.entities.Product;
import data.entities.Productreview;

/**
 *
 * @author Steven Kritikos
 */
public class HomeProduct {
    Product product;
    Productreview review;

    public HomeProduct(Product product, Productreview review) {
        this.product = product;
        this.review = review;
    }

    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Productreview getReview() {
        return review;
    }

    public void setReview(Productreview review) {
        this.review = review;
    }
    
    
}
