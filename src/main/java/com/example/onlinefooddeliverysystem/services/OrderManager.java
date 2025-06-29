package com.example.onlinefooddeliverysystem.services;

import com.example.onlinefooddeliverysystem.models.Order;
import com.example.onlinefooddeliverysystem.util.fileHandler;
import com.example.onlinefooddeliverysystem.dsa.Queue;

import java.util.ArrayList;

public class OrderManager {
    private static ArrayList<Order> orders = null;
    private static Queue orderQueue = null;
    private static final String fileName = "orders.txt";
    private static int orderID = 0;

    public static void readOrders() {
        if (orders != null)
            return;

        orders = new ArrayList<>();
        orderQueue =  new Queue();

        String[] orderDataArr = fileHandler.readFromFile(fileName);
        int lastID = 0;

        for (String orderData : orderDataArr) {
            String[] data = orderData.split(",");
            lastID = Integer.parseInt(data[0]);
            String orderName = data[1];
            int userId = Integer.parseInt(data[2]);
            int foodId = Integer.parseInt(data[3]);
            int quantity = Integer.parseInt(data[4]);
            double totalPrice = Double.parseDouble(data[5]);
            String status = data[6];

            Order  order = new Order(lastID, orderName, userId, foodId, quantity, totalPrice, status);
            orders.add(order);
            if (order.getStatus().equalsIgnoreCase("pending")) orderQueue.insert(order);
        }

        orderID = lastID;
    }

    public static void add(String orderName, int userId, int foodId, int quantity, double totalPrice, String status) {
        int id = getNextID();
        Order order = new Order(id, orderName, userId, foodId, quantity, totalPrice, status);
        orders.add(order);
        orderQueue.insert(order);
        fileHandler.writeToFile(fileName, true, order.getDetails());
    }

    public static void cancel(int orderId) {
        Order temp = null;
        for (Order order : orders) {
            if (order.getId() == orderId) {
                temp = order;
                break;
            }
        }
        if (temp != null) {
            orders.remove(temp);

            // Recreate order queue
            orderQueue = new Queue();
            for (Order order : orders) {
                orderQueue.insert(order);
            }

            saveOrdersToFile();
        }
    }

    public static void complete() {
        if (!orders.isEmpty()) {
            orderQueue.remove().setStatus("confirmed");
            saveOrdersToFile();
        }
    }

    public static void saveOrdersToFile() {
        String data = "";
        for (Order order : orders) {
            data += order.getDetails() ;
        }
        fileHandler.writeToFile(fileName, false, data);
    }

    public static int getNextID() {
        return ++orderID;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static Queue getOrdersQueue() {
        return orderQueue;
    }
}
