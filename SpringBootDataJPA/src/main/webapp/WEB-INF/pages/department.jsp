<%@page import="com.cov.beans.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.cov.beans.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All department page</title>
</head>
<body>
<h2>Department Details</h2>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Edit</th>
</tr>
<%
List<Department> deps = (List<Department>) request.getAttribute("deps");
for (Department dep : deps) {
%>
<tr>
<td><%=dep.getId()%></td>
<td><%=dep.getName()%></td>
<td><a href="getDep">Edit</a>
</tr>
<%
}
%>
</table>
<br>
<a href="/">Home</a>
</body>
</html>