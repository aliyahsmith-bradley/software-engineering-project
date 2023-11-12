<%--
  Created by IntelliJ IDEA.
  User: Brend
  Date: 11/11/2023
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="pokersite.model.entity.Friend_Request" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="pokersite.controller.service.UserService" %>

<%
    // get the json user data and parse it to a list of users using jackson
    String jsonData = (String) request.getAttribute("jsonData");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Friend_Request> friendRequests = objectMapper.readValue(jsonData, new TypeReference<List<Friend_Request>>() {});
%>

<html>
<head>
    <title>Friend Requests!</title>
</head>
<body>
<div>
    <h1>Friendslist!</h1>
    <ul>
        <% for (Friend_Request friendRequest : friendRequests) { %>
            <li>You have a friend request from: <%=UserService.findUserByID(friendRequest.getId_user_sender()).getUsername()%></li>
            <form method="post" action="acceptFriendRequest">
                <input type="hidden" name="username" value="<%=UserService.findUserByID(friendRequest.getId_user_sender()).getUsername()%>">
                <input type="hidden" name="friendRequest" value="<%=friendRequest.getID()%>">
                <input type="submit" value="accept">
            </form>
        <% } %>
    </ul>
</div>

</body>
</html>