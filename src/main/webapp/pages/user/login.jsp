<!DOCTYPE html>
<html lang="en">
<head>
    <!--set as character encoding and vieport responsive design-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width",intial-scale="1.0">
    <title>Login page</title>

    <!-- Tailwind CSS for styling the page -->
    <script src="https://cdn.tailwindcss.com"></script>
    <link href=https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">


</head>
<body class="bg-gray-900 flex items-center justify-center min-h-screen">

<div class="bg-gray-800 p-8 rounded-xl shadow-lg w-96">

        <h2 class="text-white text-2xl font-bold text-center">Login</h2>


        <!--login form section-->
    <form action="<%=request.getContextPath()%>/user-login" method="POST">
        <div class="mb-4">
            <label for="email" class="block text-white text-lg font-semibold">Email</label>
            <input type="email" id="email" name="email" class="w-full p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="mb-6">
            <label for="password" class="block text-white text-lg font-semibold">Password</label>
            <input type="password" id="password" name="password" class="w-full p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="flex justify-between items-center mb-6">
            <button type="submit" class="w-full py-3 px-4 bg-blue-500 text-white rounded-md hover:bg-blue-600">Login</button>
        </div>

        <div class="text-center">
            <p class="text-sm text-white">Don't have an account? <a href="<%=request.getContextPath()%>/pages/user/signup.jsp" class="text-blue-500">Sign up here</a></p>
        </div>
    </form>
</div>
</body>
</html>