<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% ResultSet rs=(ResultSet) request.getAttribute("carList"); %>

	<h1>Car List</h1>

	<table border="1">
		<tr>
			<th>Car ID</th>
			<th>Car Model</th>
			<th>Car Brand</th>
			<th>Car Color</th>
			<th>Car Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% while(rs.next()){
			
			
		%>
		<tr>
			<td><%= rs.getInt(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<td><%= rs.getInt(5) %></td>
			<td><a href="find-car-by-id?carId=<%= rs.getInt(1) %>">Update</a></td>
			<td><a href="delete-car-by-id?carId=<%= rs.getInt(1) %>">Delete</a></td>


		</tr>


		<%
		    }	
		%>


	</table>
	<br>
	<br>
	<a href="index.jsp"> go to the dash-board</a>

</body>
</html>