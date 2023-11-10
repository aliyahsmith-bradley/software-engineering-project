<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div>
    <h2>Are you signed in?</h2>
    <h2>New? Register!</h2>
    <form method="post" action="registerUser">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"/><br>
        Email: <input type="text" name="email" /><br>
        First Name: <input type="text" name="first_name"/><br>
        Last name: <input type="text" name="last_name"/><br>
        Phone Number: <input type="text" name="phone_number"><br>
        <input type="submit">
    </form>
    <h2>Search for another user!</h2>
    <form method="get" action="searchUser">
        Username: <input type="text" name="username"><br>
        <input type="submit">
    </form>
</div>
</html>
