package com.example.onlinefooddeliverysystem.models;

public class User extends Driver {
    //  initializing the attributes
    private String password;
    private String mail;

    //  parametrized constructor

    public User(String password, String mail) {
        this.password = password;
        this.mail = mail;
    }

    public User(int ID, String name, int age, String password, String mail) {
        super(ID, name, age);
        this.password = password;
        this.mail = mail;
    }

    //  implementing getters setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDetails(){
        return ID + "," + name + "," + age + "," + password + "," + mail + "\n";
    }
}
