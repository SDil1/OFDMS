<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.onlinefooddeliverysystem.models.Driver" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.DriverManager" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Driver Management</title>
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
    <h1 class="text-3xl font-bold mb-6 text-center">Driver Management</h1>

        <%
        ArrayList<Driver> drivers = DriverManager.getDrivers();
        %>

    <!-- Styled Driver Registration Form -->
    <div class="bg-gray-800 p-6 rounded-lg shadow-md mb-10">
        <h2 class="text-2xl font-semibold mb-4">Register New Driver</h2>
        <form action="<%=request.getContextPath()%>/register-driver" method="post" class="grid grid-cols-1 sm:grid-cols-3 gap-4 items-end">
            <div>
                <label for="name" class="block mb-1 text-sm font-medium">Name</label>
                <input type="text" name="name" id="name" required
                       class="w-full p-2 bg-gray-700 border border-gray-600 rounded text-white focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div>
                <label for="age" class="block mb-1 text-sm font-medium">Age</label>
                <input type="number" name="age" id="age" required
                       class="w-full p-2 bg-gray-700 border border-gray-600 rounded text-white focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div>
                <button type="submit"
                        class="w-full bg-green-600 hover:bg-green-700 text-white font-semibold py-2 px-4 rounded transition duration-200">
                    Register
                </button>
            </div>
        </form>
    </div>

    <!-- drivers Table -->
    <div class="overflow-x-auto">
        <table class="min-w-full table-auto bg-gray-800 rounded-lg overflow-hidden shadow">
            <thead class="bg-gray-700 text-white">
            <tr>
                <th class="p-4 text-left">ID</th>
                <th class="p-4 text-left">Name</th>
                <th class="p-4 text-left">Age</th>
                <th class="p-4 text-left" colspan="2">Actions</th>
            </tr>
            </thead>
            <tbody class="text-gray-300">
            <% for (Driver driver: drivers) { %>
                <tr class="border-b border-gray-700">
                    <td>
                        <%=driver.getID()%>
                    </td>

                    <form action="<%=request.getContextPath()%>/update-driver" method="POST">
                        <input type="hidden" name="id" value="<%=driver.getID()%>" />
                        <td class="p-2"><input name="name" value="<%=driver.getName()%>" class="bg-gray-700 p-1 rounded text-white w-full"/></td>
                        <td class="p-2"><input name="age" type="number" value="<%=driver.getAge()%>" class="bg-gray-700 p-1 rounded text-white w-full"/></td>
                        <td class="p-2 flex gap-2">
                            <button type="submit" class="bg-blue-600 hover:bg-blue-700 px-3 py-1 rounded">Update</button>
                        </td>
                    </form>

                    <td>
                        <form action="<%=request.getContextPath()%>/delete-driver" method="POST" onsubmit="return confirm('Are you sure?');">
                            <input type="hidden" name="id" value="<%=driver.getID()%>" />
                            <button type="submit" class="bg-red-600 hover:bg-red-700 px-3 py-1 rounded">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
