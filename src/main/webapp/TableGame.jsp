<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale1.0">
    <meta http-equiv="X-UA-Compatable" content="ie=edge">
    <title>Card Game</title>
    <script src="tableGame.js" type="module"></script>
    <link rel="stylesheet" href="table_style.css">
</head>
<body>
<div class="top-bar">
    <div class="topnav">
        <div class="topnav-text">Your money</div>
    </div>
    <div class="topnav">
        <div class="money-box" id="user-coin-amount">10</div>
    </div>
    <div class="topnav">
        <div class="topnav-text">Current Pot:</div>
    </div>
    <div class="topnav">
        <div class="money-box" id="pot-amount"> 0</div>
    </div>
</div>
<button id="dealCards" class="deal-cards" > Deal Cards</button>

<%--<div class="dropdown">--%>
<%--    <button onclick="myFunction()" class="drop-button" >Backgrounds</button>--%>
<%--    <div id="myDropdown" class="dropdown-content">--%>
<%--        <a onclick="background1()">Default</a>--%>
<%--        <a onclick="background2()">Casino</a>--%>
<%--        <a onclick="background3()">Terracotta</a>--%>
<%--    </div>--%>
<%--</div>--%>
<img class="table-picture" src="images/table_default.png">
<div class="comp-hand">
</div>

<div class="player-hand">
</div>

<div id="result-message" class="result-message"></div>
<div class="betting-button">
    <button type="button" class="button" id="bet-button">Raise</button>
    <h1></h1>
    <button type="button" class="button" id="check-button">Check</button>
    <h1></h1>
    <button type="button" class="button" id="fold-button">Fold</button>
</div>


<button type="button" id="ready-replace" class="replaceButton">Replace</button>
<button type="button" id="keep-Hand" class="keepHand">Keep Hand</button>



<audio class="background-music" autoplay loop controls>
    <source src="images/Casino%20Sound%20Effect.mp3" type="audio/ogg">
</audio>



<div class="bet-form" id="user-bet-form">
    <div class="bet-form-text">wtf man give me a break</div>
    <button class="bet-form-text" type="button" id="is-bet">Bet</button>
</div>
</body>
</html>
