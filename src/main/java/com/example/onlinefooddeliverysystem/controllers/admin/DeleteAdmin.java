package com.example.onlinefooddeliverysystem.controllers.admin;

import com.example.onlinefooddeliverysystem.services.AdminManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminDeleteServlet", value = "/delete-admin")
public class DeleteAdmin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int adminID = Integer.parseInt(request.getParameter("id"));

        AdminManager.removeAdmin(adminID);

        response.sendRedirect("pages/admin/admin-view.jsp");
    }
}