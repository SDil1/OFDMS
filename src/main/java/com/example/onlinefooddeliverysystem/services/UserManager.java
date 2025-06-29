package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.util.fileHandler;
import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = null;
    private static final String fileName = "users.txt";
    private static int ID = 0;

    // Read users from file and load into the list
    public static void readUsers() {
        if (users != null)
            return;

        users = new ArrayList<>();

        // Add a default admin user
        users.add(new User(0, "user", 10, "123", "user@gmail.com"));

        String[] usersDataArr = fileHandler.readFromFile(fileName);
        int userID = 0;

        for (String userData : usersDataArr) {
            String[] userDataArr = userData.split(",");
            userID = Integer.parseInt(userDataArr[0]);
            String name = userDataArr[1];
            int age = Integer.parseInt(userDataArr[2]);
            String password = userDataArr[3];
            String mail = userDataArr[4];

            User user = new User(userID, name, age, password, mail);
            users.add(user);
        }

        ID = userID;
    }

    // Find user by ID
    public static User findUser(int id) {
        for (User user : users) {
            if (user.getID() == id) {
                return user;
            }
        }
        return null;
    }

    // Register new user
    public static void registerUser(String name,int age, String password, String mail) {
        User user = new User(getNextID(), name, age, password , mail);
        users.add(user);
        fileHandler.writeToFile(fileName, true, user.getDetails());
    }

    // Login functionality (simple check for email and password)
    public static User loginUser(String mail, String password) {
        for (User user : users) {
            if (user.getMail().equals(mail) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Return null if no matching user is found
    }

    // View profile
    public static User viewProfile(int id) {
        return findUser(id); // Just return the user object by ID
    }

    // Delete user
    public static void deleteUser(int id) {
        users.remove(findUser(id));
        saveUsersToFile();
    }

    // Save all users to file after any modification
    public static void saveUsersToFile() {
        String userDetails = "";
        for (User user : users) {
            if (user.getID() != 0) userDetails += user.getDetails();
        }
        fileHandler.writeToFile(fileName, false, userDetails);
    }

    // Get the next ID to assign
    public static int getNextID() {
        return ++ID;
    }

    // Return the list of all users
    public static ArrayList<User> getUsers() {
        return users;
    }
}
