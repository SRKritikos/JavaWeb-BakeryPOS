/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author srostantkritikos06
 */
@Local
public interface IDatabaseConnection {

  public EntityManager getConnection();

  public UserTransaction getTransaction();

  public void close();
}
