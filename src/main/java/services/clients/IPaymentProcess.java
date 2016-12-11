/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.clients;

import data.entities.Paymentmethod;
import javax.ejb.Local;

/**
 *
 * @author srostantkritikos06
 */
@Local
public interface IPaymentProcess {
  public boolean processPaynent(Paymentmethod paymentMethod);
}
