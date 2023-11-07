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
    <img class="table-picture" src="../../../Images/table3.png">
    <div class="card-container">
        <%-- This is the Java code that shuffles the cards --%>
        <%
            List<String> cardImages = new ArrayList<>();
            cardImages.add("../../../Images/2_of_clubs.png");
            cardImages.add("../../../Images/2_of_spades.png");
            cardImages.add("../../../Images/2_of_diamonds.png");
            cardImages.add("../../../Images/2_of_hearts.png");
            cardImages.add("../../../Images/3_of_clubs.png");
            cardImages.add("../../../Images/3_of_diamonds.png");
            cardImages.add("../../../Images/3_of_hearts.png");
            cardImages.add("../../../Images/3_of_spades.png");
            cardImages.add("../../../Images/4_of_clubs.png");
            cardImages.add("../../../Images/4_of_diamonds.png");
            cardImages.add("../../../Images/4_of_hearts.png");
            cardImages.add("../../../Images/4_of_spades.png");
            cardImages.add("../../../Images/5_of_clubs.png");
            cardImages.add("../../../Images/5_of_spades.png");
            cardImages.add("../../../Images/5_of_diamonds.png");
            cardImages.add("../../../Images/5_of_hearts.png");
            cardImages.add("../../../Images/6_of_clubs.png");
            cardImages.add("../../../Images/6_of_diamonds.png");
            cardImages.add("../../../Images/6_of_hearts.png");
            cardImages.add("../../../Images/6_of_spades.png");
            cardImages.add("../../../Images/7_of_clubs.png");
            cardImages.add("../../../Images/7_of_spades.png");
            cardImages.add("../../../Images/7_of_diamonds.png");
            cardImages.add("../../../Images/7_of_hearts.png");
            cardImages.add("../../../Images/8_of_clubs.png");
            cardImages.add("../../../Images/8_of_hearts.png");
            cardImages.add("../../../Images/8_of_spades.png");
            cardImages.add("../../../Images/8_of_diamonds.png");
            cardImages.add("../../../Images/9_of_clubs.png");
            cardImages.add("../../../Images/9_of_hearts.png");
            cardImages.add("../../../Images/9_of_spades.png");
            cardImages.add("../../../Images/9_of_diamonds.png");
            cardImages.add("../../../Images/10_of_clubs.png");
            cardImages.add("../../../Images/10_of_hearts.png");
            cardImages.add("../../../Images/10_of_spades.png");
            cardImages.add("../../../Images/10_of_diamonds.png");
            cardImages.add("../../../Images/ace_of_clubs.png");
            cardImages.add("../../../Images/ace_of_hearts.png");
            cardImages.add("../../../Images/ace_of_spades.png");
            cardImages.add("../../../Images/ace_of_diamonds.png");
            cardImages.add("../../../Images/black_joker.png");
            cardImages.add("../../../Images/red_joker.png");
            cardImages.add("../../../Images/jack_of_clubs2.png");
            cardImages.add("../../../Images/jack_of_hearts2.png");
            cardImages.add("../../../Images/jack_of_spades2.png");
            cardImages.add("../../../Images/jack_of_diamonds2.png");
            cardImages.add("../../../Images/queen_of_clubs2.png");
            cardImages.add("../../../Images/queen_of_hearts2.png");
            cardImages.add("../../../Images/queen_of_spades2.png");
            cardImages.add("../../../Images/queen_of_diamonds2.png");
            cardImages.add("../../../Images/king_of_clubs2.png");
            cardImages.add("../../../Images/king_of_hearts2.png");
            cardImages.add("../../../Images/king_of_spades2.png");
            cardImages.add("../../../Images/king_of_diamonds2.png");

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
