<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>로그인</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원 수정</h1>
		</div>
	</div>
	<div class="container">
	
		<form:form  modelAttribute="updateMember" class="form-horizontal"  action="./update?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<fieldset>	

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="id">아이디</label>
					<div class="col-sm-3">
					
						<form:input path="id" type="text" class="form-control"
									value="${member.id}" readonly="true"/>
				
					</div>
									
				</div>

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="passwd">비밀번호</label>
					<div class="col-sm-3">
					<form:password path="passwd" class="form-control" value="${member.passwd}"/>
					</div>
					
				</div>

				
					<div class="form-group row">
					<label class="col-sm-2 control-label" for="name">성명</label>
					<div class="col-sm-3">
					<form:input path="name" class="form-control"  value="${member.name}"/>
					</div>
				
				</div>
				
				
				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="sex">성별</label>
					<div class="col-sm-10">						     
						<form:radiobutton path="sex" value="남"	/> 남							
						<form:radiobutton path="sex" value="여"  /> 여 
					</div>		
				</div>
				
				
				<div class="form-group row">	
					<label class="col-sm-2 control-label" for="tel">전화번호</label>
					<div class="col-sm-3">	
					<form:input  path="tel"  class="form-control"  value="${member.tel}"/>						
					</div>		
				</div>
               
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="address">주소</label>
					<div class="col-sm-5">	
						<form:input path="address"  class="form-control" value="${member.address}"/>					
					</div>		
				</div>		
				
				<div class="form-group row">
					 <div class="col-sm-offset-2 col-sm-10 " >
						<input type="submit"  class="btn btn-primary " value ="수정 "/>
						<input type="reset"  class="btn btn-primary " value ="취소 "/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
		
	
	</div>

