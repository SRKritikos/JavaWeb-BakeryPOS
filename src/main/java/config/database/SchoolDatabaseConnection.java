/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author srostantkritikos06
 */
public class SchoolDatabaseConnection implements IDatabaseConnection {
    @PersistenceContext(name="COMP31A3SchoolPU")
    private EntityManager em;
    
    @Override
    public EntityManager getConnection() {
        return em;
    }
    
}
