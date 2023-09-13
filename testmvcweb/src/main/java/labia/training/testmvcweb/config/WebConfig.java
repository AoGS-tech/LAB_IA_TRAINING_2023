/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.testmvcweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author loi4
 */
@Configuration
@EnableWebMvc
@ComponentScan({"labia.training.testmvcweb.controller","labia.training.testmvcweb.service"})
public class WebConfig {
    
}
