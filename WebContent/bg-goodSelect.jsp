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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
            <td><div align="center"><strong>商品大类别查询</strong></div></td>
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
        
        <c:forEach var="form" items="${bg_goodsList }" varStatus="status">
        	<c:if test="${status.index<6 }">
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center">${form.id }</div></td>
          <td><div align="center"><a href="#">${form.goodsName }</a></div></td>
          <td><div align="center"><a href="goods?action=4&page=1&bigTypeId=${form.bigType.id }">${form.bigType.bigName }</a></div></td>
          <td><div align="center"><a href="goods?action=5&page=1&smallTypeId=${form.smallType.id }">${form.smallType.smallName }</a></div></td>
          <td><div align="center"><a href="#">
          <c:if test="${form.mark==0 }">否</c:if>
          <c:if test="${form.mark==1 }">是</c:if>
         </a></div></td>
          <td><div align="center"><a href="manager?action=4&goodsId=${form.id }">详细信息</a>&nbsp;&nbsp;
		 <a href="manager?action=3&goodsId=${form.id }">删除</a>
		  </div></td>
         </c:if>
          </c:forEach>
           </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
        <td width="17%">共为<%=maxPage%>页</td>
	    <td width="22%">共有<%=pageNumber%>条记录</td>
	    <td width="26%">当前为第<%=number%>页</td>
          <td width="19%"><%if(number==1){%> 上一页<%}else{%><a href="manager?action=3&page=${currentPage-1 }">上一页</a></td><%}%>
	    <td width="16%"><%if((number+1)>maxPage){%>下一页<%}else{%><a href="manager?action=3&page=${currentPage+1 }">下一页</a></td>
	    <%}%>
          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9">&nbsp;<a href="goods?action=2">添加商品</a>&nbsp;</div></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
