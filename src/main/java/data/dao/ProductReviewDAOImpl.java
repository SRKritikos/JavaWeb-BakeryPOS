/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Productreview;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author srostantkritikos06
 */
@Stateless
public class ProductReviewDAOImpl extends DAOFacade<Productreview> implements IProductReviewDAO{
    
    @Inject
    @Named("homedbcon")
    public ProductReviewDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Productreview.class);
    }
    
}
