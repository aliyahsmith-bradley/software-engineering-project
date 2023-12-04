<%--
  Created by IntelliJ IDEA.
  User: aliya
  Date: 12/4/2023
  Time: 2:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Save Credit Card Information</title>
    <!-- Add the following JavaScript code for redirection -->
    <script>
        function redirectToPurchasePage() {
            window.location.href = "/software-engineering-project/purchase.jsp";
        }
    </script>
</head>
<body>
<h1>Enter Credit Card Information</h1>
<form action="SaveCreditCardServlet" method="post" onsubmit="redirectToPurchasePage()">
    <label for="cardNumber">Card Number:</label>
    <input type="text" id="cardNumber" name="cardNumber" required><br>
    <label for="expirationDate">Expiration Date (MM/YY):</label>
    <input type="text" id="expirationDate" name="expirationDate" required><br>
    <label for="cvv">CVV:</label>
    <input type="text" id="cvv" name="cvv" required><br>
    <button type="submit">Save Credit Card</button>
</form>
</body>
</html>



