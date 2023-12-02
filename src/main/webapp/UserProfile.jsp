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
            background: linear-gradient(to bottom, #C00101, #B85858);
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

        .red-rectangle-01 {
            background-color: darkred;
            width: 320px;
            height: 80px;
            position: fixed;
            top: 52px;
            left: 560px;
        }

        .white-rectangle-01 {
            background-color: white;
            width: 400px;
            height: 275px;
            position: fixed;
            top: 210px;
            left: 225px;
            border-radius: 10px;
        }

        p {
            color: white;
            font-size: 20px;
        }

        .welcome-message {
            color: white;
            font-size: 20px;
            margin: 0;
            display: flex;
            align-items: center;
            text-align: center;
            position: fixed;
            top: 160px;
            left: 550px;
        }

        /* Text: "Your Info" Title */
        .text-01 {
            color: white;
            font-family: "SansSerif", sans-serif;
            font-size: 40px;
            position: fixed;
            top: 200px;
            left: 300px;
            z-index: 1;
        }

        .red-rectangle-02 {
            background-color: darkred;
            width: 320px;
            height: 80px;
            position: fixed;
            top: 185px;
            left: 265px;
            border-radius: 10px;
        }

        /* Text: "Your Info" User Information */
        .text-02 {
            color: darkred;
            font-size: 25px;
            position: fixed;
            top: 285px;
            left: 235px;
        }

        .white-rectangle-02 {
            background-color: white;
            width: 400px;
            height: 175px;
            position: fixed;
            top: 550px;
            left: 225px;
            border-radius: 10px;
        }

        .red-rectangle-03 {
            background-color: darkred;
            width: 320px;
            height: 80px;
            position: fixed;
            top: 525px; /* 25 px distance to white from top */
            left: 265px;
            border-radius: 10px;
        }

        /* Text: "Balance" Title */
        .text-03 {
            color: white;
            font-family: "SansSerif", sans-serif;
            font-size: 40px;
            position: fixed;
            top: 540px;
            left: 350px;
            z-index: 1;
        }

        /* Text: Balance Information */
        .text-04 {
            color: darkred;
            font-size: 25px;
            position: fixed;
            top: 640px;
            left: 265px;
            z-index: 1;
        }

        /* "Buy More" Button */
        .buy-more-button-container {
            text-align: center;
        }

        .buy-more-button {
            background-color: #C00101;
            color: white;
            padding: 10px 20px;
            font-size: 20px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            position: fixed;
            top: 632px;
            left: 400px;
        }

        .buy-more-button:hover {
            background-color: red; /* Changes the background color when cursor hovers */
        }

        .white-rectangle-03 {
            background-color: white;
            width: 500px;
            height: 275px;
            position: fixed;
            top: 210px;
            right: 225px;
            border-radius: 10px;
        }

        .red-rectangle-04 {
            background-color: darkred;
            width: 420px;
            height: 80px;
            position: fixed;
            top: 185px;
            right: 265px;
            border-radius: 10px;
        }

        /* Text: "Game Stats" Title */
        .text-05 {
            color: white;
            font-family: "SansSerif", sans-serif;
            font-size: 40px;
            position: fixed;
            top: 200px;
            right: 375px;
            z-index: 1;
        }

        /* Text: "Game Stats" Information Left Column */
        .text-06 {
            color: darkred;
            font-size: 25px;
            position: fixed;
            top: 285px;
            right: 490px;
            z-index: 1;
        }

        .red-line {
            width: 2px;
            height: 20%;
            background-color: darkred;
            position: fixed;
            top: 280px;
            right: 470px;
            z-index: 1;
        }

        /* Text: "Game Stats" Information Right Column */
        .text-07 {
            color: darkred;
            font-size: 25px;
            position: fixed;
            top: 285px;
            right: 230px;
            z-index: 1;
        }

        .white-rectangle-04 {
            background-color: white;
            width: 500px;
            height: 175px;
            position: fixed;
            top: 550px;
            right: 225px;
            border-radius: 10px;
        }

        .red-rectangle-05 {
            background-color: darkred;
            width: 420px;
            height: 80px;
            position: fixed;
            top: 525px; /* 25 px distance to white from top */
            right: 265px;
            border-radius: 10px;
        }

        /* Text: "Friends" Title */
        .text-08 {
            color: white;
            font-family: "SansSerif", sans-serif;
            font-size: 40px;
            position: fixed;
            top: 540px;
            right: 380px;
            z-index: 1;
        }

    </style>
</head>
<body>
    <h1>Your Profile</h1>
    <div class="red-rectangle-01"></div>
    <div class="white-rectangle-01"></div>
    <div class="red-rectangle-02"></div>
    <div class="text-01">
        Personal Info
    </div>
    <div class="text-02">
        Username: <strong>userName</strong>
        <br>
        <br>
        Email: <strong>email@gmail.com</strong>
        <br>
        <br>
        Phone Number: <strong>XXX-XXX-XXXX</strong>
    </div>
    <div class="white-rectangle-02"></div>
    <div class="red-rectangle-03"></div>
    <div class="text-03">
        Balance
    </div>
    <div class="text-04">
        Coins: <strong>0</strong>
    </div>
    <div class="buy-more-button-container">
        <button class="buy-more-button" onclick="redirectToInAppPurchases()">Buy More Coins</button>
    </div>

    <script>
        function redirectToInAppPurchases() {
            window.location.href = "index.jsp" // Placeholder for now
        }
    </script>

    <div class="white-rectangle-03"></div>
    <div class="red-rectangle-04"></div>
    <div class="text-05">
        Game Stats
    </div>
    <div class="text-06">
        Total Hands Played: <strong>0</strong>
        <br>
        <br>
        Total Hands Won: <strong>0</strong>
        <br>
        <br>
        Total Hands Folded: <strong>0</strong>
    </div>
    <div class="red-line"></div>
    <div class="text-07">
        Winning Percentage: <strong>0</strong>
        <br>
        <br>
        Winning Streak: <strong>0</strong>
        <br>
        <br>
        Biggest Pot Won: <strong>0</strong>
        <br>
        <br>
    </div>
    <div class="white-rectangle-04"></div>
    <div class="red-rectangle-05"></div>
    <div class="text-08">
        Friends List
    </div>
</body>
</html>