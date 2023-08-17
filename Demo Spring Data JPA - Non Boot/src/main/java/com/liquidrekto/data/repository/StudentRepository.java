/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.data.repository;

import com.liquidrekto.data.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author WINDOWS
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}
