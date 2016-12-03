/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Product;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author srostantkritikos06
 */
@Stateful
@LocalBean
public class ProductDAOImpl extends DAOFacade<Product> implements IProductDAO{
    
    @Inject
    @Named("homedbcon")
    public ProductDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Product.class);
    }
    
}
