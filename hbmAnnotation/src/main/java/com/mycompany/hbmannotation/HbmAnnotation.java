/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hbmannotation;

import com.mycompany.hbmannotation.cfg.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author loi4
 */
public class HbmAnnotation {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction(); // Start the transaction

            // Creating a department object
            
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback(); // Rollback the transaction on exception
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.shutdown();
        }
    }
}
