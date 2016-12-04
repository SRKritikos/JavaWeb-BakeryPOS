/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.entities.Cateringorder;
import data.entities.CateringorderProduct;
import data.entities.CateringorderProductPK;
import data.entities.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */

@Local
public interface ICateringOrderDAO {
    public CateringorderProduct getCateringorderProductById(CateringorderProductPK orderProductPK);
    public boolean updateCateringOrderProduct(CateringorderProduct orderProduct);
    public List<Cateringorder> getCateringOrdersForCustomer(Customer customerId);
    public boolean createNewOrderProduct(CateringorderProduct orderProduct);
}
