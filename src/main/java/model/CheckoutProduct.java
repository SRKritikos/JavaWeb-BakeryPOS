/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Steven Kritikos
 */
public class CheckoutProduct {
  private String productName;
  private int qty;
  private Double totalPrice;

  public CheckoutProduct(String productName, int qty, Double totalPrice) {
    this.productName = productName;
    this.qty = qty;
    this.totalPrice = totalPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
