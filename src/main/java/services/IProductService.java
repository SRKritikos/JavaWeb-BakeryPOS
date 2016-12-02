/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.entities.Product;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IProductService {
    public List<Product> getAllProducts();
    public Product getProductById(String productId);
    public boolean saveProduct(Product product);
}
