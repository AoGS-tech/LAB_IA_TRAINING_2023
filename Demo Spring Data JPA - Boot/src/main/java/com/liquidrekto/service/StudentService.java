/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.service;

import com.liquidrekto.data.model.Student;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

/**
 *
 * @author WINDOWS
 */
public interface StudentService {
    Optional<Student> findStudentById(int studentId);
    
    Iterable<Student> findAllStudents();
    
    Page<Student> findAllStudents(Pageable pageable);
    
    void deleteStudent(Student std);
    
    Student saveStudent(Student std);
    
    
}
