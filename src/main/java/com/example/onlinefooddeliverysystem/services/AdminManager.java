package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Admin;
import com.example.onlinefooddeliverysystem.util.dbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminManager {
    private static ArrayList<Admin> admins = new ArrayList<>();

    public static ArrayList<Admin> getAdmins() {
        admins.clear(); // Clear existing list

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String mail = rs.getString("mail");
                String password = rs.getString("password");

                Admin admin = new Admin(id, name, age, mail, password);
                admins.add(admin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static ArrayList<Admin> view() {
        return admins;
    }

    public static Admin findAdmin(int id) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE id=?")) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String mail = rs.getString("mail");
                    String password = rs.getString("password");

                    return new Admin(id, name, age, mail, password);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAdmin(int id, String name, int age, String mail, String password) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO admin (id, name, age, mail, password) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, mail);
            stmt.setString(5, password);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeAdmin(int id) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM admin WHERE id=?")) {

            stmt.setInt(1, id);  // <-- THIS WAS MISSING!
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAdmin(int id, String name, int age, String mail, String password) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE admin SET name=?, age=?, mail=?, password=? WHERE id=?")) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, mail);
            stmt.setString(4, password);
            stmt.setInt(5, id);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readAdmins() {
        admins.clear(); // prevent duplicates on re-call
        getAdmins();
    }



    public static int getNextID() {
        int maxID = 0;

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT MAX(id) AS max_id FROM admin");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                maxID = rs.getInt("max_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxID + 1;
    }

}
