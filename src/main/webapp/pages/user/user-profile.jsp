<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.User" %>
<%
    User user = (User)session.getAttribute("loggedUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><%= user.getName() %> - Profile</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
    <script src="https://cdn.tailwindcss.com"></script>
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
    <div class="bg-gray-800 rounded-lg shadow-lg overflow-hidden p-8">
        <h1 class="text-3xl font-bold mb-6 text-center">User Profile</h1>

        <div class="grid grid-cols-1 sm:grid-cols-2 gap-6 text-gray-300">
            <div>
                <p class="font-semibold text-white">User ID:</p>
                <p><%= user.getID() %></p>
            </div>
            <div>
                <p class="font-semibold text-white">Name:</p>
                <p><%= user.getName() %></p>
            </div>
            <div>
                <p class="font-semibold text-white">Email:</p>
                <p><%= user.getMail() %></p>
            </div>
            <div>
                <p class="font-semibold text-white">Phone:</p>
                <p><%= user.getAge() %></p>
            </div>

        </div>

        <div class="mt-8 text-center">
            <a href="edit_user.jsp" class="bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded-md text-white">
                Edit Profile
            </a>
        </div>
    </div>
</div>
</body>
</html>
