<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
	<br><br>
	<strong>订单查看</strong>
	 <br>	 <br>	 <br>
     <c:if test="${orderList.size()==0 }">
     没有订货信息
     </c:if>
     <c:if test="${orderList.size()>0 }">

		  <table width="95%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

       <tr align="center">
            <td width="15%" height="21">编号</td>

            <td width="15%">电话</td>
            <td width="21%">地址</td>

            <td width="19%">订货时间</td>
            <td width="18%">是否出货</td> <td width="12%">操作</td>
          </tr>
          <c:forEach var="order" items="${orderList }" varStatus="status">
          <tr align="center">
            <td height="24">${order.num }</td>

            <td>${order.tel }</td>
            <td>${order.address }</td>

            <td>${order.createTime }</td>
            <td><c:if test="${order.sign==0 }">
            否</c:if><c:if test="${order.sign==1 }">是</c:if>
            </td>
             <td><a href="order?action=2&orderNumber=${order.num }">查看明细</a></td>
          </tr>
		</c:forEach>
      </table>
    </c:if>	
</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
