package com.example.onlinefooddeliverysystem.dsa;
import com.example.onlinefooddeliverysystem.models.Order;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Order> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    // Add order to the end of the queue (enqueue)
    public void insert(Order order) {
        queue.add(order);
    }

    // Remove order from the front of the queue (dequeue)
    public Order remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue.remove(0); // remove first item (FIFO)
    }

    // Peek at the front of the queue without removing
    public Order peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue.get(0);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    // Print all orders

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (Order order : queue) {
            System.out.println(order);
        }
    }
}