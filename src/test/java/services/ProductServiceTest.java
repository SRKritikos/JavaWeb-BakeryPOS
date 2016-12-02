/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import data.dao.ProductDAOImpl;
import data.entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Steven Kritikos
 */
public class ProductServiceTest {
    private ProductService instance;
    private ProductDAOImpl productDAO;
    
    @Before
    public void setUp() {
        this.productDAO = Mockito.mock(ProductDAOImpl.class);
        this.instance = new ProductService();
        this.instance.setProductDAO(productDAO);
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testGetAllProducts() {
        List<Product> expectedResult = new ArrayList<Product>();
        Mockito.when(this.productDAO.getAll()).thenReturn(expectedResult);
        List<Product> result = this.instance.getAllProducts();
        assertEquals(expectedResult,result);
    }
    
    @Test
    public void testGetProductById() {
        Product expectedResult = new Product("1");
        Mockito.when(this.productDAO.find("1")).thenReturn(expectedResult);
        Product result = this.instance.getProductById(expectedResult.getProductId());
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSaveProduct() {
        Product p =  new Product("1");
        boolean expectedResult = true;
        Mockito.when(this.productDAO.create(p)).thenReturn(expectedResult);
        boolean result = this.instance.saveProduct(p);
        assertTrue(result);
    }
    
}
