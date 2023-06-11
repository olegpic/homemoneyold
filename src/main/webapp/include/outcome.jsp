<%--
  Renders one row of outcomes in the outcomes section
--%>
<form method="post" action="outcomesUpdate">
  <input name="id" value="${outcome.id}" type="hidden">
  <input name="name" value="${outcome.name}" placeholder="Name">
  <input name="description" value="${outcome.description}" placeholder="Description">
  <input name="currency" value="${outcome.currency}" placeholder="Currency">
  <input name="importance" value="${outcome.importance}" placeholder="Importance">
  <input name="amount" value="${outcome.amount}" placeholder="Amount">
  <button>Update</button>
</form>