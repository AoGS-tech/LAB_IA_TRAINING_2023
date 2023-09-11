/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labia.training.mvcdemo.bean;

/**
 *
 * @author loi4
 */
public class Address {
    private String aid;
    private String details;

    public Address() {
    }

    public Address(String aid, String details) {
        this.aid = aid;
        this.details = details;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
