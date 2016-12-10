/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import data.entities.Product;
import data.entities.Productreview;
import java.util.List;
import model.HomeProduct;
import services.IProductService;
import services.IReviewsService;
import services.ProductService;

/**
 *
 * @author Steven
 */
public interface IProductListBean {

  public void init();

  public void setProductlist(List<HomeProduct> productList);

  public List<HomeProduct> getProductlist();

  public void setProductservice(IProductService productservice);

  public void setReviewService(IReviewsService reviewService);

  public String viewReviewsClick();

  public ViewReviewsBean getViewReviewsBean();

  public void setViewReviewsBean(ViewReviewsBean viewReviewsBean);
}
