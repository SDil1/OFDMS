package com.example.onlinefooddeliverysystem.models;

public class Admin extends Driver {
    //    intializing the private attributes
    private String mail;
    private String password;

//    parametrized constructer


    public Admin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Admin(int ID, String name, int age, String mail, String password) {
        super(ID, name, age);
        this.mail = mail;
        this.password = password;
    }

//    implementing the getters and setters

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetails() {
        return getID() + "," + getName() + "," + getAge() + "," + mail + "," + password + "\n";
    }
}

