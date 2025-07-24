package com.example.onlinefooddeliverysystem.controllers.admin;

import com.example.onlinefooddeliverysystem.models.Admin;
import com.example.onlinefooddeliverysystem.services.AdminManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", value = "/admin-login")
public class LoginAdmin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AdminManager.getAdmins();  // Make sure admins are loaded

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin loggedAdmin = null;

        for (Admin admin : AdminManager.getAdmins()) {
            if (admin.getMail().equalsIgnoreCase(email) && admin.getPassword().equals(password)) {
                loggedAdmin = admin;
                break;
            }
        }

        if (loggedAdmin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedAdmin", loggedAdmin);
            response.sendRedirect("pages/admin/admin-view.jsp");
        } else {
            response.sendRedirect("pages/admin/login.jsp");
        }
    }
}