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
            height: 90vh;
        }
        body {
            margin: 0;
            padding: 0;
        }
        .casino-chips-1 {
            background-image: url("Images/casino-chips_1.png");
            background-size: cover;
            width: 400px;
            height: 400px;
            float: left;
        }
        .casino-chips-2 {
            background-image: url("Images/casino-chips-2.png");
            background-size: cover;
            width: 400px;
            height: 400px;
            float: right;
        }
        .deck-of-cards {
            background-image: url("Images/deck_of_cards.png");
            background-size: cover;
            width: 900px;
            height: 700px;
            display: block;
            margin: 0 auto;
            position: fixed;
            top: 50px;
            right: 340px;
        }
        h1 {
            font-size: 100px;
            font-family: "SansSerif", sans-serif;
            position: fixed;
            margin-bottom: 20px;
            bottom: 95px;
            white-space: nowrap; /* Prevent line breaks */
            overflow: hidden;    /* Hide overflow text */
            background-color: white;
            border-radius: 0;
            padding: 10px 20px;
            z-index: 1;
        }
        .red-rectangle {
            background-color: darkred;
            width: 770px;
            height: 140px;
            position: fixed;
            bottom: 95px;
            right: 320px;
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
            position: fixed;
            bottom: 40px;
            right: 670px;
        }
    </style>
</head>
<body>
<div class="casino-chips-1"></div>
<div class="casino-chips-2"></div>
<div class="content">
    <div class="deck-of-cards"></div>
    <h1><%= "Five Card Draw" %></h1>
    <div class="red-rectangle"></div>
    <a href="src/main/webapp/SignInPage.jsp">
        <button class="rounded-button">Play Now</button>
    </a>
</div>
<br/>
</body>
</html>