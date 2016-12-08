/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.dao.IProductReviewDAO;
import data.dao.ProductReviewDAOImpl;
import data.entities.Customer;
import data.entities.Product;
import data.entities.Productreview;
import java.util.UUID;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 *
 * @author Steven Kritikos
 */
public class ReviewServiceTest {

  private ReviewService instance;
  private ProductReviewDAOImpl reviewDAO;

  @Before
  public void setUp() {
    this.reviewDAO = Mockito.mock(ProductReviewDAOImpl.class);
    this.instance = new ReviewService();
    this.instance.setReviewDAO(reviewDAO);
  }

  @After
  public void cleanUp() {

  }

  @Test
  public void testSaveProductReview() {
    Mockito.when(this.reviewDAO.create(Matchers.any(Productreview.class))).thenReturn(Boolean.TRUE);
    Productreview result = this.instance.saveProductReview(new Product("1"), new Customer("1"), "1", 0);
    assertNotNull(result);

  }

}
