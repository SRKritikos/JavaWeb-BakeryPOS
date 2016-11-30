/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.google.inject.Inject;
import config.database.IDatabaseConnection;
import data.entities.Paymentmethod;
import java.util.List;

/**
 *
 * @author srostantkritikos06
 */
public class PaymentDAOImpl implements IPaymentDAO {
    private IDatabaseConnection dbCon;

    @Inject
    public PaymentDAOImpl(IDatabaseConnection dbCon) {
        this.dbCon = dbCon;
    }
    
    @Override
    public Paymentmethod create(Paymentmethod entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Paymentmethod entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paymentmethod edit(Paymentmethod entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paymentmethod find(Paymentmethod entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paymentmethod> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
