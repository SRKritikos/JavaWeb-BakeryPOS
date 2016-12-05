package data.entities;

import data.entities.CateringorderProduct;
import data.entities.Customer;
import data.entities.Paymentmethod;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-04T23:14:43")
@StaticMetamodel(Cateringorder.class)
public class Cateringorder_ { 

    public static volatile SingularAttribute<Cateringorder, Date> dateCreated;
    public static volatile SingularAttribute<Cateringorder, Paymentmethod> paymentMethodId;
    public static volatile SingularAttribute<Cateringorder, Customer> customerId;
    public static volatile SingularAttribute<Cateringorder, String> cateringId;
    public static volatile SingularAttribute<Cateringorder, Date> deliveryDate;
    public static volatile ListAttribute<Cateringorder, CateringorderProduct> cateringorderProductList;

}