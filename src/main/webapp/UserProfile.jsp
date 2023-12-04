<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="pokersite.model.entity.User" %>

<% User logged = (User) session.getAttribute("User"); %>

<!DOCTYPE html>
<html style="height:100%;">
<link href="css/userProfile.css" rel="stylesheet" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="scripts/getFriends.js"></script>
<script src="scripts/getMessages.js"></script>

<head>
    <title>JSP - User Profile</title>
</head>
<body>
    <a href="SignInPage.jsp" class="arrow-button"></a>
    <h1>Your Profile</h1>
    <div class="red-rectangle-01"></div>
    <div class="white-rectangle-01"></div>
    <div class="red-rectangle-02"></div>
    <div class="text-01">
        Personal Info
    </div>
    <div class="text-02">
        Username: <strong><%=logged.getUsername()%></strong>
        <br>
        <br>
        Email: <strong><%=logged.getEmail()%></strong>
        <br>
        <br>
        Phone Number: <strong><%=logged.getPhone_number()%></strong>
    </div>
    <div class="white-rectangle-02"></div>
    <div class="red-rectangle-03"></div>
    <div class="text-03">
        Balance
    </div>
    <div class="text-04">
        Coins: <strong><%=logged.getCoins()%></strong>
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
        Your Friendslist!
        <div>
<%--            <form method="get" action="searchFriendsList">--%>
<%--                <input type="submit" value="View Friends!">--%>
<%--            </form>--%>
            <p id="friends" class="friendslist"></p>
            <button onclick="getFriends()">View Friends</button>
        </div>
        <div class="friendslist">Messages</div>
        <div>
            <p id="messages" class="friendslist"></p>
            <button onclick="getMessages()">View Messages</button>
        </div>
    </div>

</body>
</html>