/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Productreview;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author srostantkritikos06
 */
@Stateless
@LocalBean
public class ProductReviewDAOImpl extends DAOFacade<Productreview> implements IProductReviewDAO{
    
    @Inject
    @Named("homedbcon")
    public ProductReviewDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Productreview.class);
    }

    public List<Productreview> getReviewsByProduct(String productId) {
        List<Productreview> rtVl = null;
        try {
            EntityManager em = this.dbCon.getConnection();
            rtVl = em.createQuery("SELECT p FROM Productreview p "
                    + "WHERE p.productId.productId = :productId", Productreview.class)
                    .setParameter("productId", productId)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.toString() + "in getReviewsByProduct");
        }
        return rtVl;
    }
    
}
