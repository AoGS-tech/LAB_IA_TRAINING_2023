/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.hibernatemvcintegration.dao;

import jakarta.transaction.Transactional;
import java.util.List;
import labia.training.hibernatemvcintegration.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loi4
 */
@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override

    public List<User> list() {

        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User");

        return query.getResultList();

    }

}
