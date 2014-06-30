<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%int currentPage = (Integer)request.getAttribute("currentPage");
int maxPage = (Integer)request.getAttribute("pageCount");
%>
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
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
    <table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_right02.jpg">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <c:forEach var="freeGoods" items="${freeGoodsList }" varStatus="status">
    	
    
			 <br> <table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

              <tr>
                <td width="36%" rowspan="5" height="120"><div align="center">
                  <input name="picture${status.index+1 }" type="image" src="${freeGoods.picture }" width="140" height="126">
                </div></td>
                <td width="64%" height="30"><div align="center">${freeGoods.goodsName }</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center" style="text-decoration:line-through;color:#FF0000">原价：${freeGoods.nowPrice }元</div></td>
              </tr>
			     <tr>
                <td height="30"><div align="center">特价：${freeGoods.freePrice }元</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">${freeGoods.introduce }</div></td>
              </tr>
              <tr>
               <td height="30" align="center">  <%if(session.getAttribute("currentMember")!=null){%>
               <a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${freeGoods.id}','','width=500,height=200');">查看详细内容</a>				
			  <%}else{%>登录后才能购买<%}%></td>
              </tr>
            </table>
			<br>
			</c:forEach>
		    <div align="center">
		      <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="13%">共为${pageCount }页</td>
                  <td width="18%">共有${count }条记录</td>
                  <td width="26%">当前为第${currentPage }页</td>
                  <td width="15%"><%if(currentPage==1){%>
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
