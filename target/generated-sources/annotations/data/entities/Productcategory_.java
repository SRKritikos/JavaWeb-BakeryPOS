package data.entities;

import data.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T23:56:33")
@StaticMetamodel(Productcategory.class)
public class Productcategory_ { 

    public static volatile SingularAttribute<Productcategory, String> name;
    public static volatile SingularAttribute<Productcategory, Integer> categoryId;
    public static volatile ListAttribute<Productcategory, Product> productList;

}