/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import data.dao.CateringOrderDAOImpl;
import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.CateringorderProductPK;
import data.entities.Customer;
import data.entities.Paymentmethod;
import data.entities.Product;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class CateringOrderService implements ICateringOrderService {
    @EJB
    private CateringOrderDAOImpl orderDAO;
    

    @Override
    public Cateringorder createNewCateringOrder(Date dateCreated, Date deliveryDate, Paymentmethod paymentMethod, Customer customer, List<CateringorderProduct> orderProductList) {
        Cateringorder newOrder = new Cateringorder(UUID.randomUUID().toString());
        try {
            newOrder.setCateringorderProductList(orderProductList);
            newOrder.setCustomerId(customer);
            newOrder.setDateCreated(dateCreated);
            newOrder.setDeliveryDate(deliveryDate);
            newOrder.setPaymentMethodId(paymentMethod);
            boolean success = this.orderDAO.create(newOrder);
            if (!success) {
                newOrder = null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return newOrder;
    }

    @Override
    public CateringorderProduct addToCateringOrderProducts(Product product, Cateringorder order) {
        CateringorderProduct rtVl;
        CateringorderProductPK orderProductPK = new CateringorderProductPK(order.getCateringId(), product.getProductId());
        rtVl = this.orderDAO.getCateringorderProductById(orderProductPK);
        boolean success;
        if (rtVl == null) {
            rtVl = new CateringorderProduct(orderProductPK);
            rtVl.setProduct(product);
            rtVl.setCateringorder(order);
            rtVl.setQuantity(1);
            success = this.orderDAO.createNewOrderProduct(rtVl);
        } else {
            rtVl.setQuantity(rtVl.getQuantity() + 1);
            success = this.orderDAO.updateCateringOrderProduct(rtVl);
        }
        if (success) {
            return rtVl;
        }
        return null;
    }

    @Override
    public CateringorderProduct removeFromCateringOrderProduct(Product product, Cateringorder order) {
        CateringorderProduct rtVl;
        CateringorderProductPK orderProductPK = new CateringorderProductPK(order.getCateringId(), product.getProductId());
        rtVl = this.orderDAO.getCateringorderProductById(orderProductPK);
        boolean success = false;
        if (rtVl != null && rtVl.getQuantity() > 0) {
            rtVl.setQuantity(rtVl.getQuantity() - 1);
            success = this.orderDAO.updateCateringOrderProduct(rtVl);
        }
        if (success) {
            return rtVl;
        }
        return null;
    }

    @Override
    public Cateringorder getCateringOrderById(String cateringId) {
        Cateringorder rtVl = this.orderDAO.find(cateringId);
        return rtVl;
    }

    @Override
    public List<Cateringorder> getCateringOrdersForCustomer(Customer customer) {
        List<Cateringorder> rtVl = this.orderDAO.getCateringOrdersForCustomer(customer);
        return rtVl;
    }

    @Override
    public void setOrderDAO(CateringOrderDAOImpl orderDAO) {
        this.orderDAO = orderDAO;
    }
    
    

}
