package com.example.onlinefooddeliverysystem.models;

public class Order {
    // intisllizing the attributes
    private int id;
    private String orderName;
    private int userId;
    private int foodId;
    private int quantity;
    private double totalPrice;
    private String status;

    // parametrized constructers
    public Order(int id, String orderName, int userId, int foodId, int quantity, double totalPrice, String status) {
        this.id = id;
        this.orderName = orderName;
        this.userId = userId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // implementing the getteres and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // implementing the getdeatils method
    public String getDetails(){
        return id + "," + orderName + "," + userId + "," + foodId + "," + quantity + "," + totalPrice + "," + status + "\n";
    }
}
