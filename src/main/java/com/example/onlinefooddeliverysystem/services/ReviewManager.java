package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Review;
import com.example.onlinefooddeliverysystem.util.dbManager;
import java.sql.*;

import java.util.ArrayList;

public class ReviewManager {
    private static ArrayList<Review> reviews = null;
    private static int reviewID = 0;

    public static void readReviews() {
        if (reviews != null) return;

        reviews = new ArrayList<>();
        int lastID = 0;

        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM review")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int foodId = rs.getInt("food_id");
                String comment = rs.getString("comment");

                reviews.add(new Review(id, userId, foodId, comment));
                lastID = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        reviewID = lastID;
    }

    public static void add(int userId, int foodId, String comment) {
        int id = getNextID();
        Review review = new Review(id, userId, foodId, comment);
        reviews.add(review);

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO review (id, user_id, food_id, comment) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, id);
            stmt.setInt(2, userId);
            stmt.setInt(3, foodId);
            stmt.setString(4, comment);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int reviewId) {
        Review toRemove = null;
        for (Review r : reviews) {
            if (r.getId() == reviewId) {
                toRemove = r;
                break;
            }
        }

        if (toRemove != null) {
            reviews.remove(toRemove);

            try (Connection conn = dbManager.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM review WHERE id = ?")) {
                stmt.setInt(1, reviewId);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void edit(int reviewId, String newComment) {
        for (Review r : reviews) {
            if (r.getId() == reviewId) {
                r.setComment(newComment);
                break;
            }
        }

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE review SET comment = ? WHERE id = ?")) {
            stmt.setString(1, newComment);
            stmt.setInt(2, reviewId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getNextID() {
        return ++reviewID;
    }

    public static ArrayList<Review> getReviews() {
        return reviews;
    }
}
