/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.liquidrekto.data.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.liquidrekto.json.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author WINDOWS
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
@Table(name="student")
public class Student {
    @ManyToOne
    @JsonView(Views.InternalStudent.class)
    @JoinColumn(name="class_id", nullable=false)
    private Class studentClass;
    
    @Column(name="dob")
    @JsonView(Views.Public.class)
    private LocalDate dob;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    @Column(name="id")
    private int id;
    
    @JsonView(Views.Public.class)
    @Column(name="address")
    private String address;
    
    @JsonView(Views.Public.class)
    @Column(name="first_name")
    private String firstName;
    
    @JsonView(Views.Public.class)
    @Column(name="last_name")
    private String lastName;

    public Student() {
    }
    

    public Student(Class studentClass, LocalDate dob, String address, String firstName, String lastName) {
        this.studentClass = studentClass;
        this.dob = dob;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    

    public Class getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
}
