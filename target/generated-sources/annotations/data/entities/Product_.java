package data.entities;

import data.entities.CateringorderProduct;
import data.entities.Productcategory;
import data.entities.Productreview;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:28:48")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> productId;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile ListAttribute<Product, Productreview> productreviewList;
    public static volatile ListAttribute<Product, CateringorderProduct> cateringorderProductList;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Productcategory> categoryId;

}