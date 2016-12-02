/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import data.dao.IDAOFacade;
import data.entities.Customer;
import javax.ejb.Stateless;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class CustomerService implements ICustomerService {
    
    @Inject
    @Named("CustomerDAO")
    IDAOFacade<Customer> customerDAO;

    public CustomerService() {   
    }
    
    @Override
     public boolean saveCustomer(Customer customer) {
        boolean rtVl = false;
        rtVl = this.customerDAO.create(customer);
        return rtVl;
    }
    
    @Override
    public Customer getCustomerById(String customerId) {
        Customer rtVl = this.customerDAO.find(customerId);
        return rtVl;
    }

}
