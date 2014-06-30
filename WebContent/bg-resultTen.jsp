<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%int number=9; %>
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
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	

	商品销售排行 TOP<%=number%>	
	<br><br>
	<c:forEach var="goods" items="${allGoods }" varStatus="status">
					
	
         第${status.index+1 }名
		<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="4" height="84"><div align="center">
                <input name="pricture${status.index+1 }" type="image" src="${goods.picture }" width="110" height="100">
            </div></td>
            <td width="64%" height="21"><div align="center">${goods.goodsName }</div></td>
          </tr>
          <tr>
            <td height="21"><div align="center">单价：${goods.nowPrice }元</div></td>
          </tr>
          <tr>
            <td height="21"><div align="center">${goods.introduce }</div></td>
          </tr>
          <tr>
          
            <td height="21" align="center">  <%if(session.getAttribute("currentMember")!=null){%>
			<a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${goods.id}','','width=500,height=200');">查看详细内容</a>
            <%}else{%>
           登录后才能购买</td>
            <%}%>
          </tr>
        </table><br>
</c:forEach>	
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
