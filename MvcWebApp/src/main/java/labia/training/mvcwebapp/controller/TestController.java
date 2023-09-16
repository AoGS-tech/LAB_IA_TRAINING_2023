/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvcwebapp.controller;

import labia.training.mvcwebapp.entities.Department;
import labia.training.mvcwebapp.entities.Student;
import labia.training.mvcwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String test(ModelMap model){
        Student student = new Student(0, "test");
        model.addAttribute("saysmtnice", student);       
        return "index";
    }
    
    @GetMapping("/save")
    public String save(ModelMap model){
        Student student = new Student(0, "test");
        model.addAttribute("saysmtnice", student);
        studentService.save(student);
        return "index";
    }
}
