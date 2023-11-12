<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pokersite.model.entity.User" %>

<% User logged = (User) session.getAttribute("User"); %>

<html>
<div>
    <h2>Are you signed in?</h2>

    <% if(logged == null) { %>
        <h3>You are not logged in</h3>
    <% } else { %>
        <h3>You are logged in! Welcome <%=logged.getUsername()%></h3>
    <% } %>

    <h2>New? Register!</h2>
    <form method="post" action="registerUser">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"/><br>
        Email: <input type="text" name="email" /><br>
        First Name: <input type="text" name="first_name"/><br>
        Last name: <input type="text" name="last_name"/><br>
        Phone Number: <input type="text" name="phone_number"><br>
        <input type="submit" value="Register!">
    </form>
    <h2>Search for another user!</h2>
    <form method="get" action="searchUser">
        Username: <input type="text" name="username"><br>
        <input type="submit" value="Search!">
    </form>
    <% if(logged == null) { %>
        <h2>Already have an account? Login!</h2>
        <form method="post" action="loginUser">
            Email: <input type="text" name="email">
            Password: <input type="password" name="password">
            <input type="submit" value="Login!">
        </form>
    <% } else { %>
        <h2>View Your Friendrequests!</h2>
        <form method="get" action="searchFriendRequest">
            <input type="submit" value="View Friend Requests">
        </form>

        <h2>View Your Friendslist!</h2>
        <form method="get" action="searchFriendsList">
            <input type="submit" value="View Friends!">
        </form>

        <h2>Want to log out?</h2>
        <form method="post" action="logoutUser">
            <input type="submit" value="Logout!">
        </form>
    <% } %>

</div>
</html>
