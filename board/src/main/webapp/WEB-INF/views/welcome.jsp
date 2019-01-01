<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>home</title>
</head>
<body>

<%@ include file="menu.jsp" %>
<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">웹 쇼핑몰</h1>
		</div>
	</div>

		<div class="container" style="padding-top: 10px" align="center"><br>
			<h1> ${greeting}</h1>				
		</div>			
	


