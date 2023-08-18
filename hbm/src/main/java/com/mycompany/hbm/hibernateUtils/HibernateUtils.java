/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbm.hibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author loi4
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        // Create a new Configuration object
        Configuration cfg = new Configuration();
        cfg.configure();

        // Get the SessionFactory object from Configuration
        if (sessionFactory == null) {
            sessionFactory = cfg.buildSessionFactory();
        }
    }

}
