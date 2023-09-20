/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.demospringboot.controller;

import java.util.Optional;
import labia.training.demospringboot.entites.Student;
import labia.training.demospringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 * @author loi4
 */
@Controller
public class TestController {
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String hello(Model model){
        Optional<Student> student = studentService.getById(0);
        String str = student.toString();
        model.addAttribute("hello", str);
        return "hello";
    }
}
