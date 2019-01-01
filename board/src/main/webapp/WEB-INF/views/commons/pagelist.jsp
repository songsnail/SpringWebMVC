<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div align ="center">
			
<c:forEach var="i" begin="1" end="${total_page}">
<a href="<c:url value="./list?page=${i}" /> ">	
<c:choose>
 <c:when test="${page==i}"> <font color='4C5317'><b> [${i}]</b></font></a> </c:when>
<c:otherwise> <font color='4C5317'> [${i}]</font></a> </c:otherwise>
</c:choose>						
</c:forEach>	
 </div>