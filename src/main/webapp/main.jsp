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
    <p>
      <input name="name" value="${income.name}" placeholder="Name">
      <input name="description" value="${income.description}" placeholder="Description">
      <input name="currency" value="${income.currency}" placeholder="Currency">
      <input name="amount" value="${income.amount}" placeholder="Amount">
      <button onclick="updateIncome('${income.id}', '${income.name}', '${income.description}', '${income.currency}', '${income.amount}')">Update</button>
    </p>
  </c:forEach>
</ul>
<h3>Add new</h3>
<form method="post" action="incomes">
  <input name="name" placeholder="Name">
  <input name="description" placeholder="Description">
  <input name="currency" placeholder="Currency">
  <input name="amount" placeholder="Amount">
  <button>Add</button>
</form>
<h1>Outcomes:</h1>
<ul>
  <h3>High importance</h3>
  <c:forEach items="${outcomes}" var="item">
    <c:if test="${item.importance eq 'HIGH'}">
      <c:set var="outcome" value="${item}" scope="request"/>
      <jsp:include page="include/outcome.jsp"/>
    </c:if>
  </c:forEach>
  <h3>Normal importance</h3>
  <c:forEach items="${outcomes}" var="item">
    <c:if test="${item.importance eq 'NORMAL'}">
      <c:set var="outcome" value="${item}" scope="request"/>
      <jsp:include page="include/outcome.jsp"/>
    </c:if>
  </c:forEach>
  <h3>Low importance</h3>
  <c:forEach items="${outcomes}" var="item">
    <c:if test="${item.importance eq 'LOW'}">
      <c:set var="outcome" value="${item}" scope="request"/>
      <jsp:include page="include/outcome.jsp"/>
    </c:if>
  </c:forEach>
</ul>
<h3>Add new</h3>
<form method="post" action="outcomes">
  <input name="name" placeholder="Name">
  <input name="description" placeholder="Description">
  <input name="currency" placeholder="Currency">
  <input name="importance" placeholder="Importance">
  <input name="amount" placeholder="Amount">
  <button>Add</button>
</form>
</body>

<script>
  function updateIncome(id, name, description, currency, amount) {
    var request = new XMLHttpRequest();
    request.open("PUT", "incomesUpdate");
    request.setRequestHeader("Content-Type", "application/json");

    var data = {
      id: id,
      name: name,
      description: description,
      currency: currency,
      amount: amount
    }

    request.onreadystatechange = function (){
      if(this.readyState === XMLHttpRequest.DONE){
        console.log(this.readyState);
      }
    }
    request.send(JSON.stringify(data));
  }
</script>
</html>
