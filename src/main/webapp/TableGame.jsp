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
        <div class = "money-box"></div>
    </div>
    <img class="table-picture" src="images/table_default.png">
    <div class="card-container">
        <div class="c-pos-1">
        </div>
        <div class="c-pos-2"></div>
        <div class="c-pos-3"></div>
        <div class="c-pos-4"></div>
        <div class="c-pos-5"></div>

    </div>
    <div class="betting-button">
        <button type="button" class="button" onclick="alert('you raise!')">Raise</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you check!')">Check</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you fold!')">Fold</button>
        <button type="button" class="button" onclick="background1()">background</button>
    </div>
</main>
</body>
</html>
