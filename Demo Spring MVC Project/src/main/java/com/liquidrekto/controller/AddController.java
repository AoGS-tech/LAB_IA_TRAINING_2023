/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author liquidrekto
 */
@Controller
public class AddController {
    
    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {
        int i = Integer.parseInt(req.getParameter("field1"));
        int j = Integer.parseInt(req.getParameter("field2"));
        int k = i + j;
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Add.jsp");
        mv.addObject("result",k);
        return mv;
    }
}
