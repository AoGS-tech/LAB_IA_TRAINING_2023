/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.hibernatemvcintegration.service;

import java.util.List;
import labia.training.hibernatemvcintegration.dao.UserDao;
import labia.training.hibernatemvcintegration.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author loi4
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);

    }

    public List<User> list() {
        return userDao.list();

    }

}
