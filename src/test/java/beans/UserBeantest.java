/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import data.entities.Cateringorder;
import data.entities.Customer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Steven Kritikos
 */
public class UserBeantest {
    private UserBean instance;
    
    @Before
    public void setUp() {
        this.instance = new UserBean();
    }
    
    @Test
    public void testSetAndGetCustomer() {
        Customer expectedResult = new Customer("1");
        this.instance.setCustomer(expectedResult);
        Customer result = this.instance.getCustomer();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetAndGetCateringOrder() {
        Cateringorder expectedResult = new Cateringorder("1");
        this.instance.setCurrentCateringOrder(expectedResult);
        Cateringorder result = this.instance.getCurrentCateringOrder();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetAndGetCartTotal() {
        Double expectedResult = 1D;
        this.instance.setCartTotal(expectedResult);
        Double result = this.instance.getCartTotal();
        assertEquals(expectedResult, result);
    }
}
