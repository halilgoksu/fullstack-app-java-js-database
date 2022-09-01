package com.revature.CreateLogin.entity;

public class Person {
    private int id;
    private String name;
    private String password;
    private String stafftype;


    public Person() {

    }


    public Person(int id, String name, String password,String stafftype) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.stafftype=stafftype;
    }

    public Person(String name, String password,String stafftype) {
        this.name = name;
        this.password = password;
        this.stafftype=stafftype;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStafftype() {
        return stafftype;
    }

    public void setStafftype(String stafftype) {
        this.stafftype = stafftype;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", stafftype='" + stafftype + '\'' +
                '}';
    }
}
