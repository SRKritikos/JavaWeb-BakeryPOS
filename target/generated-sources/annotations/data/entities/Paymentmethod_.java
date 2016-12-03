package data.entities;

import data.entities.Cateringorder;
import data.entities.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:28:48")
@StaticMetamodel(Paymentmethod.class)
public class Paymentmethod_ { 

    public static volatile SingularAttribute<Paymentmethod, String> cardCvv;
    public static volatile ListAttribute<Paymentmethod, Cateringorder> cateringorderList;
    public static volatile SingularAttribute<Paymentmethod, String> paymentMethodId;
    public static volatile SingularAttribute<Paymentmethod, Date> dateTo;
    public static volatile SingularAttribute<Paymentmethod, Customer> customerId;
    public static volatile SingularAttribute<Paymentmethod, String> cardNumber;

}