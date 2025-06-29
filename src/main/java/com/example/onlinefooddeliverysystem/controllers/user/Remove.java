package com.example.onlinefooddeliverysystem.controllers.user;


import com.example.onlinefooddeliverysystem.services.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/delete-user")
public class Remove extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get user ID from the request
        int userId = Integer.parseInt(request.getParameter("id"));

        // Load existing users if not loaded
        UserManager.readUsers();

        // Delete the user by ID
        UserManager.deleteUser(userId);

        // Redirect to a confirmation or user list page
        response.sendRedirect("pages/user/admin-view.jsp");
    }
}
