<%@ page import="com.example.onlinefooddeliverysystem.models.Food" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.FoodManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    FoodManager.readFoodItems();
    ArrayList<Food> foodItems = FoodManager.getFoodItems();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Food Items</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-900 text-white min-h-screen">

<nav class="flex justify-between items-center p-6 bg-gray-800">
    <!-- Title -->
    <div class="flex items-center">
        <h1 class="text-3xl font-bold text-white">Food Express</h1>
    </div>

    <!-- Navigation Links -->
    <div class="flex items-center space-x-4">
        <a href="<%=request.getContextPath()%>/pages/driver/admin-view.jsp" class="text-white hover:text-blue-400">Driver Management</a>
        <a href="<%=request.getContextPath()%>/pages/user/admin-view.jsp" class="text-white hover:text-blue-400">User Management</a>
        <a href="<%=request.getContextPath()%>/pages/food-item/add-food.jsp" class="text-white hover:text-blue-400">Add Food Item</a>
        <a href="<%=request.getContextPath()%>/pages/food-item/admin-view.jsp" class="text-white hover:text-blue-400">View Food Items</a>
        <a href="<%=request.getContextPath()%>/pages/order/pending-order-admin.jsp" class="text-white hover:text-blue-400">Pending Orders</a>
        <a href="<%=request.getContextPath()%>/pages/order/confirmed-order-admin.jsp" class="text-white hover:text-blue-400">Confirmed Orders</a>
        <a href="<%=request.getContextPath()%>/pages/review/admin-view.jsp" class="text-white hover:text-blue-400">Reviews Management</a>
        <a href="<%=request.getContextPath()%>/pages/admin/admin-view.jsp" class="text-white hover:text-blue-400">Admin Management</a>
        <a href="<%=request.getContextPath()%>/pages/admin/register.jsp"
           class="ml-4 px-4 py-2 bg-green-500 text-white rounded-md hover:bg-green-600">
            Signup
        </a>
        <form action="<%=request.getContextPath()%>/admin-logout" method="POST" class="inline"
              onsubmit="return confirm('Are you sure you want to logout ?');">
            <input type="submit" value="Logout" class="ml-4 px-4 py-2 bg-red-500 text-white rounded-md hover:bg-red-600 cursor-pointer">
        </form>
    </div>
</nav>

<h1 class="text-4xl font-bold mb-8 text-center mt-24">🍕 Manage Food Items</h1>

<!-- Food Items Table -->
<div class="overflow-x-auto">
    <table class="w-full table-auto bg-gray-800 rounded-xl text-center shadow-lg">
        <thead class="bg-yellow-400 text-black text-md uppercase">
        <tr>
            <th class="p-4">ID</th>
            <th class="p-4">Name</th>
            <th class="p-4">Description</th>
            <th class="p-4">Price</th>
            <th class="p-4">Category</th>
            <th class="p-4" colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Food food : foodItems) {
            if (food.getID() == 0) continue;
        %>
        <tr class="border-t border-gray-700 hover:bg-gray-700">
            <form action="<%=request.getContextPath()%>/update-food" method="post">
                <input type="hidden" name="id" value="<%= food.getID() %>" />
                <td class="p-4"><%= food.getID() %></td>
                <td class="p-2">
                    <input type="text" name="name" value="<%= food.getName() %>" class="text-black p-1 rounded w-full" />
                </td>
                <td class="p-2">
                    <input type="text" name="description" value="<%= food.getDescription() %>" class="text-black p-1 rounded w-full" />
                </td>
                <td class="p-2">
                    <input type="number" name="price" value="<%= food.getPrice() %>" step="0.01" class="text-black p-1 rounded w-full" />
                </td>
                <td class="p-2">
                    <input type="text" name="category" value="<%= food.getCategory() %>" class="text-black p-1 rounded w-full" />
                </td>
                <td class="p-2 flex gap-2 justify-center">
                    <input type="submit" value="update" class="bg-blue-500 hover:bg-blue-600 px-3 py-1 rounded text-white text-sm">
                </td>
            </form>
            <td>
                <form action="<%=request.getContextPath()%>/deleteFood" method="post" onsubmit="return confirm('sure you want to delete')">
                    <input type="hidden" name="id" value="<%=food.getID()%>"/>
                    <input type="submit" value="Delete" class="bg-blue-500 hover:bg-red-600 px-3 py-1 rounded text-white text-sm">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
