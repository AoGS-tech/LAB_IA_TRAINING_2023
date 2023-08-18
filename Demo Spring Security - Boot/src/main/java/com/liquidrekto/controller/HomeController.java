/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login.jsp";
    }
    
    @RequestMapping("/logout-success")
    public String logout() {
        return "logout.jsp";
    }
}
