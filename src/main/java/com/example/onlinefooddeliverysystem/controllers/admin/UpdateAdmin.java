package com.example.onlinefooddeliverysystem.controllers.admin;

import com.example.onlinefooddeliverysystem.services.AdminManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminUpdateServlet", value = "/update-admin")
public class UpdateAdmin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("mail");
        String password = request.getParameter("password");

        AdminManager.updateAdmin(id,name,age,email,password);

        response.sendRedirect("pages/admin/admin-view.jsp");
    }
}