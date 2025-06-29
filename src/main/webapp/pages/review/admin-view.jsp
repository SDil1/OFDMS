<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.onlinefooddeliverysystem.models.Review" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.ReviewManager" %>
<%
    ArrayList<Review> reviews = ReviewManager.getReviews();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Reviews</title>
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

<div class="max-w-6xl mx-auto bg-gray-800 rounded-2xl shadow-2xl p-8 mt-24">
    <h1 class="text-3xl font-bold mb-8 text-center text-white tracking-wide">Manage Reviews</h1>
    <div class="overflow-x-auto rounded-xl border border-gray-700">
        <table class="min-w-full text-sm text-gray-300">
            <thead class="bg-gray-700 text-xs uppercase tracking-wider text-gray-300">
            <tr>
                <th class="px-6 py-3 text-left">ID</th>
                <th class="px-6 py-3 text-left">User ID</th>
                <th class="px-6 py-3 text-left">Food ID</th>
                <th class="px-6 py-3 text-left">Comment</th>
                <th class="px-6 py-3 text-center">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-gray-800 divide-y divide-gray-700">
            <% for (Review review : reviews) { %>
            <form method="post" action="<%=request.getContextPath()%>/delete-review">
                <tr class="hover:bg-gray-700 transition duration-150">
                    <td class="px-6 py-4"><%= review.getId() %></td>
                    <td class="px-6 py-4"><%= review.getUser_id() %></td>
                    <td class="px-6 py-4"><%= review.getFood_id() %></td>
                    <td class="px-6 py-4">
                        <input type="text" name="newComment" value="<%= review.getComment() %>"
                               class="w-full px-3 py-1 bg-gray-900 text-white border border-gray-600 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"/>
                    </td>
                    <td class="px-6 py-4 text-center">
                        <input type="hidden" name="reviewId" value="<%= review.getId() %>"/>
                        <button type="submit" name="action" value="edit"
                                class="bg-blue-600 hover:bg-blue-700 text-white text-xs font-semibold px-4 py-2 rounded-xl shadow mr-2">
                            Edit
                        </button>
                        <button type="submit" name="action" value="delete"
                                class="bg-red-600 hover:bg-red-700 text-white text-xs font-semibold px-4 py-2 rounded-xl shadow"
                                onclick="return confirm('Are you sure you want to delete this review?');">
                            Delete
                        </button>
                    </td>
                </tr>
            </form>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
