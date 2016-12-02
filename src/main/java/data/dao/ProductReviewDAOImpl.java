/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Productreview;

/**
 *
 * @author srostantkritikos06
 */
public class ProductReviewDAOImpl extends DAOFacade<Productreview>{
    
    public ProductReviewDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Productreview.class);
    }
    
}
