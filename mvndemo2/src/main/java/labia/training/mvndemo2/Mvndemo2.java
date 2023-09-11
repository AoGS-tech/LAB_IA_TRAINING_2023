/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package labia.training.mvndemo2;

import labia.training.mvndemo2.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author loi4
 */
public class Mvndemo2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("studentBean.xml");
        Student god = (Student)context.getBean("hellocacban1");
        System.out.println(god.getSid() + " " + god.getSname() + " " + god.getDepartment().getDname());
    }
}
