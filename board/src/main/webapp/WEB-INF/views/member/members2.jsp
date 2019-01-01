<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.css">
<title>회원 목록</title>
<script>
function clearCart(id) {
   document.clearForm.submit();
 //  location.reload();
}
function removeMember( action) {

   document.removeForm.action = action;
   var con_test = confirm("삭제합니다");
    if(con_test) document.removeForm.submit();
   	else return;
  // location.reload();
}
</script>
</head>
<body>	
     	
       <div class="table" style="padding-top: 20px; align:center">
            <table class="table table-striped">
              <thead>
                <tr >
                  <th >순번</th>
                  <th >ID</th>
                  <th >성명</th>
                  <th >주소</th>                  
                  <th>상세정보</th>
                </tr>
              </thead>
              <tbody>  
            <form:form  name="removeForm"  method="delete">    
			<c:set var="i" value="0"/>
			<c:forEach items="${members}" var="member">
			 <tr>
				<td >${i=i+1}</td>
				<td >${member.id}</td>
				<td >${member.name}</td>
                <td >${member.address}</td>                
                <td >
				<a href="<spring:url value="/members/member?id=${member.id}" /> " class="btn btn-sm btn-default" role="button"> 상세정보 &raquo;</a>
				
         			<a  href="javascript:removeMember('./members/delete/${member.id}')" class="btn btn-sm btn-danger" type="button" >삭제하기</a>      			
						<a  href="<spring:url value="./members/update?id=${member.id}" /> " class="btn  btn-sm  btn-success type="button" >수정하기</a>      			
			
				</td>			             
				</tr>		
					
				</div>
			</c:forEach>
			</form:form >
			 </tbody>
			 </table>
		</div>
	  
</html>
