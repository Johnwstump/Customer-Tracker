<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css/">
<title>Order Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Create Order</h2>
		</div>
	</div>

	<div id="container">
		<br>
		<div id="content">
			<form:form action="saveOrder" modelAttribute="order" method="POST">
				<!--  Need to associate this data with customer id -->
			Customer:
				<form:select path="customer">
					<c:forEach var="tempCustomer" items="${customers}">
						<form:option value="${tempCustomer.id}">${tempCustomer.firstName} ${tempCustomer.lastName}</form:option>
					</c:forEach>
				</form:select>
				<br>
				<br>

				<table>
					<tbody>
						<tr>
							<th>Name</th>
							<th>Quantity</th>
							<th>Cost</th>
							<th>Action</th>
						</tr>

						<c:forEach var="item" items="${order.items}">
							<tr>
								<td>${item.name}</td>
								<td>${item.quantity}</td>
								<td>${item.cost}</td>
								<td>Edit | Delete</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<br>
				<input type="button" value="Add Item"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
			</form:form>
		</div>
	</div>
</body>