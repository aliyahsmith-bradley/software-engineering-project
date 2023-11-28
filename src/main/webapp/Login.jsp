<%@ page import="pokersite.model.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% User logged = (User) session.getAttribute("User"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Are you signed in?</h2>

    <% if(logged == null) { %>
    <h3>You are not logged in</h3>
    <% } else { %>
    <h3>You are logged in! Welcome <%=logged.getUsername()%></h3>
    <% } %>


    <% if(logged == null) { %>
    <h2>Already have an account? Login!</h2>
    <form method="post" action="loginUser">
        Email: <input type="text" name="email">
        Password: <input type="password" name="password">
        <input type="submit" value="Login!">
    </form>
<% } %>
</div>
</body>
</html>
