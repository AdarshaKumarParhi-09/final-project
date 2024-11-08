<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin: 0;
        padding: 20px;
    }
    h2 {
        color: #0056b3;
    }
    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: 20px auto;
    }
    label {
        font-weight: bold;
    }
    input[type="text"], input[type="email"], input[type="password"], select {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    button {
        background-color: #0056b3;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
        width: 100%;
    }
    button:hover {
        background-color: #003f7f;
    }
    p {
        text-align: center;
    }
    a {
        color: #0056b3;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h2>User Registration</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="register">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>

        <label for="role">Role:</label>
        <select name="role" id="role" required>
            <option value="student">Student</option>
            <option value="teacher">Teacher</option>
        </select><br>

        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
</body>
</html>
