<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="com.java1234.model.Order" %>
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
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF">
<br>
	<table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
      <tr>
        <td><div align="center"><strong>订单的查询</strong></div></td>
      </tr>
    </table>	<br>
	    <table width="96%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">

	    <tr bgcolor="#DCDCDC">
          <td width="15%" height="25"><div align="center">编号</div></td>
          <td width="14%"><div align="center">真实姓名</div></td>

         <td width="16%"><div align="center">是否出货</div></td>
        <td width="26%"><div align="center">订货时间</div></td>
   <td width="29%"><div align="center">操作</div></td>
        </tr>
        <% 
        	List orderList = (List)request.getAttribute("orderList");
        	int flag = orderList.size();
        	if(flag>6) {
        		flag = 6;
        	}
        	for(int i=0;i<flag;i++) {
        		Order order = (Order)orderList.get(i);
        %>
        <tr align="center" bgcolor="#FFFFFF">
          <td height="25"><%=order.getNum()%></td>
          <td><%=order.getReallyName()%></td>

		  <td><%if(order.getSign()==0){%>
                    <a href="#">否</a>
                    <%}else{%>
                    <a href="#">是</a>
          <%}%></td>
		  <td><%=order.getCreateTime()%></td>
        <td><a href="order?action=4&orderNum=<%=order.getNum()%>">详细信息</a>
                             &nbsp;&nbsp;
	     <%if(order.getSign()==1){%>
		 已出
		 <%}else {%>
		  <a href="manager?action=1&sign=1&orderNum=<%=order.getNum()%>">出货</a>
		 <%}%>
		 &nbsp;&nbsp;

		 <a href="manager?action=2&orderNum=<%=order.getNum()%>">删除</a></td>
        </tr>
        
        
        <%}%>
      </table><br>
      
  <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr align="center">
	    <td width="17%">共为<%=maxPage%>页</td>
	    <td width="22%">共有<%=pageNumber%>条记录</td>
	    <td width="26%">当前为第<%=number%>页</td>
	    <td width="19%"><%if(number==1){%> 上一页<%}else{%><a href="manager?action=1&page=${currentPage-1 }">上一页</a></td><%}%>
	    <td width="16%"><%if((number+1)>maxPage){%>下一页<%}else{%><a href="manager?action=1&page=${currentPage+1 }">下一页</a></td><%}%>
   </tr>
 </table>

</td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
