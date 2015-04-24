<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Product> products = new ArrayList<Product>();
	session.getAttribute("products");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Products to Purchase</title>
<link rel="stylesheet" href="Scripts/css/bootstrap.min.css"></link>
</head>
<body>
	<!-- Title -->
	<div>
	</div>
	<!-- Body -->
	<div>
	</div>
	<!-- Footer -->
	<div>
	</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Scripts/jquery-1.11.x.min.js"></script>
<script src="Scripts/js/bootstrap.min.js"></script>
</body>
</html>