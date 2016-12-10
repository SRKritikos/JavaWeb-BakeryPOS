/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import services.IPaymentMethodService;

/**
 *
 * @author Steven
 */
public interface IPaymentMethodBean {
  public String getCardNumber();
  public void setCardNumber(String cardNumber);
  public String getCardCVV();
  public void setCardCVV(String cardCVV);
  public String getExpiryMonth();
  public void setExpiryMonth(String expiryMonth);
  public String getExpiryYear();
  public void setExpiryYear(String expiryYear);
  public String addPaymentMethod();
  public void setPaymentService(IPaymentMethodService paymentService);
  public void setUserbean(UserBean userbean);
  public UserBean getUserbean();
  public String getPaymentType();
  public void setPaymentType(String paymentType);
}
