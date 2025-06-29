package com.example.onlinefooddeliverysystem.models;

public class Food {
    //    intializing the attributes
    private int ID;
    private String name;
    private String Description;
    private double price;
    private String Category;
    private String imagePath;

//    constructer
    public Food(int ID, String name, String description,  double price, String category, String imagePath) {
        this.ID = ID;
        this.Description = description;
        this.name = name;
        this.price = price;
        this.Category = category;
        this.imagePath = imagePath;
    }

//    implementing getters and setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    //    implementing the get details method
    public String getDetails() {
        return ID+","+Description+","+name+","+price+","+Category+","+imagePath+"\n";
    }
}
