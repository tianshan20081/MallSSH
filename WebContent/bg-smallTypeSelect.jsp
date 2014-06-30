<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.SmallType"%>
<%
int number=(Integer)request.getAttribute("currentPage");
int maxPage=(Integer)request.getAttribute("pageCount");
int pageNumber=(Integer)request.getAttribute("count");
%>
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
            <td><div align="center"><strong>商品小类别查询</strong></div></td>
          </tr>
        </table>
        <br>
	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="10%" height="25"><div align="center">数据编号</div></td>
          <td width="18%"><div align="center">小类别名称</div></td>
		  <td width="20%"><div align="center">属于大类别名称</div></td>
          <td width="27%"><div align="center">创建时间</div></td>

          <td width="25%"><div align="center">操作</div></td>
        </tr>
        <c:forEach var="smallType" items="${stList }" varStatus="status">
        	<c:if test="${status.index<6 }">
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center">${smallType.id }</div></td>
          <td><div align="center">${smallType.smallName }</div></td>
		  <td><div align="center">
		  
		  <a href="goods?action=4&page=1&bigTypeId=${smallType.bigType.id }">${smallType.bigType.bigName }</a>
		  
		  </div></td>
          <td><div align="center">${smallType.createTime }</div></td>                                                                                                                                                                                                   
       
		 <td>  
		   <div align="center">   
		  <a href="smallType?action=0&smallTypeId=${smallType.id }">删除</a> </div>
		  </td>
		 </c:if>
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
        <a href="smallType?action=0&page=<%=number-1%>">上一页</a></td>
          <%}%>
          <td width="18%"><%if(maxPage<(number+1)){%>
            下一页
              <%}else{%>
              <a href="smallType?action=0&page=<%=number+1%>">下一页</a></td>
          <%}%>

          <td width="20%">
            <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="smallType?action=2">&nbsp;添加大类别&nbsp;</a></div></td>

        </tr>
      </table>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
