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
public class NavigationBeanTest {

  private NavigationBean instance;

  @Before
  public void setUp() {
    this.instance = new NavigationBean();
  }

  @After
  public void cleanUp() {

  }

  @Test
  public void testGoToHome() {
    String expectedResult = "home.xhtml";
    String result = this.instance.goToHome();
    assertEquals(expectedResult, result);
  }

  @Test
  public void testGoToCatering() {
    String expectedResult = "catering.xhtml";
    String result = this.instance.goToCatering();
    assertEquals(expectedResult, result);
  }
}
