package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Admin;
import com.example.onlinefooddeliverysystem.util.dbManager;
import com.example.onlinefooddeliverysystem.util.fileHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminManager {
    public static ArrayList<Admin>=getAdmins(){
        ArrayList<Admin> admins= new ArrayList<>();

        try(Connection conn= dbManager.getConnection()){
            String query="SELECT*FROM admins";
            PreparedStatement stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String mail=rs.getString("mail");
                String password=rs.getString("password");

                Admin admin=new Admin(id,name,age,mail,password);
                admins.add(admin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
