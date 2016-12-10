/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllerbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import services.IPaymentMethodService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="paymentmethod")
@RequestScoped
public class PaymentMethodBean implements IPaymentMethodBean{
  private String paymentType;
  private String cardNumber;
  private String cardCVV;
  private String expiryMonth;
  private String expiryYear;
  @ManagedProperty(value="#{user}")
  private UserBean userbean;  
  @EJB
  private IPaymentMethodService paymentService;

  @Override
  public String getCardNumber() {
    return cardNumber;
  }

  @Override
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  @Override
  public String getCardCVV() {
    return cardCVV;
  }

  @Override
  public void setCardCVV(String cardCVV) {
    this.cardCVV = cardCVV;
  }

  @Override
  public String getExpiryMonth() {
    return expiryMonth;
  }

  @Override
  public void setExpiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  @Override
  public String getExpiryYear() {
    return expiryYear;
  }

  @Override
  public void setExpiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
  }

  @Override
  public UserBean getUserbean() {
    return userbean;
  }

  @Override
  public void setUserbean(UserBean userbean) {
    this.userbean = userbean;
  }

  @Override
  public String getPaymentType() {
    return paymentType;
  }

  @Override
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  @Override
  public String addPaymentMethod() {
    this.paymentService.addNewPaymentForCustomer(this.userbean.getCustomer(), cardNumber, cardCVV, expiryMonth+expiryYear);
    return "checkout.xhtml";
  }

  public void setPaymentService(IPaymentMethodService paymentService) {
    this.paymentService = paymentService;
  }

  
  
}
