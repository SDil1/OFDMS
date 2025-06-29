package com.example.onlinefooddeliverysystem.controllers.user;


import com.example.onlinefooddeliverysystem.models.User;
import com.example.onlinefooddeliverysystem.services.UserManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/user-login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get user email password from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Load existing users if not loaded
        UserManager.readUsers();

        for (User user : UserManager.getUsers()) {
            System.out.println(user.getMail());
            System.out.println(user.getPassword());
            System.out.println("--------------------------------");
        }

        User loggedUser = null;
        for (User user : UserManager.getUsers()) {
            if (user.getMail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                loggedUser = user;
            }
        }

        if (loggedUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect("food-view");
        }
        else{
            response.sendRedirect("pages/user/login.jsp");
        }
    }
}
