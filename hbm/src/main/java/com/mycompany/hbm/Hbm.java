/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hbm;

import com.mycompany.hbm.config.HibernateUtils;
import com.mycompany.hbm.entity.Department;
import com.mycompany.hbm.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author loi4
 */
public class Hbm {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            session.beginTransaction(); // Start the transaction

            // Creating a department object
            Department department = new Department();
            department.setName("development");

            // Save department object
            session.save(department);
            System.out.println("Department saved, id: " + department.getId());

            // Creating an employee object
            Employee employee = new Employee();
            employee.setName("yogesh");

            // Set department of employee
            employee.setDept(department);

            // Save employee object
            session.save(employee);
            System.out.println("Employee saved, id: " + employee.getId());

            // Commit transaction
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
