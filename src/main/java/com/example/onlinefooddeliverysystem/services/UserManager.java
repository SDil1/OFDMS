package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.util.dbManager;
import java.sql.*;
import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = null;
    private static int ID = 0;

    // Load users from database into list
    public static void readUsers() {
        if (users != null) return;

        users = new ArrayList<>();
        users.add(new User(0, "user", 10, "123", "user@gmail.com")); // default user

        try (Connection con = dbManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String password = rs.getString("password");
                String mail = rs.getString("mail");

                users.add(new User(id, name, age, password, mail));
                ID = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add new user to list and DB
    public static void registerUser(String name, int age, String password, String mail) {
        int id = getNextID();
        User user = new User(id, name, age, password, mail);
        users.add(user);

        try (Connection con = dbManager.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO users (id, name, age, password, mail) VALUES (?, ?, ?, ?, ?)")) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, password);
            ps.setString(5, mail);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Find user by ID in the list
    public static User findUser(int id) {
        for (User user : users) {
            if (user.getID() == id) return user;
        }
        return null;
    }

    // Simple login check by email and password
    public static User loginUser(String mail, String password) {
        for (User user : users) {
            if (user.getMail().equals(mail) && user.getPassword().equals(password)) return user;
        }
        return null;
    }

    // Return user profile by ID
    public static User viewProfile(int id) {
        return findUser(id);
    }

    // Delete user from list and DB
    public static void deleteUser(int id) {
        User toDelete = findUser(id);
        if (toDelete != null) {
            users.remove(toDelete);

            try (Connection con = dbManager.getConnection();
                 PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?")) {

                ps.setInt(1, id);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void updateUser(User user) {
        try (Connection con = dbManager.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE users SET name=?, age=?, password=?, mail=? WHERE id=?")) {

            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getMail());
            ps.setInt(5, user.getID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Get next available ID
    public static int getNextID() {
        return ++ID;
    }

    // Get all users loaded in memory
    public static ArrayList<User> getUsers() {
        return users;
    }

}
