/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import services.ICustomerService;
import services.IProductService;
import services.IReviewsService;

/**
 *
 * @author Steven
 */
@Local
public interface IWriteReviewBean {

  public void setReviewText(String text);

  public String getReviewText();

  public void setNumStars(int numStars);

  public int getNumStars();

  public void setProductId(String productId);

  public String getProductId();

  public String submitReview();

  public IReviewsService getReviewservice();

  public void setReviewservice(IReviewsService reviewservice);

  public IProductService getProductservice();

  public void setProductservice(IProductService productservice);

  public ICustomerService getCustomerservice();

  public void setCustomerservice(ICustomerService customerservice);

  public void setUser(UserBean user);

  public UserBean getUser();
}
