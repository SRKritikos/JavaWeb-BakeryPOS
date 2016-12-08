/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author srostantkritikos06
 */
@Stateful(name = "homedbcon")
@TransactionManagement(value = TransactionManagementType.BEAN)
public class HomeDatabaseConnection implements IDatabaseConnection {

  @PersistenceContext(name = "COMP31A3HomePU")
  private EntityManager em;
  @Resource
  private UserTransaction utx;

  @Override
  public EntityManager getConnection() {
    return em;
  }

  /**
   * For manually inject em
   *
   * @param em
   */
  public void setEm(EntityManager em) {
    this.em = em;
  }

  @Override
  public UserTransaction getTransaction() {
    return utx;
  }

  /**
   * Setter for injecting utx manually
   *
   * @param em
   */
  public void setUtx(UserTransaction utx) {
    this.utx = utx;
  }

  @Override
  public void close() {
    if (em != null) {
      em.close();
    }
  }

}
