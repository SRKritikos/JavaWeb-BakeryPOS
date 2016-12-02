/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.google.inject.Inject;
import config.database.IDatabaseConnection;
import data.entities.Product;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author srostantkritikos06
 */
public class ProductDAOImpl extends DAOFacade<Product> {
    
    public ProductDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Product.class);
    }
    
}
