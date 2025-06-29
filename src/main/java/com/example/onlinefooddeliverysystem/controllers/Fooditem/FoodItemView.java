package com.example.onlinefooddeliverysystem.controllers.Fooditem;

import com.example.onlinefooddeliverysystem.dsa.Quicksort;
import com.example.onlinefooddeliverysystem.models.Food;
import com.example.onlinefooddeliverysystem.services.FoodManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FoodItemView", value = "/food-view")
public class FoodItemView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setAttribute("foods", FoodManager.getFoodItems());

        response.sendRedirect("pages/food-item/user-view.jsp");

    }
}
