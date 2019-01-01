<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>게시판</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">자유게시판</h1>
		</div>
	</div>	
	<div class="container">

		<form:form  class="form-horizontal" modelAttribute="freeboard" action="./update?${_csrf.parameterName}=${_csrf.token}" >
			<fieldset>
			
				
		
				<legend>수정</legend>
				
					<form:hidden path="num" class="form:input-large" value="${freeboard.num}"/>			

				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="name">성명</label>
					<div class="col-sm-3">
					<form:input path="name" class="form-control"  readonly="true" value="${freeboard.name}"/>
					</div>	
					<div class="col-sm-4">	
					<form:errors path="name" cssClass="text-danger"/>				
					</div>		
					
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="passwd">비밀번호</label>
					<div class="col-sm-3">
					<form:password  path="passwd" class="form-control" value="${freeboard.passwd}"/>	
					</div>	
					<div class="col-sm-4">	
					<form:errors path="passwd" cssClass="text-danger"/>				
					</div>		
					
				</div>

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="subject">제목</label>
					<div class="col-sm-5">
					<form:input path="subject" class="form-control"  value="${freeboard.subject}"/>
					</div>	
					<div class="col-sm-4">	
					<form:errors path="subject" cssClass="text-danger"/>
				 	</div>
				</div>

				
			
				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="content">내용</label>
					<div class="col-sm-8">	
						<form:textarea path="content" cols="50" rows = "5" class="form-control" value="${freeboard.content}"/>
					
					</div>		
				</div>
				
				
				<div class="form-group row">
					 <div class="col-sm-offset-2 col-sm-10 " >
						<input type="submit" class="btn btn-success " value ="수정 "/>  
						<a href=" <c:url value="/freeboard/view?num=${freeboard.num}&page=${page}" />"  class="btn btn-secondary" role="button"> 취소</a>
					</div>
				</div>
				
			</fieldset>
		</form:form>
			
	
 
	</div>
	
