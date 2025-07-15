<%@ page import="com.example.onlinefooddeliverysystem.models.Food" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.FoodManager" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.OrderManager" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Place Order</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
</head>
<body class="bg-gray-900 text-white min-h-screen flex flex-col">

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

<%
    FoodManager.readFoodItems();
    OrderManager.readOrders();
    int foodID = Integer.parseInt(request.getParameter("foodID"));
    Food foodItem = FoodManager.find(foodID);
%>

<!-- Centered form section -->
<div class="flex-grow flex items-center justify-center w-full px-4">
    <div class="bg-gray-800 rounded-lg shadow-lg p-8 w-full max-w-md">
        <h2 class="text-2xl font-bold mb-6 text-center">Place Your Order</h2>

        <script>
            function calculateTotal(price){
                const quantity = document.getElementById('quantity').value;
                let total = quantity * price;
                document.getElementById('total-price').value = total;
            }
        </script>

        <form action="<%=request.getContextPath()%>/register-order" method="post">
            <input type="hidden" name="foodID" value="<%=foodItem.getID()%>">

            <div class="mb-4">
                <label class="block mb-1 text-gray-300">Order Name</label>
                <input type="text" name="orderName" class="w-full bg-gray-700 border border-gray-600 text-white px-4 py-2 rounded">
            </div>

            <div class="mb-4">
                <label class="block mb-1 text-gray-300">Food Item</label>
                <input type="text" value="Burger Combo" readonly
                       class="w-full bg-gray-700 border border-gray-600 text-white px-4 py-2 rounded">
            </div>

            <div class="mb-4">
                <label class="block mb-1 text-gray-300">Quantity</label>
                <select class="w-full bg-gray-700 border border-gray-600 text-white px-4 py-2 rounded" name="quantity" onchange="calculateTotal('<%=foodItem.getPrice()%>')" id="quantity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>

            <div class="mb-6">
                <label class="block mb-1 text-gray-300">Price (Rs.)</label>
                <input type="text" value="<%=foodItem.getPrice()%>" id="total-price" name="totalPrice" class="w-full bg-gray-700 border border-gray-600 text-white px-4 py-2 rounded" readonly>
            </div>

            <button type="submit"
                    class="w-full bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-md font-semibold">
                Order Now
            </button>
        </form>
    </div>
</div>

</body>
</html>
