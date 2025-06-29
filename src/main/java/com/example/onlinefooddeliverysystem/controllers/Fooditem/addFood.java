package com.example.onlinefooddeliverysystem.controllers.Fooditem;
import java.io.*;

import com.example.onlinefooddeliverysystem.services.FoodManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FoodITEMServlet", value = "/addFood")
public class addFood extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FoodManager.readFoodItems();

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price  =Double.parseDouble (request.getParameter("price"));
        String category = request.getParameter("category");
        String imagePath = request.getParameter("imagePath");


        FoodManager.add(FoodManager.getNextID(), name,description,price,category,imagePath);

        response.sendRedirect("pages/food-item/admin-view.jsp");
    }
}