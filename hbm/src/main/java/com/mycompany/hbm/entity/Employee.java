/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author loi4
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "department")
    private Department dept;
    
    //Constructor, Getter and Setter

    public Employee() {
    }

    public Employee(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
    
    
}
