/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.liquidrekto.data.model.Class;
import com.liquidrekto.json.Views;
import com.liquidrekto.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WINDOWS
 */
@RestController
public class ClassController {
    @Autowired
    ClassService csvc;
    
    @GetMapping(value="/classes")
    public ResponseEntity<Object> list() throws JsonProcessingException {
        Iterable<Class> list = csvc.findAllClasses();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.InternalClass.class).writeValueAsString(list);
        return ResponseEntity.ok(mapper.readTree(result));
    }
}
