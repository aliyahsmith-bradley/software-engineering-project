<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Five Card Draw</title>
    <link rel="stylesheet" href="css/table_style.css">
    <script src="js/tableGame.js" defer></script>
</head>

<body>
<main>
    <img class="table-picture" src="images/table3.png">
    <div class="card-container">
        <%-- This is the Java code that shuffles the cards --%>
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
            cardImages.add("images/black_joker.png");
            cardImages.add("images/red_joker.png");
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
            int id = 1;
            for (String imagePath : cardImages) {
        %>
        <div class="c-pos-<%= id %>">
            <img src="<%= imagePath %>" class = "card">
        </div>
        <%
                id++;
            }
        %>
    </div>
    <div class="betting-button">
        <button type="button" class="button" onclick="alert('you raise!')">Raise</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you check!')">Check</button>
        <h1></h1>
        <button type="button" class="button" onclick="alert('you fold!')">Fold</button>
    </div>
</main>
</body>
</html>
