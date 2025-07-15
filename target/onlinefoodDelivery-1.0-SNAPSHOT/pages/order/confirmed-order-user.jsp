<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.OrderManager" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Order" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.User" %>

<%
    OrderManager.readOrders();
    User user = (User) session.getAttribute("loggedUser");

    List<Order> orders = OrderManager.getOrders();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Pending Orders</title>
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
    <h1 class="text-3xl font-bold mb-6 text-center">Confirmed Orders</h1>

    <div class="overflow-x-auto">
        <table class="min-w-full table-auto bg-gray-800 rounded-lg overflow-hidden shadow-md">
            <thead class="bg-gray-700 text-white">
            <tr>
                <th class="p-4 text-left">Order ID</th>
                <th class="p-4 text-left">Order Name</th>
                <th class="p-4 text-left">Food ID</th>
                <th class="p-4 text-left">Quantity</th>
                <th class="p-4 text-left">Total Price (Rs.)</th>
                <th class="p-4 text-left">Status</th>
            </tr>
            </thead>
            <tbody class="text-gray-300">
            <%
                boolean found = false;
                for (Order order : orders) {
                    if (order.getUserId() == user.getID() && order.getStatus().equalsIgnoreCase("confirmed")) {
                        found = true;
            %>
            <tr class="border-b border-gray-700">
                <td class="p-4"><%= order.getId() %></td>
                <td class="p-4"><%= order.getOrderName() %></td>
                <td class="p-4"><%= order.getFoodId() %></td>
                <td class="p-4"><%= order.getQuantity() %></td>
                <td class="p-4"><%= order.getTotalPrice() %></td>
                <td class="p-4 text-green-400 font-semibold capitalize"><%= order.getStatus() %></td>
            </tr>
            <%
                    }
                }
                if (!found) {
            %>
            <tr>
                <td colspan="6" class="p-4 text-center text-gray-400">No pending orders found.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
