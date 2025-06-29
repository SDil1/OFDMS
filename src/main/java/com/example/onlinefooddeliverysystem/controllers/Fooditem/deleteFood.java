package com.example.onlinefooddeliverysystem.controllers.Fooditem;
import java.io.*;


import com.example.onlinefooddeliverysystem.services.FoodManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DeleteFoodServlet", value = "/deleteFood")
public class deleteFood extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int id = Integer.parseInt(request.getParameter("id"));


        FoodManager.remove(id);

        response.sendRedirect("pages/food-item/admin-view.jsp");
    }
}