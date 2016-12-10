/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Product;
import data.entities.Productreview;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.HomeProduct;
import services.IProductService;
import services.IReviewsService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "productlist")
@RequestScoped
public class ProductsListBean implements IProductListBean {

  @EJB
  private IProductService productservice;
  @EJB
  private IReviewsService reviewService;
  @ManagedProperty(value = "#{viewreviews}")
  private ViewReviewsBean viewReviewsBean;
  private List<HomeProduct> productlist;

  @PostConstruct
  @Override
  public void init() {
    this.productlist = new ArrayList();
    List<Product> productList = this.productservice.getAllProducts();
    for (Product p : productList) {
      List<Productreview> reviews = this.reviewService.getReviewsByProduct(p);
      Productreview review = null;
      if (!reviews.isEmpty()) {
        review = reviews.get(0);
      }
      this.productlist.add(new HomeProduct(p, review));
    }
  }

  @Override
  public String viewReviewsClick() {
    String productBeingReviewed = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("productIdForReview");
    Product p = this.productservice.getProductById(productBeingReviewed);
    List<Productreview> reviews = this.reviewService.getReviewsByProduct(p);
    this.viewReviewsBean.setProductReviews(reviews);
    this.viewReviewsBean.setProductBeingReviewed(p);
    return "viewreviews.xhtml";
  }

  @Override
  public List<HomeProduct> getProductlist() {
    return productlist;
  }

  @Override
  public void setProductlist(List<HomeProduct> productlist) {
    this.productlist = productlist;
  }

  @Override
  public void setProductservice(IProductService productservice) {
    this.productservice = productservice;
  }

  public void setReviewService(IReviewsService reviewService) {
    this.reviewService = reviewService;
  }

  @Override
  public ViewReviewsBean getViewReviewsBean() {
    return viewReviewsBean;
  }

  @Override
  public void setViewReviewsBean(ViewReviewsBean viewReviewsBean) {
    this.viewReviewsBean = viewReviewsBean;
  }

}
