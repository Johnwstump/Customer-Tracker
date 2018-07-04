<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id = "container">
		<h3>Save Customer</h3>
		<form:form action="saveOrderItem" modelAttribute="orderItem" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Item: </label> </td>
						<td> <form:select path="item">
							<c:forEach var="tempItem" items="${items}">
								<form:option value="${tempItem.id}">${tempItem.name} - ${tempItem.price}</form:option>
							</c:forEach>
						</form:select></td>
					</tr>
					
					<tr>
						<td><label>Quantity: </label> </td>
						<td> <form:input path="quantity" /> </td>
					</tr>
					
					<tr>
						<td><label></label> </td>
						<td> <input type="submit" value="Save" class="save"/> </td>
					</tr>
				
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"> </div>
		<p>
			<a href="${pageContext.request.contextPath}/order/orderForm">Back to List</a>
		</p>
	</div>
</body>
</html>