package com.example.onlinefooddeliverysystem.services;

import com.example.onlinefooddeliverysystem.models.Order;
import com.example.onlinefooddeliverysystem.util.dbManager;
import com.example.onlinefooddeliverysystem.dsa.Queue;
import java.sql.*;

import java.util.ArrayList;

public class OrderManager {
    private static ArrayList<Order> orders = null;
    private static Queue orderQueue = null;
    private static int orderID = 0;

    public static void readOrders() {
        if (orders != null) return;

        orders = new ArrayList<>();
        orderQueue = new Queue();

        try (Connection conn = dbManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM orders")) {

            int lastID = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String orderName = rs.getString("order_name");
                int userId = rs.getInt("user_id");
                int foodId = rs.getInt("food_id");
                int quantity = rs.getInt("quantity");
                double totalPrice = rs.getDouble("total_price");
                String status = rs.getString("status");

                Order order = new Order(id, orderName, userId, foodId, quantity, totalPrice, status);
                orders.add(order);
                if (status.equalsIgnoreCase("pending")) {
                    orderQueue.insert(order);
                }
                lastID = Math.max(lastID, id);
            }

            orderID = lastID;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(String orderName, int userId, int foodId, int quantity, double totalPrice, String status) {
        int id = getNextID();
        Order order = new Order(id, orderName, userId, foodId, quantity, totalPrice, status);

        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO orders (id, order_name, user_id, food_id, quantity, total_price, status) VALUES (?, ?, ?, ?, ?, ?, ?)");) {

            ps.setInt(1, id);
            ps.setString(2, orderName);
            ps.setInt(3, userId);
            ps.setInt(4, foodId);
            ps.setInt(5, quantity);
            ps.setDouble(6, totalPrice);
            ps.setString(7, status);

            ps.executeUpdate();
            orders.add(order);
            if (status.equalsIgnoreCase("pending")) {
                orderQueue.insert(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cancel(int orderId) {
        try (Connection conn = dbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM orders WHERE id = ?")) {

            ps.setInt(1, orderId);
            ps.executeUpdate();

            // Remove from list and re-generate queue
            Order temp = null;
            for (Order order : orders) {
                if (order.getId() == orderId) {
                    temp = order;
                    break;
                }
            }

            if (temp != null) {
                orders.remove(temp);

                orderQueue = new Queue();
                for (Order o : orders) {
                    if (o.getStatus().equalsIgnoreCase("pending")) {
                        orderQueue.insert(o);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void complete() {
        if (!orderQueue.isEmpty()) {
            Order next = orderQueue.remove();
            next.setStatus("confirmed");

            try (Connection conn = dbManager.getConnection();
                 PreparedStatement ps = conn.prepareStatement("UPDATE orders SET status = ? WHERE id = ?")) {

                ps.setString(1, "confirmed");
                ps.setInt(2, next.getId());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getNextID() {
        return ++orderID;
    }

    public static ArrayList<Order> getOrders() {
        readOrders();
        return orders;
    }

    public static Queue getOrdersQueue() {
        readOrders();
        return orderQueue;
    }
}
