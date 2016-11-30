/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.google.inject.Inject;
import config.database.IDatabaseConnection;
import data.entities.Customer;
import java.util.List;

/**
 *
 * @author srostantkritikos06
 */
public class CustomerDAOImpl implements ICustomerDAO {
    
    private IDatabaseConnection dbCon;

    @Inject
    public CustomerDAOImpl(IDatabaseConnection dbCon) {
        this.dbCon = dbCon;
    }
    
    
    @Override
    public Customer create(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer edit(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer find(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
