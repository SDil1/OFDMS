package com.example.onlinefooddeliverysystem.controllers.order;

import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.OrderManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterOrderServlet", value = "/register-order")
public class RegisterOrder extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        OrderManager.readOrders();


        String orderName = request.getParameter("orderName");

        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("loggedUser");
        int userId = loggedUser.getID();

        int foodId = Integer.parseInt(request.getParameter("foodID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String status = "pending";


        OrderManager.add(orderName, userId, foodId, quantity, totalPrice, status);


        response.sendRedirect("pages/order/pending-order-user.jsp");
    }
}
