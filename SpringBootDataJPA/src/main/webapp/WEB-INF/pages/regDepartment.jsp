<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="icon"
	href="https://www.freepnglogos.com/uploads/youtube-play-red-logo-png-transparent-background-6.png">
<meta charset="ISO-8859-1">
<title>Department Registration</title>
</head>
<body>
	<h2>Department Registration</h2>
	<form:form action="regdept" method="post" modelAttribute="department">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<input type="submit" value="Register"><br><br>
	</form:form>
	<a href="getDepts">List of all Department</a><br><br>
	<a href="/">Back</a>
</body>
</html>