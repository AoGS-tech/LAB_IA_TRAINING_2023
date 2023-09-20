/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.demospringboot.dao;

import labia.training.demospringboot.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loi4
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
    
}
