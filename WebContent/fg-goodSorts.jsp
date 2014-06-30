<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<table  height="25"  border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
    <td  align="center">
	    <c:forEach var="bigType" items="${bigTypeList }" varStatus="status">
	    	 <a href="goods!selectBigTypeById?page=1&bigTypeId=${bigType.id }">${bigType.bigName }</a>&nbsp;&nbsp;
		</c:forEach>    
	 </td>
   </tr>
</table>
