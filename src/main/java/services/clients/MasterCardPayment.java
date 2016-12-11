/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.clients;

import data.entities.Paymentmethod;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author srostantkritikos06
 */
@Stateful(name = "mastercard")
@LocalBean
public class MasterCardPayment implements IPaymentProcess {

  @Override
  public boolean processPaynent(Paymentmethod paymentMethod) {
    System.out.println("Processing payment through " + this.getClass().getName());
    System.out.println("With Card Number - " + paymentMethod.getCardNumber());
    System.out.println("With CVV - " + paymentMethod.getCardCvv());
    System.out.println("With expirty date - " + paymentMethod.getDateTo());
    System.out.println("Finished processing payment");
    return true;
  }

}
