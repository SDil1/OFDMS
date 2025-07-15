package com.example.onlinefooddeliverysystem.util;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class test {
    public static void main(String[] args) {
        try (Connection conn = dbManager.getConnection()) {
            String sql = "INSERT INTO user (name, age, password, mail) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "TestUser");
            stmt.setInt(2, 25);
            stmt.setString(3, "pass123");
            stmt.setString(4, "testuser@example.com");
            int rows = stmt.executeUpdate();
            System.out.println("Inserted rows: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection conn = dbManager.getConnection()) {
            System.out.println("✅ Connected to the database!");
        } catch (Exception e) {
            System.out.println("❌ Connection failed:");
            e.printStackTrace();
        }
    }
}
