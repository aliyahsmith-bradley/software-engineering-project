<%--
  Created by IntelliJ IDEA.
  User: Brend
  Date: 11/28/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Bugs</title>
</head>
<body>
<div>
  <h1>Report Issue</h1>
  <form method="post" action="reportIssue">
    Title: <input type="text" name="title"><br>
    Description: <input type="text" name="description"><br>
    <input type="submit" value="report">
  </form>
</div>
</body>
</html>
