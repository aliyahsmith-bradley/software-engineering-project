<%@ page import="pokersite.model.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% User logged = (User) session.getAttribute("User"); %>

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
            background-image: url("images/green-chip.png");
            background-size: cover;
            width: 300px;
            height: 300px;
            position: fixed;
            left: 170px;
            bottom: 110px;
        }
        .black-chip {
            background-image: url("images/black-chip.png");
            background-size: cover;
            width: 350px;
            height: 300px;
            position: fixed;
            left: 520px;
            bottom: 110px;
        }
        .blue-chip {
            background-image: url("images/blue-chip.png");
            background-size: cover;
            width: 300px;
            height: 300px;
            position: fixed;
            right: 170px;
            bottom: 110px;
        }
        .home_button {
            background-image: url("images/home_button.png");
            background-size: cover;
            width: 50px;
            height: 50px;
            z-index: 1;
            float: right;
            margin-right: 15px;
            margin-top: 5px;
        }
        .book_button {
            background-image: url("images/book_button.png");
            background-size: cover;
            width: 70px;
            height: 70px;
            z-index: 1;
            float: right;
            margin-right: 25px;
        }
        .account_button {
            display: inline-block;
            background-color: darkred;
            color: white;
            border: none;
            border-radius: 50%;
            width: 30px;
            height: 30px;
            padding: 20px;
            text-align: center;
            text-decoration: none;
            font-size: 18px;
            margin: 4px 2px;
            cursor: pointer;
        }

        .guest_message {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            background-color: darkred;
            border: 1px solid #ccc;
            z-index: 1;
        }

        .close {
            color: white;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
        }

        p {
            color: white;
            font-size: 20px;
            font-weight: bold;
        }

        .account_button2 {
            background-image: url("images/avatar1.png");
            background-size: cover;
            width: 75px;
            height: 70px;
        }

    </style>
</head>
<body>
<div>
    <% if(logged != null) { %>
    <h3>You are logged in! Welcome <%=logged.getUsername()%></h3>

    <h3>Want to log out?</h3>
    <form method="post" action="logoutUser">
        <input type="submit" value="Logout!">
    </form>
    <% } %>
</div>

<h1>Feeling Lucky?</h1>
<div class="red-rectangle"></div>

<% if(logged == null) { %>
<button onclick="showPopUp()" class="account_button2"></button>
<div id="popup" class="guest_message">
    <span class="close" onclick="hidePopUp()">&times;</span>
    <p>Please sign in or create an account to view your profile.</p>
</div>

<script>
    function showPopUp() {
        document.getElementById("popup").style.display = "block";
    }

    function hidePopUp() {
        document.getElementById("popup").style.display = "none";
    }
</script>
<% } else { %>
<button onclick="viewAccount()" class="account_button2"></button>

<script>
    function viewAccount() {
        window.location.href = "UserProfile.jsp"
    }
</script>
<% } %>

<a href="index.jsp" class="home_button"></a>

<a href="Rules.jsp" class="book_button"></a>

<a href="SignUp.jsp" class="button-link-1">
    <span class="button-text">Make An</span>
    <br>
    <span class="button-text">Account</span>
</a>

<a href="Login.jsp" class="button-link-2">
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