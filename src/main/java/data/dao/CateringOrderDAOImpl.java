/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.CateringorderProductPK;
import data.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author srostantkritikos06
 */
@Stateless
public class CateringOrderDAOImpl extends DAOFacade<Cateringorder> implements ICateringOrderDAO{
    
    @Inject
    @Named("homedbcon")
    public CateringOrderDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Cateringorder.class);
    }

    @Override
    public CateringorderProduct getCateringorderProductById(CateringorderProductPK orderProductPK) {
        EntityManager em = this.dbCon.getConnection();
        CateringorderProduct rtVl = null;
        try {
            rtVl = em.find(CateringorderProduct.class, orderProductPK);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rtVl;
    }

    @Override
    public boolean updateCateringOrderProduct(CateringorderProduct orderProduct) {
        EntityManager em = this.dbCon.getConnection();
        boolean rtVl = false;
        try {
            em.merge(orderProduct);
            rtVl = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rtVl;
    }

    @Override
    public List<Cateringorder> getCateringOrdersForCustomer(Customer customerId) {
        EntityManager em = this.dbCon.getConnection();
        List<Cateringorder> rtVl = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cateringorder> cq = cb.createQuery(Cateringorder.class);
            Root<Cateringorder> cateringorder = cq.from(Cateringorder.class);
            cq.where(cb.equal(cateringorder.get("customerId"), customerId));
            rtVl = em.createQuery(cq).getResultList();
        } catch(Exception e) {
            System.out.println(e.toString());
        }        
        return rtVl;
    }

    @Override
    public boolean createNewOrderProduct(CateringorderProduct orderProduct) {
        EntityManager em = this.dbCon.getConnection();
        boolean rtVl = false;
        try {
            em.persist(orderProduct);
            rtVl = true;
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        return rtVl;
    }
    
}
