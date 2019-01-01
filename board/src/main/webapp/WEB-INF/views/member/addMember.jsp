<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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
			<h1 class="display-3">회원 가입</h1>
		</div>
	</div>
 <script >

   function Check_Id()
   {
	   if (newMember.id.value=="") {
		   alert("아이디를 입력해 주세요");
		   return;
	   }
       window.open("${pageContext.request.contextPath}/members/member?id=" + newMember.id.value, 
    		   "IDcheck", "left=200,top=200,width=500,height=300,scrollbars=no,resizable=yes");
     

   }
</script>

	<div class="container">
	
		<form:form  modelAttribute="newMember" class="form-horizontal"  action="./add?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<fieldset>
			

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="id">아이디</label>
					<div class="col-sm-3">
					<form:input path="id"  class="form-control" placeholder="id" />	
					</div>
					<div class="col-sm-6">
					<form:errors path="id" cssClass="text-danger"/>				
					</div>
					
				
				
				</div>

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="passwd">비밀번호</label>
					<div class="col-sm-3">
					<form:password path="passwd" class="form-control" placeholder="password"/>
					</div>
					<div class="col-sm-6">
					<form:errors path="passwd" cssClass="text-danger"/>
				 	</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 control-label" for="passwd_confirm">비밀번호확인</label>
					<div class="col-sm-3">
					<form:password path="passwd_confirm"  class="form-control" placeholder="password confirm"/>
					</div>
					<div class="col-sm-6">
					<form:errors path="passwd_confirm" cssClass="text-danger"/>
					</div>
				 </div>
				
					<div class="form-group row">
					<label class="col-sm-2 control-label" for="name">이름</label>
					<div class="col-sm-3">
					<form:input path="name" class="form-control" placeholder="name"/>
					</div>
					<div class="col-sm-6">
					<form:errors path="name" cssClass="text-danger"/>
					
				 	</div>
				</div>
				
				
				
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="sex">성별</label>
					<div class="col-sm-10">	
						<form:radiobutton path="sex" value="남"/> 남
						
						<form:radiobutton path="sex" value="여" /> 여 
					</div>		
				</div>
				
				
				<div class="form-group row">	
					<label class="col-sm-2 control-label" for="tel">전화번호</label>
					<div class="col-sm-3">	
					<form:input path="tel" class="form-control" placeholder="phone"/>	
					
					</div>		
				</div>
               
				<div class="form-group row">
					<label class="col-sm-2 control-label" for="address">주소</label>
					<div class="col-sm-5">	
						<form:input  path="address" class="form-control" placeholder="address"/>
					
					</div>		
				</div>		
				
				
				<div class="form-group row">
					 <div class="col-sm-offset-2 col-sm-10 " >
						<input type="submit"  class="btn btn-primary " value ="등록 "/>
						<input type="reset" class="btn btn-primary " value ="취소 "/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
		
		
	</div>
</body>
</html>
