/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author loi4
 */
@Controller
public class TestController {
    @GetMapping("/")
    public String display(){
        return "index.jsp";
    }
    
    @GetMapping("/test")
    public String display1(){
        return "hello.jsp";
    }
}
