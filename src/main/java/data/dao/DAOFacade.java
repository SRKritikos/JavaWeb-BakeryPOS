/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.dao;

import config.database.IDatabaseConnection;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Steven Kritikos
 */
public abstract class DAOFacade<T> implements IDAOFacade<T>{
    protected IDatabaseConnection dbCon;
    private final Class<T> classType;
    
    public DAOFacade(IDatabaseConnection dbCon, Class<T> classType) {
        this.dbCon = dbCon;
        this.classType = classType;
    }

    @Override
    public boolean create(T entity) {
        EntityManager em = this.dbCon.getConnection();
        UserTransaction utx = this.dbCon.getTransaction();
        boolean success = false;
        try {
            utx.begin();
            em.persist(entity);
            utx.commit();
            success = true;
        } catch (Exception e) {
            System.out.println("Failed to create instance in function " + this.getClass().getName());
        }
        return success;
    }

    @Override
    public boolean delete(T entity) {
        EntityManager em = this.dbCon.getConnection();
        UserTransaction utx = this.dbCon.getTransaction();
        boolean success = false;
        try {
            utx.begin();
            em.remove(entity);
            utx.commit();
            success = true;
        } catch (Exception e) {
            System.out.println("Failed to delete entity " + this.getClass().getName());
        }
        return success;
    }

    @Override
    public boolean edit(T entity) {
        EntityManager em = this.dbCon.getConnection();
        UserTransaction utx = this.dbCon.getTransaction();
        boolean success = false;
        try {
            utx.begin();
            em.merge(entity);
            utx.commit();
            success = true;
        } catch (Exception e) {
            System.out.println("Failed to update entity " + this.getClass().getName());
        }
        return success;
    }

    @Override
    public T find(String id) {
        EntityManager em = this.dbCon.getConnection();
        T rtVl = null;
        try {
            rtVl = em.find( this.classType, id);
        } catch (Exception e) {
            System.out.println("Failed to retrieve entiy " + this.getClass().getName());
        }
        return rtVl;
    }

    @Override
    public List<T> getAll() {
        EntityManager em = this.dbCon.getConnection();
        List<T> rtVl = null;
        try {
            
            Query query = em.createNamedQuery(this.classType.getSimpleName() + ".findAll");
            rtVl =  query.getResultList();
        } catch (Exception e) {
            System.out.println("Failed to retrieve entiy " + this.getClass().getName());
            e.printStackTrace();
        }
        return rtVl;
    }

}
