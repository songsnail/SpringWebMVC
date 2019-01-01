﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>도서 등록</title>
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
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>
	<div class="container">
		<div class="float-right">			
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" class="btn btn-sm btn-success" value="Logout" />
			</form:form>
		</div>
		<br>
		<br>
		<form:form modelAttribute="newBook" class="form-horizontal">
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="bookId">도서코드</label>
				<div class="col-sm-3">
					<form:input path="bookId" class="form-control" />
				</div>
				<div class="col-sm-5" align="right"></div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="name">도서명</label>
				<div class="col-sm-3">
					<form:input path="name" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="unitPrice">가격</label>
				<div class="col-sm-3">
					<form:input path="unitPrice" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="author">저자</label>
				<div class="col-sm-3">
					<form:input path="author" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="description">상세정보</label>
				<div class="col-sm-5">
					<form:textarea path="description" cols="50" rows="2"
						class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="publisher">출판사</label>
				<div class="col-sm-3">
					<form:input path="publisher" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="category">분류</label>
				<div class="col-sm-3">
					<form:input path="category" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="unitsInStock">재고수</label>
				<div class="col-sm-3">
					<form:input path="unitsInStock" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="releaseDate">출판일</label>
				<div class="col-sm-3">
					<form:input path="releaseDate" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="condition">상태</label>
				<div class="col-sm-3">
					<form:radiobutton path="condition" value="New" />
					New
					<form:radiobutton path="condition" value="Old" />
					Old
					<form:radiobutton path="condition" value="E-Book" />
					E-Book
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" id="btnAdd" class="btn btn-primary "
						value="등록 " />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
