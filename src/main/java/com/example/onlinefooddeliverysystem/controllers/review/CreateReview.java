package com.example.onlinefooddeliverysystem.controllers.review;

import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.ReviewManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CreateReview", value = "/add-review")
public class CreateReview extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ReviewManager.readReviews();

        int food_id=Integer.parseInt(request.getParameter("food-id"));
        String comment = request.getParameter("reviewComment");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");

        ReviewManager.add(user.getID(), food_id, comment);

        response.sendRedirect("pages/food-item/food-profile.jsp?foodID="+food_id);
    }
}