package com.example.onlinefooddeliverysystem.controllers.order;
import java.io.*;


import com.example.onlinefooddeliverysystem.services.FoodManager;
import com.example.onlinefooddeliverysystem.services.OrderManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConfirmOrdersevelt", value = "/pending-form")
public class deleteOrder extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int id = Integer.parseInt(request.getParameter("id"));





        response.sendRedirect("Pages/FoodItem/admin-admin-admin-admin-view.jsp");
    }
}