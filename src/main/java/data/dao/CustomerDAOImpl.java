/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Customer;

/**
 *
 * @author srostantkritikos06
 */
public class CustomerDAOImpl extends DAOFacade<Customer> {

    public CustomerDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Customer.class);
    }

    
    
}
