package data.entities;

import data.entities.Cateringorder;
import data.entities.CateringorderProductPK;
import data.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T07:34:46")
@StaticMetamodel(CateringorderProduct.class)
public class CateringorderProduct_ { 

    public static volatile SingularAttribute<CateringorderProduct, CateringorderProductPK> cateringorderProductPK;
    public static volatile SingularAttribute<CateringorderProduct, Product> product;
    public static volatile SingularAttribute<CateringorderProduct, Integer> quantity;
    public static volatile SingularAttribute<CateringorderProduct, Cateringorder> cateringorder;

}