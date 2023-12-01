<%@ page import="pokersite.model.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% User logged = (User) session.getAttribute("User"); %>

<!DOCTYPE html>
<html style="height:100%;">
<head>
    <title>JSP - User Profile</title>
    <style>
        /* Applied gradient to background of web page */
        html {
            height: 100%;
            background: linear-gradient(to bottom, #FF0000, #FFCCCB);
            color: darkred;
        }

        h1 {
            font-size: 50px;
            font-family: "SansSerif", sans-serif;
            position: fixed;
            top: 30px;
            left: 575px;
            white-space: nowrap; /* Prevent line breaks */
            background-color: white;
            border-radius: 0;
            padding: 10px 20px;
            z-index: 1;
        }

        .red-rectangle {
            background-color: darkred;
            width: 320px;
            height: 80px;
            position: fixed;
            top: 52px;
            left: 560px;
        }

        p {
            color: white;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <h1>User Profile</h1>
    <div class="red-rectangle"></div>
    <p>User Name: <%=logged.getUsername()%></p>
    <p>Password: </p>
    <p>Avatar</p>
    <p>Game Stats</p>
    <p>Friends</p>
</body>
</html>