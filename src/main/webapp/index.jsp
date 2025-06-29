<%@ page import="com.example.onlinefooddeliverysystem.models.User" %>
<%@ page import="com.example.onlinefooddeliverysystem.services.*" %>
<!DOCTYPE html>
<html lang="en">
<%
    AdminManager.readAdmins();
    FoodManager.readFoodItems();
    ReviewManager.readReviews();
    DriverManager.readDrivers();
    UserManager.readUsers();
    OrderManager.readOrders();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Food Delivery</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!--slide show script added here-->
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let currentSlide = 0;
            const slides = document.querySelectorAll(".slide");
            const totalSlides = slides.length;

            function showNextSlide() {
                slides[currentSlide].classList.remove("opacity-100");
                slides[currentSlide].classList.add("opacity-0");

                currentSlide = (currentSlide + 1) % totalSlides;

                slides[currentSlide].classList.remove("opacity-0");
                slides[currentSlide].classList.add("opacity-100");
            }

            setInterval(showNextSlide, 3000);
        });

    </script>
</head>
<body class="bg-gray-900 text-white">

<!-- Navbar -->
<nav class="flex justify-between items-center p-6 bg-gray-800">
    <div class="flex items-center">
        <h1 class="text-3xl font-bold text-white">Food Express</h1>
        <img src="assets/images/fast-delivery.png" alt="Fast Delivery" class="w-10 h-10 ml-2">
    </div>


    <div class="flex items-center space-x-2">
        <a href="pages/user/login.jsp" class="px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600">Login</a>
        <a href="pages/user/signup.jsp" class="px-4 py-2 bg-gray-700 text-white rounded-md hover:bg-gray-600">Sign Up</a>
        <a href="pages/admin/login.jsp" class="px-4 py-2 bg-yellow-500 text-black rounded-md hover:bg-yellow-600">Admin Login</a>
    </div>

</nav>
<!--slide show animation-->
<div class="relative w-full h-96 overflow-hidden">
    <div class="slide absolute inset-0 opacity-100 transition-opacity duration-1000 ease-in-out">
        <img src="assets/images/hero01.jpg" class="w-full h-96 object-cover">
    </div>
    <div class="slide absolute inset-0 opacity-0 transition-opacity duration-1000 ease-in-out">
        <img src="assets/images/hero02.jpg" class="w-full h-96 object-cover">
    </div>
    <div class="slide absolute inset-0 opacity-0 transition-opacity duration-1000 ease-in-out">
        <img src="assets/images/hero03.jpg" class="w-full h-96 object-cover">
    </div>
</div>
<!-- Hero Section -->
<section class="text-center py-20">
    <h2 class="text-5xl font-extrabold mb-4">Delicious Food, Delivered Fast</h2>
    <p class="text-gray-400 text-lg mb-6">Order your favorite meals with just a few clicks.</p>
    <a href="pages/user/signup.jsp" class="px-6 py-3 bg-blue-500 text-white text-lg rounded-md hover:bg-blue-600 transition">Get Started</a>
</section>

<!-- Features Section -->
<section class="grid md:grid-cols-3 gap-8 px-10 py-16">
    <div class="bg-gray-800 p-6 rounded-lg text-center shadow-lg">
        <h3 class="text-2xl font-semibold">Fast Delivery</h3>
        <p class="text-gray-400 mt-2">Get your food delivered in minutes, hot and fresh.</p>
    </div>
    <div class="bg-gray-800 p-6 rounded-lg text-center shadow-lg">
        <h3 class="text-2xl font-semibold">Best Restaurants</h3>
        <p class="text-gray-400 mt-2">Choose from top-rated restaurants in your area.</p>
    </div>
    <div class="bg-gray-800 p-6 rounded-lg text-center shadow-lg">
        <h3 class="text-2xl font-semibold">Secure Payments</h3>
        <p class="text-gray-400 mt-2">Your transactions are safe and hassle-free.</p>
    </div>
</section>


</body>
</html>
