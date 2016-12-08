/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import data.dao.CateringOrderDAOImpl;
import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.CateringorderProductPK;
import data.entities.Customer;
import data.entities.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Steven Kritikos
 */
public class CateringOrderServiceTest {
    private CateringOrderService instance;
    private CateringOrderDAOImpl orderDAO;
    
    @Before
    public void setUp() {
        this.instance = new CateringOrderService();
        this.orderDAO =  Mockito.mock(CateringOrderDAOImpl.class);
        this.instance.setOrderDAO(orderDAO);
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testCreateNewCateringOrder() {
        Mockito.when(this.orderDAO.create(Matchers.any(Cateringorder.class))).thenReturn(Boolean.TRUE);
        Cateringorder result = this.instance.createNewCateringOrder(new Date(), null, null, null, null);
        assertNotNull(result);
    }
    
    @Test
    public void testAddToCateringOrderProducts() {
        CateringorderProduct expectedResult = new CateringorderProduct(new CateringorderProductPK());
        expectedResult.setQuantity(0);
        Mockito.when(this.orderDAO.getCateringorderProductById(Matchers.any(CateringorderProductPK.class))).thenReturn(expectedResult);
        Mockito.when(this.orderDAO.updateCateringOrderProduct(Matchers.any(CateringorderProduct.class))).thenReturn(Boolean.TRUE);
        CateringorderProduct result = this.instance.addToCateringOrderProducts(new Product(), new Cateringorder());
        assertNotNull(result);
        
    }
    
    @Test
    public void testAddToCateringOrderProductsWithNullReturn() {
        Mockito.when(this.orderDAO.getCateringorderProductById(Matchers.any(CateringorderProductPK.class))).thenReturn(null);
        Mockito.when(this.orderDAO.createNewOrderProduct(Matchers.any(CateringorderProduct.class))).thenReturn(Boolean.TRUE);
        CateringorderProduct result = this.instance.addToCateringOrderProducts(new Product(), new Cateringorder());
        assertNotNull(result);
    }
    
    @Test
    public void testRemoveFromCateringOrderProduct() {
        CateringorderProduct expectedResult = new CateringorderProduct(new CateringorderProductPK());
        expectedResult.setQuantity(1);
        Mockito.when(this.orderDAO.getCateringorderProductById(Matchers.any(CateringorderProductPK.class))).thenReturn(expectedResult);
        Mockito.when(this.orderDAO.updateCateringOrderProduct(Matchers.any(CateringorderProduct.class))).thenReturn(Boolean.TRUE);
        CateringorderProduct result = this.instance.removeFromCateringOrderProduct(new Product(), new Cateringorder());
        assertEquals(result, expectedResult);             
    }
    
    @Test
    public void testGetCateringOrderById() {
        Cateringorder expectedResult = new Cateringorder("1");
        Mockito.when(this.orderDAO.find(expectedResult.getCateringId())).thenReturn(expectedResult);
        Cateringorder result = this.instance.getCateringOrderById("1");
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void testGetCateringOrdersForCustomer() {
        Customer customer = new Customer("1");
        List<Cateringorder> expectedResult = new ArrayList<>();
        Mockito.when(this.orderDAO.getCateringOrdersForCustomer(customer)).thenReturn(expectedResult);
        List<Cateringorder> result = this.instance.getCateringOrdersForCustomer(customer);
        assertEquals(expectedResult, result);
        
    }
}
