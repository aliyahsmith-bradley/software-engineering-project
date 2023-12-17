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
<div class="topnav">
    <div class = "money-box">100</div>
</div>
<button id="dealCards" class="deal-cards" > Deal Cards</button>

<div class="dropdown">
    <button onclick="myFunction()" class="dropbutton" >Backgrounds</button>
    <div id="myDropdown" class="dropdown-content">
        <a onclick="background1()">Default</a>
        <a onclick="background2()">Casino</a>
        <a onclick="background3()">Terracotta</a>
    </div>
</div>
<img class="table-picture" src="images/table_default.png">
<div class="comp-hand">
</div>

<div class="player-hand">
</div>
<div class="betting-button">
    <button type="button" class="button" onclick="alert('you raise!')">Raise</button>
    <h1></h1>
    <button type="button" class="button" onclick="alert('you check!')">Check</button>
    <h1></h1>
    <button type="button" class="button" onclick="alert('you fold!')">Fold</button>
</div>
<button type="button" id="ready-replace" class="relplaceButton">Replace</button>

<audio class="background-music" autoplay loop controls>
    <source src="images/Casino%20Sound%20Effect.mp3" type="audio/ogg">
</audio>
</body>
</html>
