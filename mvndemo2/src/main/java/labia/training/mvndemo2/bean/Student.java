/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvndemo2.bean;

/**
 *
 * @author loi4
 */
public class Student {
    private int sid;
    private String sname;
    private Department department;  

    public Student() {
    }
    

    public Student(Department department) {
        this.department = department;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment2(Department department) {
        this.department = department;
    }
    
    public void setDepartment3(Department department) {
        this.department = department;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    
}
