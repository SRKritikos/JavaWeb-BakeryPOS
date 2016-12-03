/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Product;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.IProductService;

/**
 *
 * @author Steven Kritikos
 */
public class ProductsLisBeanTest {
    private ProductsListBean instance;
    private IProductService productservice;
    
    @Before
    public void setUp() {
        this.productservice = Mockito.mock(IProductService.class);
        this.instance = new ProductsListBean();
        this.instance.setProductservice(productservice);
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testSetAndGetProductlist() {
        Product p1 = new Product("1");
        Product p2 = new Product("2");
        Product p3 = new Product("3");
        List<Product> expectedResult = Arrays.asList(p1, p2, p3);
        this.instance.setProductlist(expectedResult);
        List<Product> result = this.instance.getProductlist();
        assertThat(result, is(expectedResult));
    }
    
    @Test
    public void testInit() {
       Product p1 = new Product("1");
       Product p2 = new Product("2");
       Product p3 = new Product("3");
       List<Product> expectedResult = Arrays.asList(p1, p2, p3);
       Mockito.when(this.productservice.getAllProducts()).thenReturn(expectedResult);
       this.instance.init();
       List<Product> result = this.instance.getProductlist();
       assertThat(result, is(expectedResult));
    }
}
