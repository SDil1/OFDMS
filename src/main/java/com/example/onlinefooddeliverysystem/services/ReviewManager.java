package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Review;
import com.example.onlinefooddeliverysystem.util.fileHandler;

import java.util.ArrayList;

public class ReviewManager {
    private static ArrayList<Review> reviews = null;
    private static final String fileName = "reviews.txt";
    private static int reviewID = 0;

    public static void readReviews() {
        if (reviews != null) return;

        reviews = new ArrayList<>();
        String[] dataArr = fileHandler.readFromFile(fileName);
        int lastID = 0;

        for (String data : dataArr) {
            String[] parts = data.split(",");
            lastID = Integer.parseInt(parts[0]);
            int userId = Integer.parseInt(parts[1]);
            int foodId = Integer.parseInt(parts[2]);
            String comment = parts[3];

            reviews.add(new Review(lastID, userId, foodId, comment));
        }

        reviewID = lastID;
    }

    public static void add(int userId, int foodId, String comment) {
        int id = getNextID();
        Review review = new Review(id, userId, foodId, comment);
        reviews.add(review);
        fileHandler.writeToFile(fileName, true, review.getDetails());
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
            saveReviewsToFile();
        }
    }

    public static void edit(int reviewId, String newComment) {
        for (Review r : reviews) {
            if (r.getId() == reviewId) {
                r.setComment(newComment);
                break;
            }
        }
        saveReviewsToFile();
    }

    public static void saveReviewsToFile() {
        String data = "";
        for (Review r : reviews) {
            data += r.getDetails();
        }
        fileHandler.writeToFile(fileName, false, data);
    }

    public static int getNextID() {
        return ++reviewID;
    }

    public static ArrayList<Review> getReviews() {
        return reviews;
    }
}
