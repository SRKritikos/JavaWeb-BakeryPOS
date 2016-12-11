/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.dao.CateringOrderDAOImpl;
import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.Customer;
import data.entities.Paymentmethod;
import data.entities.Product;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface ICateringOrderService {

  public Cateringorder createNewCateringOrder(Date dateCreated, Date deliveryDate, Paymentmethod paymentMethod, Customer customer, List<CateringorderProduct> orderProductList);

  public CateringorderProduct addToCateringOrderProducts(Product product, Cateringorder order);

  public CateringorderProduct removeFromCateringOrderProduct(Product product, Cateringorder order);

  public Cateringorder getCateringOrderById(String cateringId);

  public List<Cateringorder> getCateringOrdersForCustomer(Customer customer);

  public void setOrderDAO(CateringOrderDAOImpl orderDAO);
  
  public boolean processOrder(Cateringorder order, Paymentmethod paymentMethod);
}
