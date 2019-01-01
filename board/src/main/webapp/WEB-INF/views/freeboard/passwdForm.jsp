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
				
	
		<form name="passwd_form" method="post" action="./confirm?${_csrf.parameterName}=${_csrf.token}" >
		
			<fieldset>			
				
				<legend>비밀번호확인</legend>
				<input name="num"   type="hidden"  class="form-control" value="${num}" />		
				<input  name="page"    type="hidden"   class="form-control" value="${page}" />		
			    <input  name="category"    type="hidden"   class="form-control" value="${category}" />		
			    
			
				<div class="form-group row">
				
					<label class="col-sm-2 control-label" for="passwd">비밀번호</label>
					<div class="col-sm-3">
					  <input  name="passwd" type="password" class="form-control" placeholder="passwd" />					
					</div>			
					<div class="col-sm-6" style="color:#cc6666">${freeboard_msg}</div>			
				</div>			
				     		
				
						
				<div class="form-group row">
					 <div class="col-sm-offset-2 col-sm-10 " >
					   <p> <br>
					    <input type="submit"  class="btn btn-primary " value ="확인 "/>
					  <a href="<c:url value="/freeboard/view?num=${num}&page=${page}"/>"  class="btn btn-secondary" role="button" > 취소 </a>		
					</p>
					</div>
				</div>				
			</fieldset>
		</form>
		</div>
		

