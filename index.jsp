<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<div class="settings">
</div>

<head>
    <div class="topnav">
        <! possible sound background: https://pixabay.com/sound-effects/poker-room-33521/ >
        <div class="money-box">
            $500,000
        </div>
    </div>
    <meta charset="UTF-8">
    <title>Five Card Draw</title>
    <link rel="stylesheet" href="style.css">
    <script src="main_table.js" defer></script>

</head>

<body>
<main>
    <img class="table-picture" src="images/table3.png">
    <div class="card-container">
        <div class="c-pos-1">

        </div>
        <div class="c-pos-2">

        </div>
        <div class="c-pos-3">

        </div>
        <div class="c-pos-4">

        </div>
        <div class="c-pos-5">

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
</body>
</html>