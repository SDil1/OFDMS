package com.example.onlinefooddeliverysystem.models;

public class Review {
//    intializing the attributes
    private int id;
    private int user_id;
    private int food_id;
    private String comment;

//    parametrized constructer

    public Review(int id, int user_id, int food_id, String comment) {
        this.id = id;
        this.user_id = user_id;
        this.food_id = food_id;
        this.comment = comment;
    }

//    implementing getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
//    implementing the get details method
    public String getDetails() {
        return id+","+user_id+","+food_id+","+comment;
    }
}
