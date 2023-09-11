/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbm2.utils;

import com.mycompany.hbm2.entities.Department;
import com.mycompany.hbm2.entities.Employee;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 *
 * @author loi4
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    
    static {
        try {
            Configuration configuration = new Configuration();
            
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hbm3");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "1");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
            properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
            configuration.setProperties(properties);
            
            configuration = configuration.addAnnotatedClass(Department.class);
            configuration = configuration.addAnnotatedClass(Employee.class);
            
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration)
            sessionFactory = configuration.buildSessionFactory();
            
        } catch (Exception e) {
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
}
