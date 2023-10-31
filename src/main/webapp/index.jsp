<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html style="height:100%;">
<head>
    <title>JSP - Five Draw</title>
    <style>
        /* Applied gradient to background of web page */
        html {
            height: 100%;
            background: linear-gradient(to bottom, #FF0000, #FFCCCB);
            color: darkred;
        }
        /* Groups text and button toward bottom of web page */
        .content {
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            align-items: center;
            height: 85vh;
        }
        body {
            margin: 0;
            padding: 0;
        }
        .deck-of-cards {
            background-image: url("../../../Images/image1.png");
            background-size: cover;
            width: 100px;
            height: 100px;
        }
        h1 {
            font-size: 100px;
            font-family: "SansSerif", sans-serif;
            margin-bottom: 10px;
        }
        .rounded-button {
            background-color: white;
            border: none;
            color:black;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 20px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="deck-of-cards"></div>
    <div class="content">
        <h1><%= "Five Card Draw" %></h1>
        <a href="SignInPage.jsp">
            <button class="rounded-button">Play Now</button>
        </a>
    </div>
<br/>
</body>
</html>