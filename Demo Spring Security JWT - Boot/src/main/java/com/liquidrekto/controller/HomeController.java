/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import java.util.Set;
import java.util.stream.Collectors;
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
        Set<String> role = null;
        String username = "";
        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
            role = ((UserDetails)principal).getAuthorities().stream()
                    .map(r -> r.getAuthority())
                    .collect(Collectors.toSet());
         
        } else {
            username = principal.toString();
            role = null;
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        if (username != "anonymousUser") {
            mv.addObject("user",username);
        }
        if (role != null) {
            mv.addObject("roles",role);
        }
        return mv;
    }
    
    @GetMapping("/login")
    public String login() {
        return "login.jsp";
    }
    
    @GetMapping("/403")
    public String forbidden() {
        return "403.jsp";
    }

    
    @RequestMapping("/logout-success")
    public String logout() {
        return "logout.jsp";
    }
}
