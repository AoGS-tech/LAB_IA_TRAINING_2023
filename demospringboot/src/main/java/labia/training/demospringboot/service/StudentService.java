/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.demospringboot.service;

import java.util.Optional;
import labia.training.demospringboot.entites.Student;

/**
 *
 * @author loi4
 */
public interface StudentService {
    void save(Student student);
    
    Optional<Student> getById(int id);
}
