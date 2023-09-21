/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvc.controller;

import labia.training.mvc.entities.Student;
import labia.training.mvc.service.StudentService;
import labia.training.mvc.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author loi4
 */
@Controller
public class TestController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String display(){
        return "index";
    }
    
    @GetMapping("/test")
    public String display1(){
        Student student = new Student();
        student.setId(0);
        student.setName("test");
        studentService.save(student);
        return "hello";
    }
}