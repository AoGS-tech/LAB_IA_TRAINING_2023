/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.testmvcweb.dao;

import java.util.List;
import labia.training.testmvcweb.entities.User;

/**
 *
 * @author loi4
 */
public interface UserDao {

    void save(User user);

    List<User> list();

}