package data.entities;

import data.entities.Customer;
import data.entities.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T18:26:25")
@StaticMetamodel(Productreview.class)
public class Productreview_ { 

    public static volatile SingularAttribute<Productreview, Product> productId;
    public static volatile SingularAttribute<Productreview, Date> reviewDate;
    public static volatile SingularAttribute<Productreview, Customer> customerId;
    public static volatile SingularAttribute<Productreview, Integer> numberStars;
    public static volatile SingularAttribute<Productreview, String> reviewId;
    public static volatile SingularAttribute<Productreview, String> reviewText;

}