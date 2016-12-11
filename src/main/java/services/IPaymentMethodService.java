/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import config.PaymentMethod;
import data.dao.PaymentDAOImpl;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface IPaymentMethodService {
  public Paymentmethod addNewPaymentForCustomer(Customer customer, String cardNumber, String cardCVV, String expiryDate, boolean isPreferred, PaymentMethod method);
  public void setPaymentDAO(PaymentDAOImpl customerDAO);
  public void updateAllCustomerPreferredMethod(Customer customer, boolean b);
  public List<Paymentmethod> getPaymentMethodsForCustomer(Customer customer);
  public Paymentmethod getPaymentMethodByCardNumber(String cardNumber);
  public Paymentmethod getPaymentMethodById(String selectedPaymentMethodId);
  public Paymentmethod updatePaymentWithValues(Paymentmethod newPaymentMethod, String cardCVV, String expiryDate, boolean preferred, PaymentMethod paymentMethod);
}
