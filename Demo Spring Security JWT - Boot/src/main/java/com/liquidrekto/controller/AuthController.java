/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import com.liquidrekto.data.model.AuthRequest;
import com.liquidrekto.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WINDOWS
 */
@RestController
public class AuthController {
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private AuthenticationManager authManager;
    
    @PostMapping("/auth/exec")
    public String authenticateAndGetToken(@RequestBody AuthRequest authReq) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        if (auth.isAuthenticated()) {
            return jwtService.generateToken(authReq.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
        
    }

}
