/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.entities.Product;
import data.entities.Productcategory;

/**
 *
 * @author Steven Kritikos
 */
public class CateringProduct {

  private int qty;
  private Product product;
  private Productcategory category;

  public CateringProduct(int qty, Product product, Productcategory category) {
    this.qty = qty;
    this.product = product;
    this.category = category;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Productcategory getCategory() {
    return category;
  }

  public void setCategory(Productcategory category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CateringProduct) {
      return ((CateringProduct) obj).product.getCategoryId()
              .equals(this.product.getCategoryId());
    }
    return false;
  }

}
