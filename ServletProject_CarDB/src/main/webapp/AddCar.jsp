<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter the Car details</h1>
	
	<form action="add-car" method="post">
		<input type="number" placeholder="Enter the carId" name="carId"> <br>
		<input type="text" placeholder="Enter the carModel" name="carModel"> <br>
		<input type="text" placeholder="Enter the carBrand" name="carBrand"> <br>
		<input type="text" placeholder="Enter the carColor" name="carColor"> <br>
		<input type="number" placeholder="Enter the carprice" name="carPrice"> <br>
		<input type="submit" value="add">
		
	</form>

</body>
</html>