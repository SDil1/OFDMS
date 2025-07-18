package com.example.onlinefooddeliverysystem.services;

import com.example.onlinefooddeliverysystem.models.Driver;
import com.example.onlinefooddeliverysystem.util.dbManager;

import java.sql.*;


import java.util.ArrayList;

public class DriverManager {
    private static ArrayList<Driver> drivers = new ArrayList<>();


    public static void readDrivers() {
        if (drivers != null) return;

        drivers = new ArrayList<>();

        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM drivers")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                drivers.add(new Driver(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void add(String name, int age) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO driver (name, age) VALUES (?, ?)")) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void remove(int id) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM driver WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, String name, int age) {
        try (Connection con = dbManager.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE driver SET name=?, age=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static ArrayList<Driver> view() {
        readDrivers();
        return drivers;
    }

    public static ArrayList<Driver> getDrivers() {
        readDrivers();
        return drivers;
    }
}
