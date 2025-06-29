package com.example.onlinefooddeliverysystem.controllers.driver;


import com.example.onlinefooddeliverysystem.services.DriverManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteDriverServlet", value = "/delete-driver")
public class DriverDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Load driver if not already loaded
        DriverManager.readDrivers();

        // Get parameters from the form
        int id = Integer.parseInt(request.getParameter("id"));

        DriverManager.remove(id);

        response.sendRedirect("pages/driver/admin-view.jsp");
    }
}
