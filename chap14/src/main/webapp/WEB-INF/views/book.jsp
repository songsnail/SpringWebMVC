<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/controllers.js"/>" ></script>
<title>도서 상세 정보</title>
</head>
<body>
	<nav class="navbar navbar-expand  navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="../">Home</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img src="<c:url value="/resources/images/${book.bookId}.png"/>"
					alt="image" style="width: 100%" />
			</div>
			<div class="col-md-7">
				<h3>${book.name}</h3>
				<p>${book.description}
					<br> &raquo;<p>
					<strong>도서코드 : </strong><span class="label label-info">${book.bookId}</span><p>
	
								<strong>저자</strong> : ${book.author}
				
				<p>
					<strong>출판사</strong> : ${book.publisher}
				
				<p>
					<strong>출판일</strong> : ${book.releaseDate}
				
				<p>
					<strong>분류</strong> : ${book.category}
				
				<p>
					<strong>재고수</strong> : ${book.unitsInStock}
				
				<h4>${book.unitPrice}원</h4>
				<br>
				<p>
				<form:form  name="addForm"  id="addForm"  method="put">	
			   		<a href="javascript:addToCart('${book.bookId}')"  class="btn btn-primary"> 도서주문 &raquo;</a> 
			   		<a href="<c:url value="/cart" />" class="btn btn-warning"> 장바구니 &raquo;</a> 
					<a href="<c:url value="/books" />" class="btn btn-secondary"> 도서목록 &raquo;</a>
				</form:form>
				
				
			</div>
		</div>
		<hr>

		<footer>
			<p>&copy; BookMarket</p>
		</footer>
	</div>

</body>
</html>
