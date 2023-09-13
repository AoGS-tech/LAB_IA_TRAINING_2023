
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.testmvcweb.controller;

import labia.training.testmvcweb.entities.User;
import labia.training.testmvcweb.service.UserService;
import labia.training.testmvcweb.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loi4
 */
@RestController
public class SampleController {

    @GetMapping("/")
    public String showForm() {
//        User user = new User();
//        user.setId(0);
//        user.setName("test");
        return "sample";
    }

}
