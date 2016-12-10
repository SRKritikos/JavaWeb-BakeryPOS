/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllerbeans.ViewReviewsBean;
import controllerbeans.ProductsListBean;
import data.entities.Product;
import data.entities.Productreview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.HomeProduct;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import services.IProductService;
import services.IReviewsService;

/**
 *
 * @author Steven Kritikos
 */
public class ProductsLisBeanTest {

  private ProductsListBean instance;
  private IProductService productservice;
  private IReviewsService reviewservice;
  private ViewReviewsBean reviewsbean;

  @Before
  public void setUp() {
    this.productservice = Mockito.mock(IProductService.class);
    this.reviewservice = Mockito.mock(IReviewsService.class);
    this.reviewsbean = Mockito.mock(ViewReviewsBean.class);
    this.instance = new ProductsListBean();
    this.instance.setProductservice(productservice);
    this.instance.setReviewService(reviewservice);
    this.instance.setViewReviewsBean(reviewsbean);
  }

  @After
  public void cleanUp() {

  }

  @Test
  public void testSetAndGetProductlist() {
    Product p1 = new Product("1");
    Product p2 = new Product("2");
    Product p3 = new Product("3");
    Productreview pr1 = new Productreview("1");
    Productreview pr2 = new Productreview("2");
    Productreview pr3 = new Productreview("3");
    HomeProduct hp1 = new HomeProduct(p1, pr1);
    HomeProduct hp2 = new HomeProduct(p2, pr2);
    HomeProduct hp3 = new HomeProduct(p3, pr3);
    List<HomeProduct> expectedResult = Arrays.asList(hp1, hp2, hp3);
    this.instance.setProductlist(expectedResult);
    List<HomeProduct> result = this.instance.getProductlist();
    assertThat(result, is(expectedResult));
  }

  @Test
  public void testInit() {
    Product p1 = new Product("1");
    Product p2 = new Product("2");
    Product p3 = new Product("3");
    Productreview pr1 = new Productreview("1");
    Productreview pr2 = new Productreview("2");
    Productreview pr3 = new Productreview("3");
    HomeProduct hp1 = new HomeProduct(p1, pr1);
    HomeProduct hp2 = new HomeProduct(p2, pr2);
    HomeProduct hp3 = new HomeProduct(p3, pr3);
    List<HomeProduct> expectedResult = Arrays.asList(hp1, hp2, hp3);
    Mockito.when(this.productservice.getAllProducts()).thenReturn(Arrays.asList(p1, p2, p3));
    Mockito.when(this.reviewservice.getReviewsByProduct(Matchers.any(Product.class)))
            .thenReturn(Arrays.asList(pr1)).thenReturn(Arrays.asList(pr2)).thenReturn(Arrays.asList(pr3));
    this.instance.init();
    List<HomeProduct> result = this.instance.getProductlist();
    assertEquals(expectedResult.size(), result.size());
  }

  @Test
  public void testSetAndGetViewReviewsBean() {
    ViewReviewsBean expectedResult = new ViewReviewsBean();
    this.instance.setViewReviewsBean(expectedResult);
    ViewReviewsBean result = this.instance.getViewReviewsBean();
    assertEquals(expectedResult, result);
  }

  @Test
  public void testViewReviewClick() {
//        String expectedResult = "viewreviews.xhtml";
//        String result = this.instance.viewReviewsClick();
//        assertEquals(expectedResult, result);
  }
}
