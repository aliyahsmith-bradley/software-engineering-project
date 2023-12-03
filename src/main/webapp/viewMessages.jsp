<%@ page import="pokersite.model.entity.User" %>
<%@ page import="pokersite.model.entity.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="pokersite.controller.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // get the json user data and parse it to a list of users using jackson
    String jsonData = (String) request.getAttribute("jsonData");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Message> messages = objectMapper.readValue(jsonData, new TypeReference<List<Message>>() {});

    User us = (User) session.getAttribute("User");
%>

<html>
<head>
    <title>Messages</title>
</head>
<body>
<div>
    <h1>Messages</h1>
    <ul>
        <% for (Message message: messages) { %>
            <p>Sender: <%=UserService.findUserByUserID(message.getId_user_sender()).getUsername()%><br>
               Message: <%=message.getMessage()%>
            </p>
        <% } %>
    </ul>
</div>
</body>
</html>
