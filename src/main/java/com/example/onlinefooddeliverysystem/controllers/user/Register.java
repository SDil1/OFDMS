package com.example.onlinefooddeliverysystem.controllers.user;


import com.example.onlinefooddeliverysystem.services.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterUserServlet", value = "/register-user")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get parameters from form
        String name = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        String password = request.getParameter("password");
        String mail = request.getParameter("email");

        // Load existing users and add a new one
        UserManager.readUsers();
        UserManager.registerUser(name, age, password, mail);

        // Redirect to a confirmation page
        response.sendRedirect("pages/user/login.jsp");
    }
}

