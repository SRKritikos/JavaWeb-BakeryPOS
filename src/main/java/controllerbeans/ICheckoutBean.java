/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import java.util.List;
import model.CheckoutProduct;

/**
 *
 * @author Steven
 */
public interface ICheckoutBean {
  public UserBean getUserbean();
  public void setUserbean(UserBean userbean);
  public String getCanCheckoutClass();
  public void setCanCheckoutClass(String canCheckoutClass);
  public void setConfirmOrdersModel(List<CheckoutProduct> confirmOrdersModel);
  public List<CheckoutProduct> getConfirmOrdersModel();
  public void setFinalTotalAmount(Double finalTotalAmount);
  public Double getFinalTotalAmount();
  public void setTaxCalculated(Double taxCalculated);
  public Double getTaxCalculated();
  public void init();
  public String placeOrder();
}
