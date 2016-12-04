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

/**
 *
 * @author Steven Kritikos
 */
public class WriteReviewBeanTest {
    private WriteReviewBean instance;
    
    @Before
    public void setUp() {
        this.instance = new WriteReviewBean();
        
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
