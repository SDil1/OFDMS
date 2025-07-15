<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-900 text-white">


<nav class="flex justify-between items-center p-6 bg-gray-800">
    <!-- Title -->
    <div class="flex items-center">
        <h1 class="text-3xl font-bold text-white">Food Express</h1>
    </div>

    <!-- Navigation Links -->
    <div class="space-x-4">
        <a href="<%=request.getContextPath()%>/index.jsp"
           class="ml-4 px-4 py-2  text-white rounded-md bg-green-500 hover:bg-green-700">
            Home
        </a>
    </div>
</nav>

<section class="min-h-screen flex items-center justify-center px-4">
    <div class="bg-gray-800 p-8 rounded-2xl shadow-lg w-full max-w-md">
        <h2 class="text-3xl font-bold mb-6 text-center">Admin Login</h2>
        <form action="<%=request.getContextPath()%>/admin-login" method="POST" class="space-y-6">

            <!-- Email -->
            <div>
                <label for="mail" class="block text-lg mb-1">Email</label>
                <input type="email" id="mail" name="mail" required
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Password -->
            <div>
                <label for="password" class="block text-lg mb-1">Password</label>
                <input type="password" id="password" name="password" required
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Login Button -->
            <button type="submit"
                    class="w-full py-3 px-4 bg-blue-600 hover:bg-blue-700 text-white font-semibold rounded-md transition duration-300">
                Login
            </button>

        </form>
    </div>
</section>

</body>
</html>
