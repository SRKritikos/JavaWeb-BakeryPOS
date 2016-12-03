/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Product;
import java.util.List;
import services.IProductService;
import services.ProductService;

/**
 *
 * @author Steven
 */
public interface IProductListBean {
    public void init();
    public void setProductlist(List<Product> productList);
    public List<Product> getProductlist();
    public void setProductservice(IProductService productservice);
}
