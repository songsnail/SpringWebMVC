<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
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
					<br>
				<p>
					<strong>도서코드 : </strong><span class="label label-info">${book.bookId}</span>
				<p>
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
					<a href="#" class="btn btn-primary">도서 주문 &raquo;</a> <a
						href="../books" class="btn btn-secondary"> 도서 목록 &raquo;</a>
			</div>
		</div>
		<hr>

		<footer>
			<p>&copy; BookMarket</p>
		</footer>
	</div>

</body>
</html>
