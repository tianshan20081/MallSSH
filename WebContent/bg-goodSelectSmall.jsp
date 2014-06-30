<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
int number=(Integer)request.getAttribute("currentPage");
int maxPage=(Integer)request.getAttribute("pageCount");
int pageNumber=(Integer)request.getAttribute("count");
%>
 <script Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="bigTypeAction.do?action=3&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城的后台</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>按小类别商品信息查询</strong></div></td>
          </tr>
        </table>
        <br>
				  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="14%" height="25"><div align="center">数据编号</div></td>
          <td width="19%"><div align="center">商品名称</div></td>
          <td width="14%"><div align="center">大类别</div></td>
          <td width="14%"><div align="center">小类别</div></td>
          <td width="14%"><div align="center">是否特价</div></td>
          <td width="25%"><div align="center">操作</div></td>
        </tr>
        
		    <c:forEach var="form" items="${gList }" varStatus="status">
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center">${form.id }</div></td>
          <td><div align="center"><a href="${form.picture }" target="_blank">${form.goodsName }</a></div></td>

          <td><div align="center">${form.bigType.bigName }</div></td>

          <td><div align="center">${form.smallType.smallName }</div></td>
          <td><div align="center">
          
          <c:if test="${form.mark==0 }">否</c:if>
          <c:if test="${form.mark==1 }">是</c:if>
          </div></td>
          <td><div align="center"><a href="manager?action=4&goodsId=${form.id }">详细信息</a>
		  </div></td>
		  </c:forEach>
		  
	  </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%">共为<%=maxPage%>页</td>
          <td width="16%">共有<%=pageNumber%>条记录</td>
          <td width="14%">当前为第<%=number%>页</td>
          <td width="19%"><%if(number==1){%>  
	  上一页  
        <%}else{%>
		
		<a href="goodsAction.do?action=8&i=<%=number-1%>&small=<%=request.getParameter("small")%>">
		  上一页</a></td>
          <%}%>
          <td width="18%"><%if(maxPage<(number+1)){%>
            下一页
              <%}else{%>
	 
		<a href="goodsAction.do?action=8&i=<%=number+1%>&small=<%=request.getParameter("small")%>">下一页</a>
<%}%>
        </tr>
      </table>
	
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>