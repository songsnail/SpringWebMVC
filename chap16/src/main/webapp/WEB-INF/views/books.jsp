<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>도서 목록</title>
</head>
<body>	
	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${books}" var="book">
				<div class="col-md-4">
					<img src="<c:url value="/resources/images/${book.bookId}.png"/>" alt="image" style = "width:70%"/>
					<h3>${book.name}</h3>
					<p>${book.author}
						<br> ${book.publisher} | ${book.releaseDate}
					<p align=left>${fn:substring(book.description, 0, 100)}...
					<p>${book.unitPrice}원
					<p>
						<a href="./books/book?id=${book.bookId}" class="btn btn-secondary"
							role="button">상세 정보 &raquo; </a>
				</div>
			</c:forEach>
		</div>		
	</div>
</html>
