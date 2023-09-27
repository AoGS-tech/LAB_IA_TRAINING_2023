/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.liquidrekto.data.model.Student;
import com.liquidrekto.service.ClassService;
import com.liquidrekto.service.StudentService;
import com.liquidrekto.json.Views;
import com.liquidrekto.util.Root;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author Admin
 */
@RestController
public class StudentController {
    @Autowired
    StudentService svc;
    
    @Autowired
    ClassService csvc;
    
    @GetMapping(value="/students")
    public ResponseEntity<Object> list() throws JsonProcessingException {
        Iterable<Student> list = svc.findAllStudents();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.InternalStudent.class).writeValueAsString(list);
        return ResponseEntity.ok(mapper.readTree(result));
    }
    
    @PostMapping("/students")
    public ResponseEntity<Map<String,Object>> add(@RequestBody Student student) {
        Map<String,Object> statusJson = new HashMap<>();
        try {
            svc.saveStudent(student);
            statusJson.put("code","200");
            statusJson.put("message","Student inserted successfully!");
            statusJson.put("data",student);
        }
        catch (Exception e) {
            String fullMessage = e.getMessage();
            statusJson.put("code","500");
            statusJson.put("message",String.format("Fail to update student!\nReason: %s",fullMessage));
        }
        
        return ResponseEntity.ok(statusJson);
    }
    
    @GetMapping(value="/students/{id}")
    public ResponseEntity<Object> get(@PathVariable int id) throws JsonProcessingException {
        Map<String,Object> statusJson = new HashMap<>();
        Optional<Student> std = svc.findStudentById(id);
        if (!std.isPresent()) {
            statusJson.put("code","404");
            statusJson.put("message",String.format("Student with id: '%d' can't be found!",id));
            return ResponseEntity.ok(statusJson);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.InternalStudent.class).writeValueAsString(std.get());
        return ResponseEntity.ok(mapper.readTree(result));
    }
    
    @GetMapping(value="/students/byAddress/{address}")
    public ResponseEntity<Object> listByAddress(@PathVariable String address) throws JsonProcessingException {
        System.out.println(address);
        Iterable<Student> list = svc.findStudentsByAddress(address);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.InternalStudent.class).writeValueAsString(list);
        return ResponseEntity.ok(mapper.readTree(result));
    }
    
    
    @PutMapping("/students/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable int id, @RequestBody Student newStudent) {
        Map<String,Object> statusJson = new HashMap<>();
        Optional<Student> std = svc.findStudentById(id);
        if (!std.isPresent()) {
            statusJson.put("code","404");
            statusJson.put("message",String.format("Student with id: '%d' can't be found to update!",id));
            return ResponseEntity.ok(statusJson);
        }

        try {
            Student s = std.get();
            s.setDob(newStudent.getDob());
            s.setAddress(newStudent.getAddress());
            s.setFirstName(newStudent.getFirstName());
            s.setLastName(newStudent.getLastName());
            s.setStudentClass(newStudent.getStudentClass());
            svc.saveStudent(s);
            statusJson.put("code","200");
            statusJson.put("message","Student updated successfully!");
            statusJson.put("data",s);
        }
        catch (Exception e) {
            String fullMessage = e.getMessage();
            statusJson.put("code","500");
            statusJson.put("message",String.format("Fail to update student!\nReason: %s",fullMessage));
        }
        return ResponseEntity.ok(statusJson);
    }
    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable int id) {
        Map<String,Object> statusJson = new HashMap<>();
        Optional<Student> std = svc.findStudentById(id);
        if (!std.isPresent()) {
            statusJson.put("code","404");
            statusJson.put("message",String.format("Student with id: '%d' can't be found to delete!",id));
            return ResponseEntity.ok(statusJson);
        }
        try {
            Student s = std.get();
            svc.deleteStudent(s);
            statusJson.put("code","200");
            statusJson.put("message","Student deleted successfully!");
            statusJson.put("data",s);
        }
        catch (Exception e) {
            String fullMessage = e.getMessage() + "\n" + e.getStackTrace().toString();
            statusJson.put("code","500");
            statusJson.put("message",String.format("Fail to delete student!\nReason: %s",fullMessage));
        }
        
        return ResponseEntity.ok(statusJson);
    }

}
