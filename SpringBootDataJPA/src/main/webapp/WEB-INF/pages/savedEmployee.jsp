<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Saved Employee</title>
</head>
<body bgcolor="AAA492">
<h2>Employee Details</h2>
Id:${ employee.id }
<br>
<br>
Name:${ employee.name }
<br>
Department:${employee.department}
<br>
<br>
<a href="/">Home</a>
<a href="getEmps"><button>ShowAllEmployee</button></a>
</body>
</html>