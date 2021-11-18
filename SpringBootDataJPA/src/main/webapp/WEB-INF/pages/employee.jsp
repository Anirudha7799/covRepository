<%@page import="com.cov.beans.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REgistration Page</title>
</head>
<body>
	<form:form action="regemp" method="post" modelAttribute="employee">
		<!-- <form:label path="id">ID</form:label>
<form:input path="id" />
<br>
<br> -->
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<form:label path="department">Department</form:label>
		<label for="Departments">Choose a Department</label>
		<select name="departments" id="departments">
			<option value="1">java</option>
			<option value="2">c</option>
		</select>
		<br>
		<br>
		<input type="submit" value="Register">
	</form:form>
	<h2>Employee Details</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DeptNo</th>
			<th>Edit|Delete</th>
		</tr>
		<%
		List<Employee> emps = (List<Employee>) request.getAttribute("emps");
		for (Employee emp : emps) {
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getDepartment()%></td>
			<td><a href="editEmp?id=<%=emp.getId()%>">Edit</a> <a
				href="deleteEmp?id=<%=emp.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="/">Home</a>
</body>
</html>