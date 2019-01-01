<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>Invalid cart </title>
</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
    	<div class="navbar-header">        
        	<a class="navbar-brand" href="../home">Home</a>
    	</div>
    </div>         
</nav>
<div class="jumbotron">
	<div class="container"  style="padding-top: 30px">
		<h1 class="alert alert-danger">주문이 취소되었습니다.</h1>
		<p>Your Check out process cancelled! you may continue shopping..</p>
	</div>
</div>
<div class="container">
	<p><a href="<c:url value="/books" />" class="btn btn-primary"><span class="glyphicon-hand-left glyphicon"></span> books</a></p>
</div>
</body>
</html>
