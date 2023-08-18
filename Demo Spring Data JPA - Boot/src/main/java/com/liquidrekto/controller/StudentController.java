/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import com.liquidrekto.data.model.Student;
import com.liquidrekto.service.ClassService;
import com.liquidrekto.service.StudentService;
import com.liquidrekto.data.model.Class;
import com.liquidrekto.util.Root;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author Admin
 */
@Controller
public class StudentController {
    @Autowired
    StudentService svc;
    
    @Autowired
    ClassService csvc;
    
    @GetMapping(value={"/","/students"})
    public ModelAndView list() {
        Iterable<Student> list = svc.findAllStudents();
        Iterable<Class> classes = csvc.findAllClasses();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/list.jsp");
        mv.addObject("studentList",list);
        mv.addObject("classList", classes);
        return mv;
    }
    
    @GetMapping("/student/add")
    public ModelAndView add() {
        Iterable<Class> classes = csvc.findAllClasses();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/add.jsp");
        mv.addObject("classList", classes);
        return mv;
    }
    
    @PostMapping("/student/add")
    public RedirectView add_post(HttpServletRequest req) {
        
        Student std = new Student();
        std.setFirstName(req.getParameter("std_firstname"));
        std.setLastName(req.getParameter("std_lastname"));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        std.setDob(LocalDate.parse(req.getParameter("std_dob"), pattern));
        std.setAddress(req.getParameter("std_address"));
        Class cl = new Class();
        cl.setId(Integer.parseInt(req.getParameter("std_class_id")));
        std.setStudentClass(cl);
        svc.saveStudent(std);
        return new RedirectView(Root.get(req, "students"));
    }
    
    @GetMapping("/student/{id}")
    public ModelAndView detail(@PathVariable int id) {
        Optional<Student> std = svc.findStudentById(id);
        Iterable<Class> classes = csvc.findAllClasses();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/detail.jsp");
        mv.addObject("student",std.get());
        mv.addObject("classList", classes);
        return mv;
    }
    
    @PostMapping("/student/{id}")
    public RedirectView update(@PathVariable int id, HttpServletRequest req) {
        Student std = svc.findStudentById(id).get();
        std.setFirstName(req.getParameter("std_firstname"));
        std.setLastName(req.getParameter("std_lastname"));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        std.setDob(LocalDate.parse(req.getParameter("std_dob"), pattern));
        std.setAddress(req.getParameter("std_address"));
        Class cl = new Class();
        cl.setId(Integer.parseInt(req.getParameter("std_class_id")));
        std.setStudentClass(cl);
        svc.saveStudent(std);
        return new RedirectView(Root.get(req, "students"));
    }
    
    @GetMapping("/student/{id}/delete")
    public RedirectView delete(@PathVariable int id, HttpServletRequest req) {
        Student std = svc.findStudentById(id).get();
        
        svc.deleteStudent(std);
        return new RedirectView(Root.get(req, "students"));
    }

}
