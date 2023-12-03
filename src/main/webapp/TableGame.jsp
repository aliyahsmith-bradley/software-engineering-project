<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Five Card Draw</title>
    <link rel="stylesheet" href="table_style.css">
    <script src="tableGame.js" defer></script>

</head>
<%
    List<String> cardImages = new ArrayList<>();
    cardImages.add("images/2_of_clubs.png");
    cardImages.add("images/2_of_spades.png");
    cardImages.add("images/2_of_diamonds.png");
    cardImages.add("images/2_of_hearts.png");
    cardImages.add("images/3_of_clubs.png");
    cardImages.add("images/3_of_diamonds.png");
    cardImages.add("images/3_of_hearts.png");
    cardImages.add("images/3_of_spades.png");
    cardImages.add("images/4_of_clubs.png");
    cardImages.add("images/4_of_diamonds.png");
    cardImages.add("images/4_of_hearts.png");
    cardImages.add("images/4_of_spades.png");
    cardImages.add("images/5_of_clubs.png");
    cardImages.add("images/5_of_spades.png");
    cardImages.add("images/5_of_diamonds.png");
    cardImages.add("images/5_of_hearts.png");
    cardImages.add("images/6_of_clubs.png");
    cardImages.add("images/6_of_diamonds.png");
    cardImages.add("images/6_of_hearts.png");
    cardImages.add("images/6_of_spades.png");
    cardImages.add("images/7_of_clubs.png");
    cardImages.add("images/7_of_spades.png");
    cardImages.add("images/7_of_diamonds.png");
    cardImages.add("images/7_of_hearts.png");
    cardImages.add("images/8_of_clubs.png");
    cardImages.add("images/8_of_hearts.png");
    cardImages.add("images/8_of_spades.png");
    cardImages.add("images/8_of_diamonds.png");
    cardImages.add("images/9_of_clubs.png");
    cardImages.add("images/9_of_hearts.png");
    cardImages.add("images/9_of_spades.png");
    cardImages.add("images/9_of_diamonds.png");
    cardImages.add("images/10_of_clubs.png");
    cardImages.add("images/10_of_hearts.png");
    cardImages.add("images/10_of_spades.png");
    cardImages.add("images/10_of_diamonds.png");
    cardImages.add("images/ace_of_clubs.png");
    cardImages.add("images/ace_of_hearts.png");
    cardImages.add("images/ace_of_spades.png");
    cardImages.add("images/ace_of_diamonds.png");
    //cardImages.add("images/black_joker.png");
    //cardImages.add("images/red_joker.png");
    cardImages.add("images/jack_of_clubs2.png");
    cardImages.add("images/jack_of_hearts2.png");
    cardImages.add("images/jack_of_spades2.png");
    cardImages.add("images/jack_of_diamonds2.png");
    cardImages.add("images/queen_of_clubs2.png");
    cardImages.add("images/queen_of_hearts2.png");
    cardImages.add("images/queen_of_spades2.png");
    cardImages.add("images/queen_of_diamonds2.png");
    cardImages.add("images/king_of_clubs2.png");
    cardImages.add("images/king_of_hearts2.png");
    cardImages.add("images/king_of_spades2.png");
    cardImages.add("images/king_of_diamonds2.png");

    // Shuffle the card images
    Collections.shuffle(cardImages);

    // Render the shuffled cards
%>
<body>

<main>
    <div class="topnav">
        <div class = "money-box">100</div>
    </div>
    <button id="dealCards" class="deal-cards" onclick="startGame()"> Deal Cards</button>

    <div class="dropdown">
        <button onclick="myFunction()" class="dropbutton" >Backgrounds</button>
        <div id="myDropdown" class="dropdown-content">
            <a onclick="background1()">Default</a>
            <a onclick="background2()">Casino</a>
            <a onclick="background3()">Terracotta</a>
        </div>
    </div>
    <img class="table-picture" src="images/table_default.png">
    <div class="card-container">
        <div class="c-pos-1"></div>
        <div class="c-pos-2"></div>
        <div class="c-pos-3"></div>
        <div class="c-pos-4"></div>
        <div class="c-pos-5"></div>
    </div>
    <div class="opponent-3">
        <div class="op-card-container">
            <div class="grid-item"><img class="op-card" src="images/card-back.jpg" ></div>
            <div class="grid-item"><img class="op-card" src="images/card-back.jpg" ></div>
            <div class="grid-item"><img class="op-card" src="images/card-back.jpg" ></div>
            <div class="grid-item"><img class="op-card" src="images/card-back.jpg" ></div>
            <div class="grid-item"><img class="op-card" src="images/card-back.jpg" ></div>
        </div>
    </div>

    <div class="betting-button">
        <button type="button" class="button" onclick="alert('you raise!')">Raise</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you check!')">Check</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you fold!')">Fold</button>
    </div>
</main>
<audio class="background-music" autoplay loop controls>
    <source src="images/Casino%20Sound%20Effect.mp3" type="audio/ogg">
</audio>
</body>
</html>
