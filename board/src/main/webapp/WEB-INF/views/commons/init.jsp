<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="scale" value="2"/>
<c:set var="total_record" value="${total_record}"/>
<c:set var="page" value="${page}"/>
<c:choose>
	<c:when test="${total_record % scale == 0}">  					
 		<c:set var="total_page" value="${total_record/scale}"/>			 	      
 	</c:when>
	<c:otherwise>
		<c:set var="total_page" value="${total_record/scale+1}"/>		
 	</c:otherwise>
</c:choose>    
<c:set var="i" value="0"/>
<c:set var="start" value="${(page-1)*scale }"/>
<c:set var="end" value="${start+scale-1}"/>