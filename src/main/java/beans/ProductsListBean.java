/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Product;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import services.IProductService;
import services.ProductService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name="productlist")
@RequestScoped
public class ProductsListBean implements IProductListBean{
    @EJB
    IProductService productservice;
    List<Product> productlist;
    
    @PostConstruct
    @Override
    public void init() {
        this.productlist = this.productservice.getAllProducts();
        System.out.println("IN BEAN " + this.productlist.size());
    }

    @Override
    public List<Product> getProductlist() {
        return productlist;
    }

    @Override
    public void setProductlist(List<Product> productlist) {
        this.productlist = productlist;
    }
    
    /**
     * For testing
     * @param productservice 
     */
    @Override
    public void setProductservice(IProductService productservice) {
        this.productservice = productservice;
    }

    
    
}
