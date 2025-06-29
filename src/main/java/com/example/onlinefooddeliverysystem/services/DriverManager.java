package com.example.onlinefooddeliverysystem.services;
import com.example.onlinefooddeliverysystem.models.Driver;
import com.example.onlinefooddeliverysystem.util.fileHandler;

import java.util.ArrayList;

public class DriverManager {
    private static ArrayList<Driver> drivers = null;
    private static final String fileName = "drivers.txt";
    private static int driverID = 0;

    public static void readDrivers() {
        if (drivers != null) return;

        drivers = new ArrayList<>();
        String[] dataArr = fileHandler.readFromFile(fileName);
        int lastID = 0;

        for (String data : dataArr) {
            String[] parts = data.split(",");
            lastID = Integer.parseInt(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);

            drivers.add(new Driver(lastID, name, age));
        }

        driverID = lastID;
    }

    public static void add(String name, int age) {
        int id = getNextID();
        Driver driver = new Driver(id, name, age);
        drivers.add(driver);
        fileHandler.writeToFile(fileName, true, driver.getDetails());
    }

    public static void update(int id, String name, int age) {
        for (Driver d : drivers) {
            if (d.getID() == id) {
                d.setName(name);
                d.setAge(age);
                break;
            }
        }
        saveDriversToFile();
    }

    public static void remove(int id) {
        Driver toRemove = null;
        for (Driver d : drivers) {
            if (d.getID() == id) {
                toRemove = d;
                break;
            }
        }
        if (toRemove != null) {
            drivers.remove(toRemove);
            saveDriversToFile();
        }
    }

    public static ArrayList<Driver> view() {
        return drivers;
    }

    public static void saveDriversToFile() {
        String data = "";
        for (Driver d : drivers) {
            data += d.getDetails();
        }
        fileHandler.writeToFile(fileName, false, data);
    }

    public static int getNextID() {
        return ++driverID;
    }

    public static ArrayList<Driver> getDrivers() {
        return drivers;
    }
}
