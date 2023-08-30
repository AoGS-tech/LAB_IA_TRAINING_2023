/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hbm2;

import com.mycompany.hbm2.entities.Department;
import com.mycompany.hbm2.entities.Employee;
import com.mycompany.hbm2.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author loi4
 */
public class Hbm2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Department department = new Department("cong nghe thong tin");
            session.save(department);

            Employee employee = new Employee("thaysondeptrai", department);
            session.save(employee);
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.shutdown();
        }
    }
}
