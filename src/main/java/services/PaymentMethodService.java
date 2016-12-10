/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import data.dao.CustomerDAOImpl;
import data.dao.PaymentDAOImpl;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class PaymentMethodService implements IPaymentMethodService{
  @EJB
  private PaymentDAOImpl paymentDAO;

  
  @Override
  public void setPaymentDAO(PaymentDAOImpl paymentDAO) {
    this.paymentDAO = paymentDAO;
  }

  @Override
  public Paymentmethod addNewPaymentForCustomer(Customer customer, String cardNumber, String cardCVV, String expiryDate) {
    Paymentmethod rtVl = new Paymentmethod(UUID.randomUUID().toString());
    Date dateTo = this.getExpiryDate(expiryDate);
    rtVl.setCardCvv(cardCVV);
    rtVl.setCardNumber(cardNumber);
    rtVl.setCateringorderList(customer.getCateringorderList());
    rtVl.setDateTo(dateTo);
    rtVl.setCustomerId(customer);
    boolean result = this.paymentDAO.create(rtVl);
    if (!result) {
      rtVl = null;
    }
    return rtVl;
    
  }

  private Date getExpiryDate(String expiryDate) {
    Date rtVl = null;
    try {
      DateFormat df = new SimpleDateFormat("MMyy");
      rtVl = df.parse(expiryDate);
    } catch (ParseException ex) {
      System.out.println("Failed to parse date" + ex.toString());
    }
    return rtVl;
  }
  
  
}
