/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package labia.training.mvcdemo;

import labia.training.mvcdemo.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author loi4
 */
public class Mvcdemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("employeeBean.xml");
        Employee employee = (Employee) context.getBean("employee");
        System.out.println("Employee detials: "+ employee.getEid() + " " + employee.getEname() + employee.getAddress().getDetails());
    }
}
