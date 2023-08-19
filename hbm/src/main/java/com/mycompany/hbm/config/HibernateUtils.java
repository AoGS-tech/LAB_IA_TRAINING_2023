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
import org.hibernate.boot.registry.StandardServiceRegistry;
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

        Properties properties = new Properties();
        properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hbm");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "1");
        properties.put(Environment.SHOW_SQL,"true");
//        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(properties);
        
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
