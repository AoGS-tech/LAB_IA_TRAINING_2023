/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvc.dao;

import java.util.List;
import labia.training.mvc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author loi4
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }

    @Override
    public List<Student> list() {
        Query<Student> query = sessionFactory.getCurrentSession()
                .createQuery("from Student");
        return query.getResultList();

    }

}
