<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Food Item</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-900 text-white min-h-screen flex flex-col">

<!-- Navbar -->
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

<!-- Centered Form Section -->
<div class="flex-grow flex items-center justify-center">
    <div class="max-w-lg w-full bg-gray-800 p-8 rounded-lg shadow-md">
        <h2 class="text-3xl font-bold text-center mb-6">🍔 Add New Food Item</h2>
        <form action="<%=request.getContextPath()%>/addFood" method="post" class="space-y-5">
            <div>
                <label for="name" class="block text-sm font-semibold mb-1">Food Name</label>
                <input type="text" id="name" name="name" required class="w-full bg-gray-700 border border-gray-600 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-yellow-400 text-white">
            </div>

            <div>
                <label for="description" class="block text-sm font-semibold mb-1">Description</label>
                <textarea id="description" name="description" rows="3" required class="w-full bg-gray-700 border border-gray-600 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-yellow-400 text-white"></textarea>
            </div>

            <div>
                <label for="price" class="block text-sm font-semibold mb-1">Price (Rs.)</label>
                <input type="number" id="price" name="price" step="0.01" required class="w-full bg-gray-700 border border-gray-600 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-yellow-400 text-white">
            </div>

            <div>
                <label for="category" class="block text-sm font-semibold mb-1">Category</label>
                <select id="category" name="category" class="w-full bg-gray-700 border border-gray-600 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-yellow-400 text-white">
                    <option value="Main">Main</option>
                    <option value="Side">Side</option>
                    <option value="Drink">Drink</option>
                    <option value="Dessert">Dessert</option>
                </select>
            </div>

            <div>
                <label for="imagePath" class="block text-sm font-semibold mb-1">Image Path or URL</label>
                <input type="text" id="imagePath" name="imagePath" placeholder="https://example.com/image.jpg" class="w-full bg-gray-700 border border-gray-600 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-yellow-400 text-white">
            </div>

            <div class="pt-4">
                <button type="submit" class="w-full bg-yellow-400 hover:bg-yellow-500 text-black font-bold py-2 px-4 rounded-xl transition duration-300">
                    ➕ Add Food Item
                </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
