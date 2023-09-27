/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.service.impl;

import com.liquidrekto.data.model.Class;
import com.liquidrekto.data.repository.ClassRepository;
import com.liquidrekto.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WINDOWS
 */
@Service
public class ClassServiceImpl implements ClassService {
        
    @Autowired
    ClassRepository classRepository;

    @Override
    public Iterable<Class> findAllClasses() {
        return classRepository.findAll();
    }
    
}
