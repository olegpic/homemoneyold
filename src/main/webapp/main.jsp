<%--
  Created by IntelliJ IDEA.
  User: Aleh_Yemelyanchyk
  Date: 5/9/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Incomes:</h1>
<ul>
  ${incomes}
</ul>
  <form method="post" action="\incomes">
    <input name="name">
    <button>Add</button>
  </form>

<h1>Outcomes:</h1>
<ul>
  <li>${outcomes}</li>
</ul>
<form method="post" action="\outcomes">
  <button>Add</button>
</form>
</body>
</html>
