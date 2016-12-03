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
public class LoginBeanTest {
    private LoginBean instance;
    
    @Before
    public void setUp() {
        this.instance = new LoginBean();
    }
    
    @After
    public void cleanUp() {
        
    }
    
    @Test
    public void testSetAndGetUsername() {
        String expectedResult = "username";
        this.instance.setUsername(expectedResult);
        String result = this.instance.getUsername();
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void testSetAndGetPassword() {
        String expectedResult = "password";
        this.instance.setPassword(expectedResult);
        String result = this.instance.getPassword();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testInit() {
        String expectedUsername = "default customer";
        String expectedPassword = "pwd1";
        this.instance.init();
        String resultUsername = this.instance.getUsername();
        String resultPassword = this.instance.getPassword();
        assertEquals(expectedUsername, resultUsername);
        assertEquals(expectedPassword, resultPassword);
    }
}
