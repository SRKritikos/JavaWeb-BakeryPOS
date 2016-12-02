/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import data.dao.IDAOFacade;
import data.entities.Product;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Steven Kritikos
 */
@Stateless 
public class ProductService implements IProductService{

    @Inject
    @Named("ProductDAO")
    private IDAOFacade<Product> productDAO;
    
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
        boolean rtVl = false;
        rtVl = this.productDAO.create(product);
        return rtVl;
    }

    /**
     * Used for testing
     * @param productDAO 
     */
    public void setProductDAO(IDAOFacade<Product> productDAO) {
        this.productDAO = productDAO;
    }
    
    


}
