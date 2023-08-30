/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbmannotation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author loi4
 */
@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "Social_Num"))
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String familyname;
    
    @Column(name = "surname", columnDefinition = "VARCHAR(50) NULL", unique = false, nullable = true)
    private String surname;
    
    private String name;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date dob;
    
    @Column(name = "Social_Num", columnDefinition = "VARCHAR(12)", unique = true, nullable = false)
    private String Social_Num;
    
    @OneToOne(mappedBy = "studentProfile")
    private Student student;
    
}
