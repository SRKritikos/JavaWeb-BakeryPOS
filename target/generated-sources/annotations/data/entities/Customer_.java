package data.entities;

import data.entities.Cateringorder;
import data.entities.Paymentmethod;
import data.entities.Productreview;
import data.entities.Userroles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "EclipseLink-2.5.2.v20140319-rNA", date = "2016-12-08T07:34:46")
@StaticMetamodel(Customer.class)
public class Customer_ {

  public static volatile SingularAttribute<Customer, String> firstName;
  public static volatile SingularAttribute<Customer, String> lastName;
  public static volatile SingularAttribute<Customer, String> password;
  public static volatile ListAttribute<Customer, Cateringorder> cateringorderList;
  public static volatile ListAttribute<Customer, Paymentmethod> paymentmethodList;
  public static volatile SingularAttribute<Customer, Userroles> roleId;
  public static volatile SingularAttribute<Customer, String> customerId;
  public static volatile ListAttribute<Customer, Productreview> productreviewList;
  public static volatile SingularAttribute<Customer, String> username;

}
