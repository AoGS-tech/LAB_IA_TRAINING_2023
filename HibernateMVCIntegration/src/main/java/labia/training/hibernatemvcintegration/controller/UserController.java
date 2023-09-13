/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.hibernatemvcintegration.controller;

import java.util.List;
import labia.training.hibernatemvcintegration.dao.UserDaoImp;
import labia.training.hibernatemvcintegration.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loi4
 */
@RestController
public class UserController {
    @GetMapping("/listUser")
    public String listUser(){
//        UserDaoImp userDaoImp = new UserDaoImp();
//        String out = "";
//        List<User> users = userDaoImp.list();
//        for(User user: users){
//            out = user.getName()+"\n";
//        }
        return "hello";
    }
}
