/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.persistence.EntityManager;

/**
 *
 * @author srostantkritikos06
 */
public interface IDatabaseConnection {
    public EntityManager getConnection();
}
