/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author WINDOWS
 */
public class Root {
    public static String get(HttpServletRequest req, String extraURL) {
        // Get the ServletContext object
        ServletContext context = req.getServletContext();
        
        // Get the context path
        String contextPath = context.getContextPath();
        
        return contextPath + "/" + extraURL;
    }
}
