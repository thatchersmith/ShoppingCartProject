<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" href="Scripts/css/bootstrap.min.css"></link>
</head>
<body>
	<form action="register" method="POST">
		<h1>Log In</h1>
		<input type=text name=uName required>
		<br>
		<input type=password name=password required>
		<br>
		<input type=text name=fName required>
		<br>
		<input type=text name=lName required>
		<br>
		<input type=text name=street required>
		<br>
		<input type=text name=zipcode required>
		<br>
		<input type=text name=state required>
		<br>
		<input type=submit name=submit value="Login">
		<br>
	</form>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Scripts/jquery-1.11.x.min.js"></script>
<script src="Scripts/js/bootstrap.min.js"></script>
</body>
</html>