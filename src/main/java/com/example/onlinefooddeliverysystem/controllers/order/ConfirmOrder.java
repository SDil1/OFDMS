package com.example.onlinefooddeliverysystem.controllers.order;

import com.example.onlinefooddeliverysystem.models.Order;
import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.OrderManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ConfirmOrderServlet", value = "/confirm-order")
public class ConfirmOrder extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        OrderManager.readOrders();


        OrderManager.complete();

        response.sendRedirect("pages/order/pending-order-admin.jsp");
    }
}
