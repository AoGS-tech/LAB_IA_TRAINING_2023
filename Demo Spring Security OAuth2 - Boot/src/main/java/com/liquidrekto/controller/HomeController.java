/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home.jsp";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login.jsp";
    }
    
    @GetMapping("/secured")
    public String login_sec() {
        return "Login success!";
    }
}
