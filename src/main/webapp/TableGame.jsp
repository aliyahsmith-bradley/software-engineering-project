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
        <div class="c-pos-1"></div>
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
    </div>
</main>
</body>
</html>