/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Paymentmethod;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author srostantkritikos06
 */
@Stateful
public class PaymentDAOImpl extends DAOFacade<Paymentmethod> implements IPaymentDAO{

    @Inject
    @Named("homedbcon")
    public PaymentDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Paymentmethod.class);
    }

    
}
