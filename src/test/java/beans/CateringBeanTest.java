/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Cateringorder;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.ICateringOrderService;
import services.IProductService;

/**
 *
 * @author Steven Kritikos
 */
public class CateringBeanTest {
    private CateringBean instance;
    private ICateringOrderService orderservice;
    private IProductService productservice;
    private UserBean userbean;
    
    @Before
    public void setUp() {
        this.instance =  new CateringBean();
        this.orderservice = Mockito.mock(ICateringOrderService.class);
        this.productservice = Mockito.mock(IProductService.class);
        this.userbean = Mockito.mock(UserBean.class);
        this.instance.setOrderservice(orderservice);
        this.instance.setUser(userbean);
        this.instance.setProductservice(productservice);
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testSetAndGetCurrentOrderId() {
        Cateringorder order = Mockito.mock(Cateringorder.class);
        String expectedResult = "1";
        Mockito.when(this.userbean.getCurrentCateringOrder()).thenReturn(order);
        Mockito.when(order.getCateringId()).thenReturn(expectedResult);
        this.instance.setCurrentOrderId(expectedResult);
        String result = this.instance.getCurrentOrderId();
        assertEquals(expectedResult, result);
    }
}
