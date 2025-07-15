<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Registration</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-900 text-white">
<nav class="flex justify-between items-center p-6 bg-gray-800">
    <!-- Title -->
    <div class="flex items-center">
        <h1 class="text-3xl font-bold text-white">Food Express</h1>
    </div>


    <a href="<%=request.getContextPath()%>/pages/admin/login.jsp"
       class="ml-4 px-4 py-2 bg-green-500 text-white rounded-md hover:bg-green-600">
        Login
    </a>
</nav>


<section class="min-h-screen flex items-center justify-center px-4">
    <div class="bg-gray-800 p-8 rounded-2xl shadow-lg w-full max-w-md">
        <h2 class="text-3xl font-bold mb-6 text-center">Admin Registration</h2>
        <form action="<%=request.getContextPath()%>/register-admin" method="POST" class="space-y-5">
            <!-- Name -->
            <div>
                <label for="name" class="block text-lg mb-1">Name</label>
                <input type="text" id="name" name="name" required
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Age -->
            <div>
                <label for="age" class="block text-lg mb-1">Age</label>
                <input type="number" id="age" name="age" required min="18"
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Email -->
            <div>
                <label for="email" class="block text-lg mb-1">Email</label>
                <input type="email" id="email" name="email" required
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Password -->
            <div>
                <label for="password" class="block text-lg mb-1">Password</label>
                <input type="password" id="password" name="password" required
                       class="w-full p-3 rounded-md bg-gray-700 border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" />
            </div>

            <!-- Submit Button -->
            <button type="submit"
                    class="w-full py-3 px-4 bg-blue-600 hover:bg-blue-700 text-white font-semibold rounded-md transition duration-300">
                Register
            </button>

        </form>
    </div>
</section>

</body>
</html>
