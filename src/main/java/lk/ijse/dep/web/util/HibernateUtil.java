package lk.ijse.dep.web.util;

import lk.ijse.dep.web.entity.Customer;
import lk.ijse.dep.web.entity.Item;
import lk.ijse.dep.web.entity.Order;
import lk.ijse.dep.web.entity.OrderDetail;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-01-29
 **/
public class HibernateUtil {

    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("application.properties")
                .applySetting(Environment.DATASOURCE, getDataSource())
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    private static DataSource getDataSource(){
        try {
            Properties prop = new Properties();
            prop.load(HibernateUtil.class.getResourceAsStream("/application.properties"));
            BasicDataSource bds = new BasicDataSource();
            bds.setInitialSize(5);
            bds.setMaxTotal(10);
            bds.setUrl(prop.getProperty("dbcp.connection.url"));
            bds.setDriverClassName(prop.getProperty("dbcp.connection.driver_class"));
            bds.setUsername(prop.getProperty("dbcp.connection.username"));
            bds.setPassword(prop.getProperty("dbcp.connection.password"));
            return bds;
        }catch(IOException exp){
            logger.error("Failed to load the connection settings", exp);
            throw new RuntimeException(exp);
        }
    }
}
