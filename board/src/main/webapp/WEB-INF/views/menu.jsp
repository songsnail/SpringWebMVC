<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<nav class="navbar navbar-expand  navbar-dark bg-dark">
      <div class="container">
        <div class="navbar-header">   
         <c:choose>
        <c:when test="${empty sessionScope.userLoginInfo}">   
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
          </c:when>
          	<c:otherwise>
          
          <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
      	</c:otherwise>
				</c:choose>    
        </div>
        <div>
        	  <ul class="navbar-nav mr-auto ">
        	 <c:choose>
 					<c:when test="${empty sessionScope.userLoginInfo}">  					
 					 <li class="nav-item"><a href="<c:url value="/login"/>" class="nav-link"> 로그인 </a></li> 					 
 					 <li class="nav-item"><a href='<c:url value="/members/add"/>' class="nav-link" > 회원가입</a>			      
 					 </c:when>
					<c:otherwise>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li class="nav-item"> <a href="<c:url value="/logout"/>"  class="nav-link">${sessionScope.userLoginInfo.name}님 </a></li>	
															
						<li class="nav-item"><a href='<c:url value="/members/update?id="/>${sessionScope.userLoginInfo.id}' class="nav-link"> 회원수정</a>
						</sec:authorize>
						 	<sec:authorize access="hasRole('ROLE_ADMIN')">			 
 					 <li class="nav-item"><a href='<c:url value="/members"/>'>회원목록</a>
 					  </sec:authorize>
				  
					</c:otherwise>
				</c:choose>    
			
			<li class="nav-item"><a href="<c:url value="/freeboard/list?page=1"/>" class="nav-link">자유게시판</a></li>
			
          </ul>
       </div>      
    </div>         
</nav>
  