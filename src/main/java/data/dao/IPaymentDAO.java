/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.PaymentMethod;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface IPaymentDAO {
  public List<Paymentmethod> getPaymentMethodsForCustomer(Customer customer);
  public Paymentmethod getPaymentMethodByCardNumber(String cardNumber);
}
