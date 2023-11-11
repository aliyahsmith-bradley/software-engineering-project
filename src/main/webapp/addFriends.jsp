<%--
  Created by IntelliJ IDEA.
  User: Brend
  Date: 11/10/2023
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="pokersite.model.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>

<%
    // get the json user data and parse it to a list of users using jackson
    String jsonData = (String) request.getAttribute("jsonData");
    ObjectMapper objectMapper = new ObjectMapper();
    List<User> users = objectMapper.readValue(jsonData, new TypeReference<List<User>>() {});
%>

<html>
<head>
    <title>Add Friends</title>
</head>
<body>
<div>
    <h1>ADD A FRIEND!</h1>
    <ul>
        <% for (User user : users) { %>
            <li><%= user.getUsername() %></li>
            <button type="button">Add Friend</button>
        <% } %>
    </ul>
</div>
</body>
</html>
