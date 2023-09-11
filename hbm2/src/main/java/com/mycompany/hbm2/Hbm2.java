/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hbm2;

import com.mycompany.hbm2.entities.Department;
import com.mycompany.hbm2.entities.Employee;
import com.mycompany.hbm2.utils.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author loi4
 */
public class Hbm2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
//            hbm1
//            session.beginTransaction();
//            Department department = new Department("cong nghe thong tin");
//            session.save(department);
//
//            Employee employee = new Employee("thaysondeptrai", department);
//            session.save(employee);

            String sql = "FROM Department d";
            Query query = session.createQuery(sql);
            List<Object> deparmtents =  query.list();
            for(Object objects : deparmtents){
                System.out.println("Hello may cung");
                System.out.println(((Department)objects).getDname() + " " + ((Department)objects).getDid());
            }
            
            String sql2 = "FROM Employee e join department d";
            Query query2 = session.createQuery(sql2);
            List<Object> employess = query2.list();
            for(Object object: employess){
                System.out.println(object);
//                System.out.println((Employee)object[0] +" "+ (Department)object[1]);
            }
            
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object> criteria = builder.createQuery(Object.class);
            Root<Object> root = criteria.from(Object.class);
            criteria.select(root);
            Query<Object> q = session.createQuery(criteria);
            List<Object> list = q.getResultList();
            
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
