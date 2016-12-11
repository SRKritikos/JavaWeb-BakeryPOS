/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.clients;

import data.entities.Paymentmethod;

/**
 *
 * @author srostantkritikos06
 */
public interface IPaymentProcess {
  public void processPaynent(Paymentmethod paymentMethod);
}
