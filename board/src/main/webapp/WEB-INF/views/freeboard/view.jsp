<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<form:form  class="form-horizontal"  modelAttribute="freeboard" >
		   <fieldset>
				<legend>등록글 확인</legend>		
							
				 			

				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="name">성명</label>
					<div class="col-sm-3">
					<form:input  path="name" class="form-control"   readonly="true" value="${freeboard.name}"/>
										
					</div>		
					
				</div>
				

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="subject">제목</label>
					<div class="col-sm-5">
					<form:input  path="subject" class="form-control"  readonly="true" value="${freeboard.subject}"/>
					
					
				 	</div>
				</div>

				
			
				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="content">내용</label>
					<div class="col-sm-8" style="word-break: break-all;">	
					<form:textarea path="content" class="form-control"   cols="50" rows = "5" readonly="true"  value="${freeboard.content}"/>
					
					
					</div>		
				</div>
				
				
				<div class="form-group row">
					 <div class="col-sm-offset-2 col-sm-10 " >
										
			
				<p><a href="<c:url value="/freeboard/confirm?category=1&num=${freeboard.num}&page=${page}" />" class="btn btn-danger"> 삭제</a>
				 <a href="<c:url value="/freeboard/confirm?category=2&num=${freeboard.num}&page=${page}" />" class="btn btn-success"> 수정</a> 
			
				<a href="<c:url value="/freeboard/list?page=${page}" />" class="btn btn-primary"> 목록</a></p>	
			
					</div>
				</div>
				
			</fieldset>
		</form:form>
		
		
	</div>
