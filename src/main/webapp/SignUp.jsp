<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="container">
    <h3>Sign Up</h3>
    <form action="GuestAccount.jsp" method="post">
        <input type="text" name="firstName" placeholder="First Name" required><br><br>
        <input type="text" name="lastName" placeholder="Last Name" required><br><br>
        <input type="email" name="email" placeholder="Email" required><br><br>
        <input type="text" name="phoneNumber" placeholder="Phone Number" required><br><br>
        <input type="text" name="username" placeholder="Username" required><br><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        <input type="submit" value="Sign Up" class="button">
    </form>
</div>
</body>
</html>

