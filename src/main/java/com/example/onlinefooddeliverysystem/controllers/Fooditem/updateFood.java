package com.example.onlinefooddeliverysystem.controllers.Fooditem;

import com.example.onlinefooddeliverysystem.services.FoodManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "UpdateFoodServlet", value = "/update-food")
public class updateFood extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String category = request.getParameter("category");
            String imagePath = request.getParameter("imagePath");

            FoodManager.update(id, description, name, price, category,imagePath);

            response.sendRedirect("pages/food-item/admin-view.jsp");

    }
}
