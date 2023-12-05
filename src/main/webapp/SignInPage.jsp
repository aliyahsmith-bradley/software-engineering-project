<%@ page import="pokersite.model.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% User logged = (User) session.getAttribute("User"); %>

<!DOCTYPE html>
<html style="height:100%;">
<link href="css/signinpage.css" rel="stylesheet" type="text/css">
<head>
    <title>JSP - Sign In Page</title>
</head>
<body>
<div>
    <% if(logged != null) { %>
    <h3>You are logged in! Welcome <%=logged.getUsername()%></h3>

    <h3>Want to log out?</h3>
    <form method="post" action="logoutUser">
        <input type="submit" value="Logout!">
    </form>
    <% if(logged.getPermission() == 1) { %>
        <h1>Welcome Administrator</h1>
        <a href="admin.jsp">
            <button>Admin Page</button>
        </a>
    <% } %>
<% } %>
</div>
<div>
    <h3>Found a bug? Report here!</h3>
    <button onclick="location.href = 'ReportBug.jsp'">Report Bug</button>
</div>

<h1>Feeling Lucky?</h1>
<div class="red-rectangle"></div>

<% if(logged == null) { %>
<button onclick="showPopUp()" class="account_button2"></button>
<div id="popup" class="guest_message">
    <span class="close" onclick="hidePopUp()">&times;</span>
    <p>Please sign in or create an account to view your profile.</p>
</div>

<script>
    function showPopUp() {
        document.getElementById("popup").style.display = "block";
    }

    function hidePopUp() {
        document.getElementById("popup").style.display = "none";
    }
</script>
<% } else { %>
<button onclick="viewAccount()" class="account_button2"></button>

<script>
    function viewAccount() {
        window.location.href = "UserProfile.jsp"
    }
</script>
<% } %>

<a href="index.jsp" class="home_button"></a>

<a href="Rules.jsp" class="book_button"></a>

<a href="SignUp.jsp" class="button-link-1">
    <span class="button-text">Make An</span>
    <br>
    <span class="button-text">Account</span>
</a>

<a href="Login.jsp" class="button-link-2">
    <span class="button-text">Sign In</span>
</a>

<a href="TableGame.jsp" class="button-link-3">
    <span class="button-text">Play as</span>
    <br>
    <span class="button-text">Guest</span>
</a>

<div class="green-chip"></div>
<div class="black-chip"></div>
<div class="blue-chip"></div>

</body>
</html>