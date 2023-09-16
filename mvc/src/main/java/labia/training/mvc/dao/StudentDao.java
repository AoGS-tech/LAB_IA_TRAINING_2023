/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvc.dao;

import java.util.List;
import labia.training.mvc.entities.Student;

/**
 *
 * @author loi4
 */
public interface StudentDao {

    void save(Student student);

    List<Student> list();

}
