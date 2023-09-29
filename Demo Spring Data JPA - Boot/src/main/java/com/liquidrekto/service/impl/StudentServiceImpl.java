/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.service.impl;

import com.liquidrekto.data.model.Student;
import com.liquidrekto.data.repository.StudentRepository;
import com.liquidrekto.service.StudentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author WINDOWS
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    
    @Override
    public Optional<Student> findStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }    

    @Override
    public void deleteStudent(Student std) {
        studentRepository.delete(std);
    }

    @Override
    public Student saveStudent(Student std) {
        return studentRepository.save(std);
    }

    @Override
    public Page<Student> findAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }   
    
}
