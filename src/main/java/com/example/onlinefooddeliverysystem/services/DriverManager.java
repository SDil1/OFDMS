package com.example.onlinefooddeliverysystem.services;

import com.example.onlinefooddeliverysystem.models.Driver;
import com.example.onlinefooddeliverysystem.util.fileHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DriverManager {
    private static ArrayList<Driver> drivers = null;

    public static void readDrivers() {
        if (drivers != null) return;

        drivers = new ArrayList<>();

        try (Connection conn = dbManager.getConnection());
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM drivers")){
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                drivers.add(new Driver(id, name, age));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
