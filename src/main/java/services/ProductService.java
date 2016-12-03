/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import data.dao.ProductDAOImpl;
import data.entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.inject.Inject;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class ProductService implements IProductService{
    @EJB
    private ProductDAOImpl productDAO;
    
    
    
    @Override
    public List<Product> getAllProducts() {
        List<Product> rtVl = productDAO.getAll();
        return rtVl;
    }

    @Override
    public Product getProductById(String productId) {
        Product rtVl = this.productDAO.find(productId);
        return rtVl;
    }

    @Override
    public boolean saveProduct(Product product) {
        boolean rtVl = this.productDAO.create(product);
        return rtVl;
    }

    public void setProductDAO(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }
    
    
}
