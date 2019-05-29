package lk.ijse.pos.db;

import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.entity.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        File file = new File("resources/application.properties");

        Properties properties = new Properties();

        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (Exception e) {
            Logger.getLogger("lk.ijse.pos.db").log(Level.SEVERE, null,e);
            System.exit(1);
        }

        //EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

        return Persistence.createEntityManagerFactory("unit1", properties);
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();

    }

}
