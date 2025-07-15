<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Admin" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.AdminManager" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Admin Management</title>
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

<div class="max-w-6xl mx-auto">
    <h1 class="text-3xl font-bold mb-6 text-center">Admin Management</h1>

        <%
        ArrayList<Admin> admins = AdminManager.getAdmins();
    %>

    <!-- Admins Table -->
    <div class="overflow-x-auto">
        <table class="min-w-full table-auto bg-gray-800 rounded-lg overflow-hidden shadow">
            <thead class="bg-gray-700 text-white">
            <tr>
                <th class="p-4 text-left">ID</th>
                <th class="p-4 text-left">Name</th>
                <th class="p-4 text-left">Age</th>
                <th class="p-4 text-left">Email</th>
                <th class="p-4 text-left">Actions</th>
            </tr>
            </thead>
            <tbody class="text-gray-300">
            <% for (Admin admin: admins) { %>

            <!-- Sample admin row — repeat with backend data -->
            <tr class="border-b border-gray-700">

                <form action="<%=request.getContextPath()%>/update-admin" method="POST">
                    <td class="p-2">
                        <input type="hidden" name="id" value="<%=admin.getID()%>" />
                        <%=admin.getID()%>
                    </td>
                    <td class="p-2"><input name="name" value="<%=admin.getName()%>" class="bg-gray-700 p-1 rounded text-white w-full" <%=(admin.getID()==0)? "readonly":""%>/></td>
                    <td class="p-2"><input name="age" type="number" value="<%=admin.getAge()%>" class="bg-gray-700 p-1 rounded text-white w-full" <%=(admin.getID()==0)? "readonly":""%>/></td>
                    <td class="p-2"><input name="mail" value="<%=admin.getMail()%>" class="bg-gray-700 p-1 rounded text-white w-full" <%=(admin.getID()==0)? "readonly":""%>/></td>
                    <td class="p-2 flex gap-2">
                        <input name="password" type="hidden" value="<%=admin.getPassword()%>" />
                        <button type="submit" class="bg-blue-600 hover:bg-blue-700 px-3 py-1 rounded" <%=(admin.getID()==0)? "disabled":""%>>Update</button>
                </form>

                <form action="<%=request.getContextPath()%>/delete-admin" method="POST" onsubmit="return confirm('Are you sure you want to remove this admin ?');">
                    <input type="hidden" name="id" value="<%=admin.getID()%>" />
                    <button type="submit" class="bg-red-600 hover:bg-red-700 px-3 py-1 rounded" <%=(admin.getID()==0)? "disabled":""%>>Delete</button>
                </form>

                </td>

            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
