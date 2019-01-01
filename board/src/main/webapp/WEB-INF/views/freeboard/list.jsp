<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../commons/init.jsp" %>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>게시판</title>
<script>

   function Check_Login(name)
   {
	 	
	  if (name==""){
	
	   
               window.alert('로그인 후 글쓰기를 하셔야 합니다.')
              
	  
     
      exit;
      }
	  else window.location.assign("${pageContext.request.contextPath}/freeboard/add?num=-1&page=${page}");
   }
</script>

</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">자유게시판</h1>
		</div>
	</div>	
<div class="container" >
	<div>
	    <h5><span class="label label-info float-right"> 전체 ${total_record }건 	</span></h5>
	</div> 
		
	<div style="padding-top: 50px">
		<table class="table table-hover">
			
			<tr align=center>
				<th >번호</th>
					<th>제목</th>
					<th >작성일</th>
					<th>조회</th>
					<th>글쓴이</th>
				</tr>
				
					
				<c:forEach items="${freeboards}" var="freeboard" begin="${start}" end="${end}" >
				<tr>
					<td>${(total_record-start)-i}</td> 
					<td  ><a href="<c:url value="./view?num=${freeboard.num}&page=${page}"/>" >${freeboard.subject}</a></td>
					<td>${freeboard.regist_day}</td>
					<td >${freeboard.hit}</td>
					<td  >${freeboard.name}</td>			
				</tr>
				<c:set var="i" value="${i+1}" />
					</c:forEach>
				
			</table>
		</div>	
	
<%@ include file="../commons/pagelist.jsp" %>		
<%@ include file="../commons/search.jsp" %>
<div  >
<a href="javascript:Check_Login('${sessionScope.userLoginInfo.name}');" class="btn btn-primary float-right" >&laquo; 글쓰기</a> 
</div>
<br><br>
		
	<%@ include file="../footer.jsp" %>

</div>	