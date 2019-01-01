<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
<div class="container" align="center">
  		 <div class="col-md-4">       
        	<h3 class="form-signin-heading">Please sign in</h3>
        	<c:if test="${not empty error}">
				<div class="alert alert-danger">
                      Username 또는 Password가 올바르지 않습니다.
                  </div>
			</c:if>
        	<form class="form-signin" action="<c:url value='login'/>" 	method="post">
       			<fieldset>
			    	<div class="form-group">
        			<label for="inputUserName" class="sr-only" >User Name</label>
        			<input type="text"  class="form-control" placeholder="User Name"  name='username' required autofocus>
        			</div>
        			<div class="form-group">
       				<label for="inputPassword" class="sr-only">Password</label>
        			<input type="password"  class="form-control" placeholder="Password" name='password' required>
       				</div>      
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
       				 <button class="btn btn btn-lg btn-success btn-block" type="submit">로그인</button>
       		 	</fieldset>
       		 	
      		</form>
			</div>
    	</div>	
