<%--
  Created by IntelliJ IDEA.
  User: Brend
  Date: 11/12/2023
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="pokersite.model.entity.Friendship" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="pokersite.controller.service.UserService" %>

<%
    // get the json user data and parse it to a list of users using jackson
    String jsonData = (String) request.getAttribute("jsonData");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Friendship> friendshipList = objectMapper.readValue(jsonData, new TypeReference<List<Friendship>>() {});
%>

<html>
<head>
    <title>Your Friends!</title>
</head>
<body>
<div>
    <h1>Your Friends!</h1>
    <ul>
        <% for (Friendship friend : friendshipList) { %>
            <li>Friend: <%=UserService.findUserByUserID(friend.getId_user1()).getUsername()%></li>
            <form method="post" action="removeFriend">
                <input type="hidden" name="friend" value="<%=friend.getID()%>">
                <input type="submit" value="remove">
            </form>
        <% } %>
    </ul>
</div>

</body>
</html>
