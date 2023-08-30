/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hbmannotation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author loi4
 */
@Entity
@Getter
@Setter
public class CourseDetails {
    @Id
    @GeneratedValue(generator = "key")
    @GenericGenerator(parameters = @Parameter(name = "property", value = "course"), name = "key")
    private int id;
    
    private String detail;
    
    @OneToOne(mappedBy = "courseDetails")
    private Course course;
}
