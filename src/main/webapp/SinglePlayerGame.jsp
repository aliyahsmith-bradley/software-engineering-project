<%@ page import="java.util.List" %>
<%@ page import="pokersite.Logic.loginguestsignuppage.Advertisement" %>
<%@ page import="pokersite.Logic.loginguestsignuppage.AdsManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Five Card Draw</title>
    <link rel="stylesheet" href="/css/tableStyles.css">
    <script src="tableGame.js" defer></script>

    <style>
        body {
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(#181e33, #546a80, #546a80, #181e33);
        }
    </style>
</head>

<body>
<div class="topnav">
    <div class="money-box">Current Balance: ${requestScope.userCoins}</div>
</div>

<h1>User Coins: ${requestScope.userCoins}</h1>

<div class="dropdown">
    <button onclick="myFunction()" class="dropbutton">Backgrounds</button>
    <div id="myDropdown" class="dropdown-content">
        <a onclick="background1()">Default</a>
        <a onclick="background2()">Casino</a>
        <a onclick="background3()">Terracotta</a>
    </div>
</div>

<!-- Display ads -->
<div id="ads-container">
    <c:forEach var="ad" items="<%= AdsManager.getAds() %>">
        <div class="ad">
            <a href="<c:out value="${ad.getAdLink()}"/>" target="_blank">
                <c:out value="{ad.getAdContent()}" />
            </a>
        </div>
    </c:forEach>
</div>
</body>

</html>

