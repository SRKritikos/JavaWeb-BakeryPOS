/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.dao.PaymentDAOImpl;
import data.entities.Customer;
import data.entities.Paymentmethod;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface IPaymentMethodService {
  public Paymentmethod addNewPaymentForCustomer(Customer customer, String cardNumber, String cardCVV, String expiryDate);
  public void setPaymentDAO(PaymentDAOImpl customerDAO);
}
