<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Register Page</title>
<link rel="stylesheet" href="Scripts/css/bootstrap.min.css"></link>
</head>
<body>
<!-- Header -->
<div>
	<h1 class="page-header">Product Shopper</h1>
</div>
<!-- Body -->
<div>
	<div class="panel panel-default">
	 	<div class="panel-body">
		  	<form class="navbar-form navbar-left" id=loginForm action=login method=post>
			<h1>Log In</h1>
			<input type=text name=uName placeholder=username required>
			<br>
			<input type=password name=password placeholder=password required>
			<br>
			<input type=submit name=submit value="Login">
			<br>
			</form>
			<div class="navbar-right">
				<a href="registerForm.jsp">Register</a>
			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Scripts/jquery-1.11.x.min.js"></script>
<script src="Scripts/js/bootstrap.min.js"></script>
</body>
</html>