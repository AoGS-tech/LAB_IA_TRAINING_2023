/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView home() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        if (username != "anonymousUser") {
            mv.addObject("user",username);
        }
        return mv;
    }
    
    @GetMapping("/login")
    public String login() {
        return "login.jsp";
    }

    
    @RequestMapping("/logout-success")
    public String logout() {
        return "logout.jsp";
    }
}
