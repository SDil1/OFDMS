package com.example.onlinefooddeliverysystem.controllers.user;



import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/update-user")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Load users if not already loaded
        UserManager.readUsers();

        // Get parameters from the form
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");

        // Find the user and update their details
        User user = UserManager.findUser(id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setPassword(password);
            user.setMail(mail);
            UserManager.saveUsersToFile();
            response.sendRedirect("Pages/User/profile.jsp?update=success");
        } else {
            response.sendRedirect("Pages/User/profile.jsp?update=fail");
        }
    }
}
