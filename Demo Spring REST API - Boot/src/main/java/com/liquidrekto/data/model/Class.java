/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.data.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.liquidrekto.json.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

/**
 *
 * @author WINDOWS
 */
@Entity
@Table(name="class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    @Column(name="id")
    private int id;
    
    @JsonView(Views.Public.class)
    @Column(name="class_name")
    private String className;
    
    @JsonView(Views.InternalClass.class)
    @OneToMany(mappedBy="studentClass")
    private Set<Student> students;

    public Class() {
    }

    public Class(int id, String className) {
        this.id = id;
        this.className = className;
        this.students = students;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    
}
