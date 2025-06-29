package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Food;
import com.example.onlinefooddeliverysystem.util.fileHandler;
import java.util.ArrayList;

public class FoodManager {
    private static ArrayList<Food> foodItems = null;
    private static final String fileName = "food_items.txt";
    private static int foodID = 0;

    public static void readFoodItems() {
        if (foodItems != null)
            return;

        foodItems = new ArrayList<>();

        String[] foodDataArr = fileHandler.readFromFile(fileName);
        int lastID = 0;

        for (String foodData : foodDataArr) {
            String[] item = foodData.split(",");
            lastID = Integer.parseInt(item[0]);
            String name = item[1];
            String description = item[2];
            double price = Double.parseDouble(item[3]);
            String category = item[4];
            String imagePath = item[5];

            foodItems.add(new Food(lastID ,name ,description, price, category, imagePath));
        }

        foodID = lastID;
    }

    public static void add(int id, String name, String description, double price,String category, String imagePath) {
        Food food = new Food(id, name ,description,price,category, imagePath);
        foodItems.add(food);
        fileHandler.writeToFile(fileName, true, food.getDetails());
    }

    public static void update(int id, String name, String description, double price,String category, String imagePath) {
        Food food = find(id);
        if (food != null) {
            food.setName(name);
            food.setDescription(description);
            food.setPrice(price);
            food.setCategory(category);
            food.setImagePath(imagePath);
        }
        saveFoodItemsToFile();
    }

    public static void remove(int id) {
        foodItems.remove(find(id));
        saveFoodItemsToFile();
    }

    public static Food find(int id) {
        for (Food food : foodItems) {
            if (food.getID() == id) {
                return food;
            }
        }
        return null;
    }

    public static void view() {
        for (Food food : foodItems) {
            if (food.getID() != 0) {
                System.out.println("ID: " + food.getID() + " | Name: " + food.getName() + " | Price: Rs. " + food.getPrice());
            }
        }
    }

    public static void saveFoodItemsToFile() {
        String data = "";
        for (Food food : foodItems) {
            if (food.getID() != 0) {
                data += food.getDetails();
            }
        }
        fileHandler.writeToFile(fileName, false, data);
    }

    public static int getNextID() {
        return ++foodID;
    }

    public static ArrayList<Food> getFoodItems() {
        return foodItems;
    }
}
