package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Food;
import com.example.onlinefooddeliverysystem.util.dbManager;
import java.sql.*;
import java.util.ArrayList;

public class FoodManager {
    private static ArrayList<Food> foodItems = null;

    public static void readFoodItems() {
        if (foodItems != null) return;

        foodItems = new ArrayList<>();

        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM food")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String imagePath = rs.getString("imagePath");

                foodItems.add(new Food(id, name, description, price, category, imagePath));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(int id, String name, String description, double price, String category, String imagePath) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO food (id, name, description, price, category, imagePath) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setDouble(4, price);
            ps.setString(5, category);
            ps.setString(6, imagePath);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, String name, String description, double price, String category, String imagePath) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE food SET name = ?, description = ?, price = ?, category = ?, imagePath = ? WHERE id = ?")) {

            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setString(4, category);
            ps.setString(5, imagePath);
            ps.setInt(6, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void remove(int id) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM food WHERE id = ?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Food find(int id) {
        readFoodItems();

        for (Food food : foodItems) {
            if (food.getID() == id) {
                return food;
            }
        }
        return null;
    }

    public static ArrayList<Food> view() {
        readFoodItems();
        return foodItems;
    }


    public static ArrayList<Food> getFoodItems() {
        readFoodItems();
        return foodItems;
    }

    public static int getNextID() {
        int nextID = 1;
        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS max_id FROM food")) {

            if (rs.next()) {
                nextID = rs.getInt("max_id") + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextID;
    }
}
