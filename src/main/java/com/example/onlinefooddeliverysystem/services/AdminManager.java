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
    public static ArrayList<Admin>=

    getAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();

        try (Connection conn = dbManager.getConnection()) {
            String query = "SELECT*FROM admins";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

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

    public static Admin findAdmin(int id) {
        try (Connection conn = dbManager.getConnection()) {
            String query = "SELECT*FROM admins WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String mail = rs.getString("mail");
                String password = rs.getString("password");

                return new Admin(id, name, age, mail, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAdmin(int id, String name, int age, String mail, String password) {
        try (Connection conn = dbConenction.getConnection()) {
            String query = "INSERT INTO admin(id,name,age,mail,password) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
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
        try(Connection conn =dbManager.connection()){
            String query = "DELETE FROM admins WHERE id=?";
            PreparedStatement stmt=conn.prepareStatement(query);
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateAdmin(int id, String name, int age, String mail, String password) {
        try(Connection conn=dbManager.getConnection){
            String query ="UPDATE admin SET name=?,age=?,mail=?,password=? WHERE id=?";
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1,name);
            stmt.setInt(2,age);
            stmt.setString(3,mail);
            stmt.setString(4,password);
            stmt.setInt(5,id);

            stmt.executeUpdate();
        }catch(Exception e ){
            e.printStackTrace();
        }

        public static int getNextID(){
            int maxID = 0;

            try(Connection conn =dbManager.getConnection()){
                String query = "SELECT MAX(id) AS max_id FROM admins";
                PreparedStatement stmt= conn.prepareStatement(query);
                ResultSet rs=stmt.executeQuery();

                if(rs.next()){
                    maxID=rs.getInt("max_id");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return maxID+1;
        }
    }

}
