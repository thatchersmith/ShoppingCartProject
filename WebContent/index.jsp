<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Register Page</title>
<link rel="stylesheet" href="../style.css"></link>
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
	 	<div class="panel-body" style="background-color:#DBECF9; margin:0 auto; text-align:center; width:350px; box-shadow:0px 0px 2px 0px grey;">
		  	<form class="navbar-form" id=loginForm action=login method=post>
			<h1>Log In</h1>
			<div class="input-group">
				<span class="input-group-addon">Username:</span>
				<input class="form-control" type=text name=uName required>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Password:</span>
				<input class="form-control" type=password name=password required>
			</div>
			</br>
			<br>
			<button type="submit" class="btn btn-default">Submit</button>
			</br>
			<br>
			</form>
			<div>
				<h3><a href="registerForm.jsp">Register</a></h3>
			</div>
		</div>
	</div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Scripts/jquery-1.11.x.min.js"></script>
<script src="Scripts/js/bootstrap.min.js"></script>
</body>
</html>