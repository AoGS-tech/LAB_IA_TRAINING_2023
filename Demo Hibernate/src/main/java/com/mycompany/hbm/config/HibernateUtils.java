/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbm.config;

import com.mycompany.hbm.entity.Department;
import com.mycompany.hbm.entity.Employee;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author loi4
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        try{
        Configuration configuration = new Configuration();
        //Set up connection between your app and mysql
        Properties properties = new Properties();
        properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver"); //classname of JDBC driver
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect"); //name of Dialect subclass
        properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hbm"); //JDBC URL (when using DriverManager)
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "1");
        properties.put(Environment.SHOW_SQL,"true");//Enables logging of generated SQL to the console.
        properties.put(Environment.HBM2DDL_AUTO, "update"); //enable auto DDL(Data Defination Language) export
        configuration.setProperties(properties);
        //Add class and hibernate will automatically do jobs with Department and Employee classes
        configuration = configuration.addAnnotatedClass(Department.class);
        configuration = configuration.addAnnotatedClass(Employee.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e){
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
