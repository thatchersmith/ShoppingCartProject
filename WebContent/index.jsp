<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Register Page</title>
</head>
<body>

<form id=loginForm action=login method=post>
	<h1>Log In</h1>
	<input type=text name=uName placeholder=username required>
	<br>
	<input type=password name=password placeholder=password required>
	<br>
	<input type=submit name=submit value="Login">
	<br>
</form>
<a href="registerForm.jsp">Register</a>

</body>
</html>