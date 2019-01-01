<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>도서상세정보</title>
</head>
<body>


	<div class="container">
		<div class="row">

			<div class="col-md-4">
				<img src="<c:url value="c:/upload/${book.fileName}"></c:url>"
					alt="image" style="width: 90%" />
			</div>
			<div class="col-md-7">

				<form:form modelAttribute="updateBook" class="form-horizontal"
					action="./update?${_csrf.parameterName}=${_csrf.token}"
					enctype="multipart/form-data">
					<fieldset>
						<div class="form-group row">
							<label class="col-sm-2 control-label" for="bookId"> 도서ID</label>
							<div class="col-sm-6">
								<form:input path="bookId" type="trxt" class="form-control"
									value="${book.bookId}" readonly="true"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="name">도서명</label>
							<div class="col-sm-6">
								<form:input path="name" type="text" class="form-control"
									value="${book.name}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="unitPrice">가격</label>
							<div class="col-sm-6">
								<form:input path="unitPrice" type="text" class="form-control"
									value="${book.unitPrice}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="author">저자</label>
							<div class="col-sm-6">
								<form:input path="author" type="text" class="form-control"
									value="${book.author}" />
							</div>
						</div>


						<div class="form-group row">
							<label class="col-sm-2 control-label" for="description">상세정보</label>
							<div class="col-sm-10">
								<textarea name="description" path="description" cols="50"
									rows="2" class="form-control">${book.description}</textarea>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="publisher">출판사</label>
							<div class="col-sm-6">
								<form:input path="publisher" type="text" class="form-control"
									value="${book.publisher}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="category">분류</label>
							<div class="col-sm-6">
								<form:input path="category" type="text" class="form-control"
									value="${book.category}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="unitsInStock">재고수</label>
							<div class="col-sm-6">
								<form:input path="unitsInStock" type="text" class="form-control"
									value="${book.unitsInStock}" />
							</div>
						</div>



						<div class="form-group row">
							<label class="col-sm-2 control-label" for="releaseDate">출판일</label>
							<div class="col-sm-6">
								<form:input path="releaseDate" type="text" class="form-control"
									value="${book.releaseDate}" />
							</div>
						</div>


						<div class="form-group row">
							<label class="col-sm-2 control-label" for="condition">상태</label>
							<div class="col-sm-6">
								<form:radiobutton path="condition" value="New" />
								New
								<form:radiobutton path="condition" value="Old" />
								Old
								<form:radiobutton path="condition" value="E-Book" />
								E-Book
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label" for="bookImage">
								이미지 </label>
							<div class="col-sm-10">
								<form:input path="bookImage" type="file" class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-10 ">
								<input type="submit" class="btn btn-success " value="수정 " /> <a
									href="<c:url value="/books" />" class="btn btn-secondary"
									role="button"> 취소</a>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
</div>

		</div>
</body>
</html>