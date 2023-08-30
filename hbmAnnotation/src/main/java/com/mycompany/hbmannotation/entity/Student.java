/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbmannotation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author loi4
 */
@Entity
@Table(name = "Student",
        indexes = @Index(name = "idx_stu",
                columnList = "id, name, surname"))
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String familyname;
    
    @Column(name = "surname", columnDefinition = "VARCHAR(50) NULL", unique = false, nullable = true)
    private String surname;
    
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Stu_Gro",
                joinColumns = {@JoinColumn(name = "stu_id")},
                inverseJoinColumns = {@JoinColumn(name = "group_id")})
    @OrderBy("name ASC")
    private List<Group1> groups; //sort by name of student
    
    @OneToOne
    @JoinColumn(name = "stuprofile_id")
    private StudentProfile studentProfile;
    
}
