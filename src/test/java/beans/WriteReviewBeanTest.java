/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import services.ICustomerService;
import services.IProductService;
import services.IReviewsService;

/**
 *
 * @author Steven Kritikos
 */
public class WriteReviewBeanTest {
    private WriteReviewBean instance;
    private IReviewsService reviewservice;
    private ICustomerService customerservice;
    private IProductService productService;
    private UserBean userbean; 
    @Before
    public void setUp() {
        this.customerservice = Mockito.mock(ICustomerService.class);
        this.productService = Mockito.mock(IProductService.class);
        this.reviewservice = Mockito.mock(IReviewsService.class);
        this.userbean = Mockito.mock(UserBean.class);
        this.instance = new WriteReviewBean();
        this.instance.setCustomerservice(customerservice);
        this.instance.setProductservice(productService);
        this.instance.setReviewservice(reviewservice);
        this.instance.setUser(userbean);
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testSetAndGetReviewText() {
        String expectedResult = "Review text";
        this.instance.setReviewText(expectedResult);
        String result = this.instance.getReviewText();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetAndGetNumStars() {
        int expectedResult = 2;
        this.instance.setNumStars(expectedResult);
        int result = this.instance.getNumStars();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSubmitReview() {
        String expectedResult = "home.xhtml";
        String result = this.instance.submitReview();
        assertEquals(expectedResult, result);
    }
}
