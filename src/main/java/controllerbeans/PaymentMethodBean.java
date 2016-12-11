/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllerbeans;

import config.PaymentMethod;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import services.ICustomerService;
import services.IPaymentMethodService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="paymentmethod")
@RequestScoped
public class PaymentMethodBean implements IPaymentMethodBean{
  private String selectedPaymentMethodId;
  private String paymentType;
  private String cardNumber;
  private String cardCVV;
  private String expiryMonth;
  private String expiryYear;
  private boolean isPreferred;
  @ManagedProperty(value="#{user}")
  private UserBean userbean;  
  @EJB
  private IPaymentMethodService paymentService;
  @EJB
  private ICustomerService customerService;
  
  
  @PostConstruct 
  @Override
  public void init() {
    if (this.userbean.getCurrentPaymentMethod() != null) {
      DateFormat df = new SimpleDateFormat("MM");
      Paymentmethod paymentMethod = this.userbean.getCurrentPaymentMethod();
      this.cardCVV = paymentMethod.getCardCvv();
      this.cardNumber = paymentMethod.getCardNumber();
      this.paymentType = paymentMethod.getPaymentType();
      this.isPreferred = paymentMethod.getIsPreferred();
      this.selectedPaymentMethodId = paymentMethod.getPaymentMethodId();
      this.expiryMonth = df.format(paymentMethod.getDateTo());
      df =  new SimpleDateFormat("yy");
      this.expiryYear = df.format(paymentMethod.getDateTo());
    }
  }
  
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
  public boolean isIsPrefered() {
    return isPreferred;
  }

  @Override
  public void setIsPrefered(boolean isPrefered) {
    this.isPreferred = isPrefered;
  }

  @Override
  public String getSelectedPaymentMethodId() {
    return selectedPaymentMethodId;
  }

  @Override
  public void setSelectedPaymentMethodId(String selectedPaymentMethodId) {
    this.selectedPaymentMethodId = selectedPaymentMethodId;
  }
  
  @Override
  public String addPaymentMethod() {
    Paymentmethod newPaymentMethod = this.paymentService.getPaymentMethodByCardNumber(cardNumber);
    if (newPaymentMethod == null) {
      if (isPreferred) {
       this.paymentService.updateAllCustomerPreferredMethod(this.userbean.getCustomer(), false);
      }
      newPaymentMethod = this.paymentService.addNewPaymentForCustomer(this.userbean.getCustomer(), this.cardNumber, this.cardCVV, expiryMonth+expiryYear, this.isPreferred, PaymentMethod.valueOf(this.paymentType));
      List<Paymentmethod> updatedPaymentMethodList = this.paymentService.getPaymentMethodsForCustomer(this.userbean.getCustomer());
      this.userbean.getCustomer().setPaymentmethodList(updatedPaymentMethodList);
      this.userbean.setCurrentPaymentMethod(newPaymentMethod);
    }
    return "checkout.xhtml";
  }

  public void changePaymentMethod() {
    Paymentmethod paymentMethod = this.paymentService.getPaymentMethodById(selectedPaymentMethodId);
    this.userbean.setCurrentPaymentMethod(paymentMethod);
    init();
  }
  
  @Override
  public void setPaymentService(IPaymentMethodService paymentService) {
    this.paymentService = paymentService;
  }
  
  

  
  
}
