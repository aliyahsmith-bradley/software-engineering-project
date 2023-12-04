<%--
  Created by IntelliJ IDEA.
  User: aliya
  Date: 12/3/2023
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>In-App Purchase</title>
    <link rel="stylesheet" type="text/css" href="purchase.css">
</head>
<body>
<h1>Buy More Features</h1>
<a href="creditCard.jsp" class="credit-card-box">Enter Credit Card Information</a>

<div class="purchase-option" id="coinsOption">
    <h2>Buy More Coins</h2>
    <p>Unlock additional coins.</p>
    <form action="PurchaseServlet" method="post">
        <input type="hidden" name="feature" value="coins">
        <button type="submit">Buy Now</button>
    </form>
</div>

<div class="purchase-option" id="soundsOption">
    <h2>Unlock New Sounds</h2>
    <p>Access a variety of new sounds.</p>
    <form action="PurchaseServlet" method="post">
        <input type="hidden" name="feature" value="sounds">
        <button type="submit">Buy Now</button>
    </form>
</div>

<div class="purchase-option" id="backgroundsOption">
    <h2>Unlock New Backgrounds</h2>
    <p>Choose from a selection of new backgrounds.</p>
    <form action="PurchaseServlet" method="post">
        <input type="hidden" name="feature" value="backgrounds">
        <button type="submit">Buy Now</button>
    </form>
</div>

<!-- Display Balance -->
<div class="balance-display">
    <div id="balance">
        <h3>Your Current Balance: $<%= session.getAttribute("balance") == null ? 0.0 : session.getAttribute("balance") %></h3>
    </div>
</div>

<link rel="stylesheet" type="text/css" href="styles.css">
</body>
</html>


