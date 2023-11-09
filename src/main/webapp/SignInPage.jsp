<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html style="height:100%;">
<head>
    <title>JSP - Sign In Page</title>
    <style>
        /* Applied gradient to background of web page */
        html {
            height: 100%;
            background: linear-gradient(to bottom, #FF0000, #FFCCCB);
            color: darkred;
        }
        h1 {
            font-size: 100px;
            font-family: "SansSerif", sans-serif;
            position: fixed;
            top: 110px;
            left: 355px;
            white-space: nowrap; /* Prevent line breaks */
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
            top: 160px;
            left: 335px;
        }
        .button-link-1 {
            position: fixed;
            left: 250px;
            bottom: 210px;
            z-index: 1;
            text-decoration: none;
            color: black;
        }
        .button-link-2 {
            position: fixed;
            left: 658px;
            bottom: 240px;
            z-index: 1;
            text-decoration: none;
            color: white;
        }
        .button-link-3 {
            position: fixed;
            right: 258px;
            bottom: 205px;
            z-index: 1;
            text-decoration: none;
            color: black;
        }
        .button-text {
            display: block;
            font-size: 35px;
            font-family: "SansSerif", sans-serif;
            font-weight: bold;
            background-color: transparent;
            padding: 0;
            border: none;
            cursor: pointer;
            text-align: center;
        }
        .green-chip {
            background-image: url("../../../Images/green-chip.png");
            background-size: cover;
            width: 300px;
            height: 300px;
            position: fixed;
            left: 170px;
            bottom: 110px;
        }
        .black-chip {
            background-image: url("../../../Images/black-chip.png");
            background-size: cover;
            width: 350px;
            height: 300px;
            position: fixed;
            left: 520px;
            bottom: 110px;
        }
        .blue-chip {
            background-image: url("../../../Images/blue-chip.png");
            background-size: cover;
            width: 300px;
            height: 300px;
            position: fixed;
            right: 170px;
            bottom: 110px;
        }
        .home_button {
            background-image: url("../../../Images/home_button.png");
            background-size: cover;
            width: 50px;
            height: 50px;
            z-index: 1;
            float: right;
            margin-right: 15px;
            margin-top: 5px;
        }
        .book_button {
            background-image: url("../../../Images/book_button.png");
            background-size: cover;
            width: 70px;
            height: 70px;
            z-index: 1;
            float: right;
            margin-right: 25px;
        }
    </style>
</head>
<body>
<h1>Feeling Lucky?</h1>
<div class="red-rectangle"></div>
<a href="../../../main_index.jsp" class="home_button"></a>
<a href="Rules.jsp" class="book_button"></a>
<a href="SignUp.jsp" class="button-link-1">
    <span class="button-text">Make An</span>
    <br>
    <span class="button-text">Account</span>
</a>
<a href="SignInPage.jsp" class="button-link-2">
    <span class="button-text">Sign In</span>
</a>
<a href="TableGame.jsp" class="button-link-3">
    <span class="button-text">Play as</span>
    <br>
    <span class="button-text">Guest</span>
</a>
<div class="green-chip"></div>
<div class="black-chip"></div>
<div class="blue-chip"></div>
</body>
</html>