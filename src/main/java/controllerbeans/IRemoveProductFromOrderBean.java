/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import services.ICateringOrderService;
import services.IProductService;

/**
 *
 * @author Steven
 */
public interface IRemoveProductFromOrderBean {

  public void removeProductFromOrder();

  public void setUserbean(UserBean userbean);

  public UserBean getUserbean();

  public void setOrderservice(ICateringOrderService orderservice);

  public IProductService getProductservice();

  public void setProductservice(IProductService productservice);
}
