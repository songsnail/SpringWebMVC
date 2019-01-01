<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title><spring:message code="addBook.form.title.label" /></title>
</head>
<body>
	<div class="container">
		<div class="float-right">
			<a href="?language=ko">Korean</a>|<a href="?language=en">Engish</a>&nbsp;
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST" class="float-right">
				<input type="submit" class="btn btn-sm btn-success" value="Logout" />
			</form:form>
		</div>
		<br>
		<br>
		<form:form modelAttribute="newBook" class="form-horizontal"
			action="./add?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="bookId"><spring:message
						code="addBook.form.bookId.label" /></label>
				<div class="col-sm-3">
					<form:input path="bookId" class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="bookId" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="name"> <spring:message
						code="addBook.form.name.label" /></label>
				<div class="col-sm-3">
					<form:input path="name" class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="unitPrice"><spring:message
						code="addBook.form.unitPrice.label" /></label>
				<div class="col-sm-3">
					<form:input path="unitPrice" type="text" class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="unitPrice" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="author"><spring:message
						code="addBook.form.author.label" /></label>
				<div class="col-sm-3">
					<form:input path="author" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="description"><spring:message
						code="addBook.form.description.label" /></label>
				<div class="col-sm-5">
					<form:textarea path="description" cols="50" rows="2"
						class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="publisher"><spring:message
						code="addBook.form.publisher.label" /></label>
				<div class="col-sm-3">
					<form:input path="publisher" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="category"><spring:message
						code="addBook.form.category.label" /></label>
				<div class="col-sm-3">
					<form:input path="category" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="unitsInStock">재고수</label>
				<div class="col-sm-3">
					<form:input path="unitsInStock" type="text" class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="unitsInStock" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" for="releaseDate"> <spring:message
						code="addBook.form.releaseDate.label" /></label>
				<div class="col-sm-3">
					<form:input path="releaseDate" type="text" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 control-label" for="condition"><spring:message
						code="addBook.form.condition.label" /></label>
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
				<label class="col-sm-2 control-label" for="bookImage"> <spring:message
						code="addBook.form.bookImage.label" /></label>
				<div class="col-sm-7">
					<form:input path="bookImage" type="file" class=" form-control" />
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" id="btnAdd" class="btn btn-primary "
						value="<spring:message code="addBook.form.button.label"/>" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
