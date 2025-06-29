package com.example.onlinefooddeliverysystem.controllers.driver;


import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.DriverManager;
import com.example.onlinefooddeliverysystem.services.UserManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateDriverServlet", value = "/update-driver")
public class DriverUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Load driver if not already loaded
        DriverManager.readDrivers();

        // Get parameters from the form
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        DriverManager.update(id, name, age);

        response.sendRedirect("pages/driver/admin-view.jsp");
    }
}
