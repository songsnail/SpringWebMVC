<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="float-left">	
<form  action="<c:url value="./list"/>"  method="post">
 <fieldset>
<table>
<tr>
<td width="100%" align="left">&nbsp;&nbsp;
<select name="find" class="txt">
<option value="subject">제목에서</option>
<option value="content">본문에서</option>
<option value="name">글쓴이에서</option>
</select>            			
<input name="search" type="text"  />
<input type="submit" id="btnAdd" class="btn btn-primary " value ="검색 "/> 
</td>
</tr>
</table>          			
</fieldset>
</form>
	</div>