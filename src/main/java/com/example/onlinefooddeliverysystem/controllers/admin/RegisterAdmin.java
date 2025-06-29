package com.example.onlinefooddeliverysystem.controllers.admin;
import java.io.*;

import com.example.onlinefooddeliverysystem.services.AdminManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AdminRegisterServlet", value = "/register-admin")
public class RegisterAdmin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int ID = AdminManager.getNextID();

        AdminManager.addAdmin(ID,name,age,email,password);

        response.sendRedirect("pages/admin/admin-view.jsp");
    }
}