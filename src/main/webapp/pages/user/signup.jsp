<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script>
        function validateForm() {
            // Get form elements
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var phone = document.getElementById("phone").value;

            // Email validation
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!email.match(emailPattern)) {
                alert("Please enter a valid email address.");
                return false; // Prevent form submission
            }

            // Password match validation
            if (password !== confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }

            // Phone number validation (optional) with country code
            var phonePattern = /^\+?[0-9]{1,4}[-.\s]?[0-9]{7,14}$/; // Country code and number format
            if (phone && !phone.match(phonePattern)) {
                alert("Please enter a valid phone number with country code.");
                return false;
            }

            // If all validations pass, allow the form to submit
            return true;
        }
    </script>


</head>
<body class="bg-gray-900 flex justify-center items-center min-h-screen">
<div class="bg-gray-800 text-white p-8 rounded-lg shadow-md w-full max-w-md">
    <h2 class="text-3xl font-semibold mb-6 text-center">Create an Account</h2>

    <form action="<%=request.getContextPath()%>/register-user" method="POST">
        <div class="mb-4">
            <label for="username" class="block text-lg font-medium mb-2">Username</label>
            <input type="text" id="username" name="username" class="w-full p-3 border border-gray-600 rounded-md bg-gray-700 focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="mb-4">
            <label for="email" class="block text-lg font-medium mb-2">Email</label>
            <input type="email" id="email" name="email" class="w-full p-3 border border-gray-600 rounded-md bg-gray-700 focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="mb-4">
            <label for="age" class="block text-lg font-medium mb-2">Age</label>
            <input type="number" id="age" name="age" class="w-full p-3 border border-gray-600 rounded-md bg-gray-700 focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="mb-4">
            <label for="password" class="block text-lg font-medium mb-2">Password</label>
            <input type="password" id="password" name="password" class="w-full p-3 border border-gray-600 rounded-md bg-gray-700 focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <div class="mb-6">
            <label for="confirm-password" class="block text-lg font-medium mb-2">Confirm Password</label>
            <input type="password" id="confirm-password" name="confirm-password" class="w-full p-3 border border-gray-600 rounded-md bg-gray-700 focus:outline-none focus:ring-2 focus:ring-blue-500" required>
        </div>

        <button type="submit" class="w-full py-3 bg-blue-500 text-white rounded-md hover:bg-blue-600 focus:outline-none">Sign Up</button>

        <p class="text-center mt-4">Already have an account? <a href="<%=request.getContextPath()%>/pages/user/login.jsp" class="text-blue-400 hover:underline">Log in here</a></p>
    </form>
</div>



</body>
</html>