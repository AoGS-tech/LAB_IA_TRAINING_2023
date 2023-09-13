/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.testmvcweb.service;

import java.util.List;
import labia.training.testmvcweb.dao.UserDao;
import labia.training.testmvcweb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author loi4
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDao userDao;

    public void setPersonDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        this.userDao.save(user);

    }

    public List<User> list() {
        return this.userDao.list();

    }

}
