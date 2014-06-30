<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%int currentPage = (Integer)request.getAttribute("currentPage");
int maxPage = (Integer)request.getAttribute("pageCount");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
<c:choose>
	<c:when test="${goodsBybigTypeList.size()==0 }" ><br><br><br><br>没有商品的信息<br><br><br><br></c:when>
	<c:otherwise>
        <c:forEach var="goodsBigType" items="${goodsBybigTypeList }" varStatus="status">
<br>
		<table width="67%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="4" height="120"><input name="picture${status.index+1 }" type="image" src="${goodsBigType.picture }" width="140" height="126"></td>
            <td width="64%" height="30"><div align="center">${goodsBigType.goodsName }</div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">
            <c:if test="${goodsBigType.mark==0}"> 单价：${goodsBigType.nowPrice }元</c:if>
            <c:if test="${goodsBigType.mark==1}"><font color="#FF0000"> 特价：${goodsBigType.freePrice }元</font></c:if>
            </div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">${goodsBigType.introduce }</div></td>
          </tr>
          <tr>
            <td height="30"> <div align="center">  <%if(session.getAttribute("currentMember")!=null){%>
              <a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${goodsBigType.id}','','width=500,height=200');">查看详细内容</a>
				    <%}else{%>
				   登录后才能购买
				   <%}%>
			    </div></td>
          </tr>
        </table>
         </c:forEach>
	</c:otherwise>
</c:choose>		
		<br>
       <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="13%">共为${pageCount }页</td>
            <td width="16%">共有${count }条记录</td>
            <td width="14%">当前为第${currentPage }页</td>
            <td width="19%"><%if(currentPage==1){%>
   	   上一页
        <%}else{%>
        <a href="goods!selectBigTypeById?page=${currentPage-1 }&bigTypeId=${bigTypeId }">上一页</a></td>
            <%}%>
            <td width="18%"><%if(maxPage>=(currentPage+1)){%>
        <a href="goods!selectBigTypeById?page=${currentPage+1 }&bigTypeId=${bigTypeId }">下一页</a></td>
        <%}else{%>
   	   下一页
            <%}%>
          </tr>
        </table>
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>