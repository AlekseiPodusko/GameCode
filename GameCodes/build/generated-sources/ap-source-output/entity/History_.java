package entity;

import entity.Code;
import entity.Product;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-28T11:52:37")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, Date> purchaseDate;
    public static volatile SingularAttribute<History, Product> product;
    public static volatile SingularAttribute<History, Code> code;
    public static volatile SingularAttribute<History, Long> id;
    public static volatile SingularAttribute<History, User> user;

}