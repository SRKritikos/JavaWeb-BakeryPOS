/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.entities.Cateringorder;
import data.entities.Product;
import data.entities.Productcategory;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import services.IProductService;

/**
 *
 * @author Steven
 */
@Local
public interface ICateringBean {
    public Map<Productcategory, List<Product>> getCateringModel();
    public void setCateringModel(Map<Productcategory, List<Product>> cateringModel);
    public List<Cateringorder> getUserOrders();
    public void setUserOrders(List<Cateringorder> userOrders);
    public String getCurrentOrderId();
    public void setCurrentOrderId(String orderId);
    public UserBean getUser();
    public void setUser(UserBean user);
    public String changeOrder();
    public IProductService getProductservice();
    public void setProductservice(IProductService productservice);
}
