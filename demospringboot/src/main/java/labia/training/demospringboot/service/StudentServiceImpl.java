/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.demospringboot.service;

import java.util.Optional;
import labia.training.demospringboot.dao.StudentDao;
import labia.training.demospringboot.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author loi4
 */
@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Optional<Student> getById(int id) {
        return studentDao.findById(id);
    }
    
}
