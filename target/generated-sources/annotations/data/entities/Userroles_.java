package data.entities;

import data.entities.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:28:48")
@StaticMetamodel(Userroles.class)
public class Userroles_ { 

    public static volatile SingularAttribute<Userroles, Integer> roleId;
    public static volatile ListAttribute<Userroles, Customer> customerList;
    public static volatile SingularAttribute<Userroles, String> roleDescription;

}