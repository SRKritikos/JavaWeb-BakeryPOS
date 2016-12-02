/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.dao;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import data.entities.Customer;

/**
 *
 * @author Steven Kritikos
 */
public class DAOModule extends AbstractModule {

    @Override
    protected void configure() {
        //Customer
        bind(IDAOFacade.class)
                .annotatedWith(Names.named("CustomerDAO"))
                .to(CustomerDAOImpl.class);
        bind(IDAOFacade.class)
                .annotatedWith(Names.named("CaterinOrder"))
                .to(CateringOrderDAOImpl.class);
        bind(IDAOFacade.class)
                .annotatedWith(Names.named("PaymentDAO"))
                .to(CateringOrderDAOImpl.class);
        bind(IDAOFacade.class)
                .annotatedWith(Names.named("ProductDAO"))
                .to(ProductDAOImpl.class);
        bind(IDAOFacade.class)
                .annotatedWith(Names.named("ProductReviewDAO"))
                .to(ProductReviewDAOImpl.class);
                
    }

}
