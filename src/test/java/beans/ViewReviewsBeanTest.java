/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Productreview;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Steven Kritikos
 */
public class ViewReviewsBeanTest {

  private ViewReviewsBean instance;

  @Before
  public void setUp() {
    this.instance = new ViewReviewsBean();
  }

  @Test
  public void testGetAndSetProductReviews() {
    Productreview p1 = new Productreview("1");
    Productreview p2 = new Productreview("2");
    Productreview p3 = new Productreview("3");
    List<Productreview> expectedResult = Arrays.asList(p1, p2, p3);
    this.instance.setProductReviews(expectedResult);
    List<Productreview> result = this.instance.getProductReviews();
    assertThat(result, is(expectedResult));
  }
}
