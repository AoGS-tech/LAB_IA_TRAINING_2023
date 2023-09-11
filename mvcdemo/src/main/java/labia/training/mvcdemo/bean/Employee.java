/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvcdemo.bean;

/**
 *
 * @author loi4
 */
public class Employee {

    private int eid;
    private String ename;
    private Address address;

    public Employee() {
    }

    public Employee(int eid, String ename, Address address) {
        this.eid = eid;
        this.ename = ename;
        this.address = address;
    }

    public Employee(Address address) {
        super();
        this.address = address;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
