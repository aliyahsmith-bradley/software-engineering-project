<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>JSP - Sign Up</title>
    <style>
        .button {
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Sign Up</h3>
    <form action="registerUser" method="post">
        <label>
            <input type="text" name="firstName" placeholder="First Name" required>
        </label>
        <br>
        <br>
        <label>
            <input type="text" name="lastName" placeholder="Last Name" required>
        </label>
        <br>
        <br>
        <label>
            <input type="email" name="email" placeholder="Email" required>
        </label>
        <br>
        <br>
        <label>
            <input type="text" name="phoneNumber" placeholder="Phone Number" required>
        </label>
        <br>
        <br>
        <label>
            <input type="text" name="username" placeholder="Username" required>
        </label>
        <br>
        <br>
        <label>
            <input type="password" name="password" placeholder="Password" required>
        </label>
        <br>
        <br>
        <input type="submit" value="Sign Up" class="button">
    </form>
</div>
</body>
</html>

