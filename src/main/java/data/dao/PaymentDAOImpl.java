/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.PaymentMethod;
import config.database.IDatabaseConnection;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author srostantkritikos06
 */
@Stateful
@LocalBean
public class PaymentDAOImpl extends DAOFacade<Paymentmethod> implements IPaymentDAO {

  @Inject
  @Named("homedbcon")
  public PaymentDAOImpl(IDatabaseConnection dbCon) {
    super(dbCon, Paymentmethod.class);
  }

  @Override
  public List<Paymentmethod> getPaymentMethodsForCustomer(Customer customer) {
    List<Paymentmethod> rtVl = new ArrayList();
    try {
      EntityManager em = this.dbCon.getConnection();
      rtVl = em.createQuery("SELECT p FROM Paymentmethod p WHERE p.customerId = :customerId", Paymentmethod.class)
              .setParameter("customerId", customer)
              .getResultList();
    } catch (Exception e) {
      System.out.println(e.toString() + " in getPaymentMethodsForCustomer");
    }
          
    return rtVl;
  }

  @Override
  public Paymentmethod getPaymentMethodByCardNumber(String cardNumber) {
    Paymentmethod rtVl = null;
    try {
      EntityManager em = this.dbCon.getConnection();
      rtVl = em.createNamedQuery("Paymentmethod.findByCardNumber", Paymentmethod.class)
              .setParameter("cardNumber", cardNumber)
              .getSingleResult();
    } catch (Exception e) {
      System.out.println(e.toString() + " in getPaymentMethodByCardNumber");
    }
    return rtVl;
  }
  

}
