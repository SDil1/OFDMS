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

@WebServlet(name = "SortFoodByPrice", value = "/sort-by-price")
public class FoodItemViewSorted extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Food> foods = (ArrayList<Food>) FoodManager.getFoodItems().clone(); // get clone of food items

        Food[] foodsArr =  new Food[foods.size()];
        for (int i = 0; i < foods.size(); i++) {
            foodsArr[i] = foods.get(i);
        }

        Quicksort.quickSort(foodsArr, 0, foods.size()-1);

        foods.clear();
        for (int i = 0; i < foodsArr.length; i++) {
            foods.add(foodsArr[i]);
        }

        HttpSession session = request.getSession();
        session.setAttribute("foods", foods);

        response.sendRedirect("pages/food-item/user-view.jsp");
    }
}
