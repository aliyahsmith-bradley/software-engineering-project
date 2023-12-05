<%@ page import="pokersite.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User logged = (User) session.getAttribute("User");%>
<html>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="scripts/getIssues.js"></script>
<head>
    <title>Admin</title>
</head>
<body>
<% if (logged != null && logged.getPermission() == 1) { %>
    <div>
        <h1>Hello Admin!</h1>
        <h2>Ban a word?</h2>
        <form method="post" action="banWord">
            Enter Word: <input type="text" name="word"><br>
            <input type="submit" value="Ban!">
        </form>
    </div>
    <div>
        <h1>Reported Issues</h1>
        <div>
            <p id="issues"></p>
            <button onclick="getIssues()">Get Issues</button>
        </div>
    </div>
<% } else { %>
    <div role="alert">
        <h4>Not Administrator</h4>
        <p>You do not have permission to be here</p>
        <hr>
    </div>
<% } %>
</body>
</html>
