<%--
  Created by IntelliJ IDEA.
  User: Aleh_Yemelyanchyk
  Date: 5/9/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>Incomes:</h1>
<ul>
  <c:forEach items="${incomes}" var="income">
    <form method="post" action="incomesUpdate">
      <input name="id" value="${income.id}" type="hidden">
      <input name="name" value="${income.name}" placeholder="Name">
      <input name="description" value="${income.description}" placeholder="Description">
      <input name="currency" value="${income.currency}" placeholder="Currency">
      <input name="amount" value="${income.amount}" placeholder="Amount">
      <button>Update</button>
    </form>
  </c:forEach>
</ul>
<form method="post" action="incomes">
  <input name="name" placeholder="Name">
  <input name="description" placeholder="Description">
  <input name="currency" placeholder="Currency">
  <input name="amount" placeholder="Amount">
  <button>Add</button>
</form>
<h1>Outcomes:</h1>
<ul>
  <c:forEach items="${outcomes}" var="outcome">
    <form method="post" action="outcomesUpdate">
      <input name="id" value="${outcome.id}" type="hidden">
      <input name="name" value="${outcome.name}" placeholder="Name">
      <input name="description" value="${outcome.description}" placeholder="Description">
      <input name="currency" value="${outcome.currency}" placeholder="Currency">
      <input name="importance" value="${outcome.importance}" placeholder="Importance">
      <input name="amount" value="${outcome.amount}" placeholder="Amount">
      <button>Update</button>
    </form>
  </c:forEach>
</ul>
<form method="post" action="outcomes">
  <input name="name" placeholder="Name">
  <input name="description" placeholder="Description">
  <input name="currency" placeholder="Currency">
  <input name="importance" placeholder="Importance">
  <input name="amount" placeholder="Amount">
  <button>Add</button>
</form>
</body>
</html>
