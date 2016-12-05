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
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import services.ICustomerService;
import services.IProductService;

/**
 *
 * @author Steven Kritikos
 */
@ManagedBean(name = "catering")
@RequestScoped
public class CateringBean implements ICateringBean{
    private Map<Productcategory, List<Product>> cateringModel;
    private List<Cateringorder> userOrders;
    private String currentOrderId;
    @EJB
    private IProductService productservice;
    @ManagedProperty("#{user}")
    private UserBean user;

    @Override
    public Map<Productcategory, List<Product>> getCateringModel() {
        List<Product> productsList = this.productservice.getAllProducts();
        this.cateringModel = productsList.parallelStream()
                .collect(Collectors
                        .groupingBy(Product::getCategoryId));
        return cateringModel;
    }

    @Override
    public void setCateringModel(Map<Productcategory, List<Product>> cateringModel) {
        this.cateringModel = cateringModel;
    }

    @Override
    public List<Cateringorder> getUserOrders() {
        this.userOrders = this.user.getCustomer().getCateringorderList();
        return userOrders;
    }

    @Override
    public void setUserOrders(List<Cateringorder> userOrders) {
        this.userOrders = userOrders;
    }

    @Override
    public String getCurrentOrderId() {
        return currentOrderId;
    }

    @Override
    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

    @Override
    public String changeOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserBean getUser() {
        return user;
    }

    @Override
    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public IProductService getProductservice() {
        return productservice;
    }
    @Override
    public void setProductservice(IProductService productservice) {
        this.productservice = productservice;
    }
    
    
    
    
}
