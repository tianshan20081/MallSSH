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
	
	第${no }名
	
	<br><br><br>
		<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="36%" rowspan="5" height="120"><div align="center">
                <input name="pricture" type="image" src="${goods.picture }" width="140" height="126">
            </div></td>
            <td width="64%" height="30"><div align="center">${goods.goodsName }</div></td>
          </tr>

          <tr>
            <td height="30"><div align="center">
            <c:if test="${goods.mark==1 }">
               特价：${goods.freePrice }元
            </c:if>
            现价：${goods.nowPrice }元
            </div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">${goods.introduce }</div></td>
          </tr>
          <tr align="center">
            <td height="30">
              <%if(session.getAttribute("currentMember")!=null){%>
              <div align="center"><a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${goods.id}','','width=500,height=200');">查看详细内容</a>
                  <%}else{%>
        登录后才能购买 </div>
              <%}%>
            </td>
          </tr>
        </table>
	
	
	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
