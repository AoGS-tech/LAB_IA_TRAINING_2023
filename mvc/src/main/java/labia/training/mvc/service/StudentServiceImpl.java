/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvc.service;

import java.util.List;
import labia.training.mvc.dao.StudentDao;
import labia.training.mvc.entities.Student;
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
    public List<Student> list() {
        return studentDao.list();
    }
    
}
