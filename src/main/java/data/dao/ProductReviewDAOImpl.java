/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.google.inject.Inject;
import config.database.IDatabaseConnection;
import data.entities.Productreview;
import java.util.List;

/**
 *
 * @author srostantkritikos06
 */
public class ProductReviewDAOImpl implements IProductReviewDAO{
    private IDatabaseConnection dbCon;

    @Inject
    public ProductReviewDAOImpl(IDatabaseConnection dbCon) {
        this.dbCon = dbCon;
    }
    
    
    @Override
    public Productreview create(Productreview entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Productreview entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productreview edit(Productreview entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productreview find(Productreview entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Productreview> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
