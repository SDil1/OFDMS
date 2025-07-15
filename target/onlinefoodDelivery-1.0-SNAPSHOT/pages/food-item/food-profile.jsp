<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Food" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.FoodManager" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.ReviewManager" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Review" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.User" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.UserManager" %>
<%
    FoodManager.readFoodItems();
    int foodID = Integer.parseInt(request.getParameter("foodID"));
    Food food = FoodManager.find(foodID);
    ReviewManager.readReviews(); // Make sure reviews are loaded
    int userId = (session.getAttribute("userId") != null) ? (Integer) session.getAttribute("userId") : -1;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String comment = request.getParameter("reviewComment");
        if (userId != -1 && comment != null && !comment.trim().isEmpty()) {
            ReviewManager.add(userId, foodID, comment.trim());
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><%= food.getName() %> - Food Details</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
</head>
<body class="bg-gray-900 text-white min-h-screen">

<header class="header">
    <div class="header-container">
        <h1 class="site-title">Food Express</h1>
        <nav class="nav-links">
            <div class="flex items-center space-x-4">
                <a href="<%=request.getContextPath()%>/pages/food-item/user-view.jsp" class="text-blue-600 hover:underline">Buy Foods</a>
                <a href="<%=request.getContextPath()%>/pages/user/user-profile.jsp" class="text-blue-600 hover:underline">User Profile</a>
                <a href="<%=request.getContextPath()%>/pages/order/pending-order-user.jsp" class="text-blue-600 hover:underline">Pending Orders</a>
                <a href="<%=request.getContextPath()%>/pages/order/confirmed-order-user.jsp" class="text-blue-600 hover:underline">Confirm Orders</a>

                <form action="<%=request.getContextPath()%>/user-logout" method="post" onsubmit="return confirm('Are you sure you want to logout?')" class="inline">
                    <input type="submit" value="Logout" class="px-4 py-2 bg-red-500 text-white rounded-md hover:bg-red-600 cursor-pointer">
                </form>
            </div>
        </nav>
    </div>
</header>

<div class="max-w-4xl mx-auto py-10 px-4">
    <div class="bg-gray-800 rounded-lg shadow-lg overflow-hidden flex flex-col md:flex-row">
        <div class="md:w-1/2">
            <div class="h-full w-full">
                <img src="<%= food.getImagePath() %>"
                     alt="<%= food.getName() %>"
                     class="object-cover w-full h-full rounded-l-lg"/>
            </div>
        </div>
        <div class="md:w-1/2 p-6">
            <h1 class="text-3xl font-bold mb-2"><%= food.getName() %></h1>
            <p class="text-gray-300 mb-4"><%= food.getDescription() %></p>
            <p class="text-lg text-green-400 font-semibold mb-4">Price: Rs. <%= food.getPrice() %></p>

            <form action="<%=request.getContextPath()%>/pages/order/order-food.jsp" method="GET">
                <input type="hidden" name="foodID" value="<%= food.getID() %>"/>
                <button type="submit" class="bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded-md text-white">
                    Order Now
                </button>
            </form>
        </div>
    </div>

    <!-- Review Section -->
    <div class="mt-8 bg-gray-800 p-6 rounded-lg shadow-md">
        <h2 class="text-2xl font-bold mb-4">Leave a Review</h2>
        <form method="POST" action="<%=request.getContextPath()%>/add-review">
            <input type="hidden" name="food-id" value="<%=foodID%>">
            <textarea name="reviewComment" rows="4" class="w-full p-3 rounded-md text-black" placeholder="Write your review..."></textarea>
            <button type="submit" class="mt-2 bg-green-600 hover:bg-green-700 px-4 py-2 rounded-md text-white">
                Submit Review
            </button>
        </form>
    </div>

    <!-- Display Reviews Section -->
    <div class="mt-8 bg-gray-800 p-6 rounded-lg shadow-md">
        <h2 class="text-2xl font-bold mb-4">Reviews</h2>

        <div class="space-y-4">
            <% for (Review review : ReviewManager.getReviews()) {
                if (review.getFood_id() == foodID) {
                    User reviewer = UserManager.findUser(review.getUser_id());
            %>
            <div class="bg-gray-700 p-4 rounded-md shadow">
                <p class="text-white italic mb-2">"<%= review.getComment() %>"</p>
                <p class="text-sm text-gray-300">— <%= reviewer != null ? reviewer.getName() : "Unknown User" %></p>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>

</div>
</body>
</html>
