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
public class ProductDAOImpl implements IProductDAO {
    private IDatabaseConnection dbCon;

    @Inject
    public ProductDAOImpl(IDatabaseConnection dbCon) {
    }
    
    @Override
    public Product create(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product edit(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product find(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
