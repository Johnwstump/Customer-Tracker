<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		</security:authorize>
		<form:form action="search" method="POST">
			Search Customer: <input type="text" name="searchName" />
			<input type="submit" value="Search" class="add-button"/>
		</form:form>
		<br>
		<table>
			<tr>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Email</th>
				<th> Action</th>
			</tr>
			
			<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<tr>		
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td> <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')"> <a href="${updateLink}"> Update </a> </security:authorize>
					<security:authorize access="hasAnyRole('ADMIN')">|  <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"> Delete </a> </security:authorize> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<!-- Logout Button -->	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</div>

</body>
</html>