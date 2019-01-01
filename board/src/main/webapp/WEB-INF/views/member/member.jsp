<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.css">
<title>회원상세정보</title>
</head>
<body>


	<div class="container">
		<div class="row">
		<div class="col-md-3"   >
	        <img src="<c:url value="c:/upload/${member.filename}"></c:url>" alt="image"  style = "width:90%"/>
         </div>
			<div class="col-md-4">
				<h3>${member.name}</h3>
				<p>
					<strong>아이디 : </strong><span class="label label-info">${member.id}</span>
				</p>					
				<p>
					<strong>성별</strong> : ${member.sex}
				</p>
			
				<p>
					<strong>연락처</strong> : ${member.tel}
				</p>
					<p>
					<strong>주소</strong> : ${member.address}
				</p>
				<p>
					<a href="<spring:url value="/members" />" class="btn btn-primary"> 회원목록 &raquo;
					</a>
  
				</p>

			</div>
		</div>
		
	</div>
					
</body>
</html>
