/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvcwebapp.dao;

import labia.training.mvcwebapp.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author loi4
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }
    
}
