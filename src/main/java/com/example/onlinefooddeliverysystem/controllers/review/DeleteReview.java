package com.example.onlinefooddeliverysystem.controllers.review;
import java.io.*;

import com.example.onlinefooddeliverysystem.services.ReviewManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DeleteReview", value = "/delete-review")
public class DeleteReview extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int id=Integer.parseInt(request.getParameter("reviewId"));


        ReviewManager.delete(id);

        response.sendRedirect("pages/review/admin-view.jsp");
    }
}