/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Customer;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author srostantkritikos06
 */
@Stateless
@LocalBean
public class CustomerDAOImpl extends DAOFacade<Customer> implements ICustomerDAO{

    @Inject
    @Named("homedbcon")
    public CustomerDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Customer.class);
    }   
}
