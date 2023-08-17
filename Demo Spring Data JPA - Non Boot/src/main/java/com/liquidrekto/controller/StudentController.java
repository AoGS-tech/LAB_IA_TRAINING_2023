/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Admin
 */
@Controller
public class StudentController {
    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @GetMapping("/add")
    public String add() {
        return "add.jsp";
    }
    
    @GetMapping("/student/{id}")
    public ModelAndView info(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @PutMapping("/student/{id}")
    public RedirectView update() {
        return new RedirectView("/");
    }
    
    @DeleteMapping("/student/{id}")
    public RedirectView delete() {
        return new RedirectView("/");
    }
}
