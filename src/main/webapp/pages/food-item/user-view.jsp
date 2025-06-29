<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Food" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.FoodManager" %>
<%
    FoodManager.readFoodItems();
    List<Food> foodList = FoodManager.getFoodItems();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Food Menu</title>
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

<div class="max-w-6xl mx-auto py-10 px-4">
    <h1 class="text-3xl font-bold mb-6 text-center">Available Food Items</h1>

    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        <%
            for (Food food : foodList) {
        %>
        <div class="bg-gray-800 rounded-lg overflow-hidden shadow-md hover:shadow-lg transition duration-300">

           <img src="<%= food.getImagePath() %>" alt="<%= food.getName() %>" class="w-full h-48 object-cover">-
            <div class="p-4">

                <h2 class="text-xl font-semibold mb-2"><%= food.getName() %></h2>
                <p class="text-gray-400 mb-2">Price: Rs. <%= food.getPrice() %></p>
                <form action="<%=request.getContextPath()%>/pages/order/order-food.jsp" method="GET">
                    <input type="hidden" name="foodID" value="<%= food.getID() %>"/>
                    <button type="submit" class="mt-2 bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-md">
                        Order
                    </button>
                </form>

                <form action="<%=request.getContextPath()%>/pages/food-item/food-profile.jsp" method="get">
                    <input type="hidden" value="<%=food.getID()%>" name="foodID">
                    <input type="submit" value="More Details" class="mt-2 bg-green-600 hover:bg-green-700 text-white px-4 py-2 rounded-md">
                </form>

            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
