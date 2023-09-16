/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvcwebapp.service;

import labia.training.mvcwebapp.dao.StudentDao;
import labia.training.mvcwebapp.entities.Student;
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
    
}
