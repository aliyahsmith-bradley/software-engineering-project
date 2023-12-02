<%@ page import="pokersite.model.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% User logged = (User) session.getAttribute("User"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>JSP - Login </title>
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
    <p>Please enter your email and password below to continue. </p>
    <form method="post" action="loginUser">
        Email: <label>
            <input type="text" name="email">
        </label>
        Password: <label>
            <input type="password" name="password">
        </label>
        <input type="submit" value="Login!">
    </form>
    <% } %>

    <%
        String errorCode = request.getParameter("error");
        if(errorCode != null && errorCode.equals("1")) {
    %>
    <br>
    <div style="color: yellow;">Invalid username or password. Please try again.</div>
    <%
        }
    %>
</div>
</body>
</html>
