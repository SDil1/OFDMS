package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Admin;
import com.example.onlinefooddeliverysystem.util.fileHandler;
import java.util.ArrayList;

public class AdminManager {
    private static ArrayList<Admin> admins = null;
    private static final String fileName = "admins.txt";
    private static int ID = 0;

    public static void readAdmins() {
        if (admins != null)
            return;

        admins = new ArrayList<>();

        admins.add(new Admin(0, "admin", 20, "admin@gmail.com", "123"));

        String[] adminsDataArr = fileHandler.readFromFile(fileName);
        int adminID = 0;

        for (String adminData : adminsDataArr) {
            String[] adminDataArr = adminData.split(",");
            adminID = Integer.parseInt(adminDataArr[0]);
            String name = adminDataArr[1];
            int age = Integer.parseInt(adminDataArr[2]);
            String mail = adminDataArr[3];
            String password = adminDataArr[4];


            Admin admin = new Admin(adminID,name,age,mail,password);
            admins.add(admin);
        }

        ID = adminID;
        System.out.println("Admin Count: " + admins.size());
    }

    public static Admin findAdmin(int id) {
        for (Admin admin : admins) {
            if (admin.getID() == id) {
                return admin;
            }
        }
        return null;
    }

    public static void addAdmin(int id,String name,int age,String mail,String password ) {
        Admin admin = new Admin(id,name, age, mail, password);
        admins.add(admin);
        fileHandler.writeToFile(fileName, true, admin.getDetails());
    }

    public static void removeAdmin(int id) {
        admins.remove(findAdmin(id));
        saveAdminsToFile();
    }

    public static void updateAdmin(int id, String name,int age,String mail,String password) {
        Admin admin = findAdmin(id);
        if (admin != null) {
           admin.setName(name);
           admin.setAge(age);
            admin.setMail(mail);
            admin.setPassword(password);
        }
        saveAdminsToFile();
    }

    public static void saveAdminsToFile() {
        String adminDetails = "";
        for (Admin admin : admins) {
            if (admin.getID() != 0) adminDetails += admin.getDetails();
        }
        fileHandler.writeToFile(fileName, false, adminDetails);
    }

    public static int getNextID() {
        return ++ID;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

}
