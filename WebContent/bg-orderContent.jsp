<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.Order"%>
<%@page import="com.java1234.model.OrderDetail"%>
<%Order order=(Order)request.getAttribute("order");%>
<%List orderDetailList=(List)request.getAttribute("orderDetailList");%>
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
            <td align="center"><strong>订单号为：<%=order.getNum()%>的详细信息</strong></td>
          </tr>
        </table>
        <br>

<table width="76%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
      <tr align="center" >
        <td width="26%" height="25">会员账号</td>
        <td width="22%" bgcolor="#FFFFFF"><%=order.getName()%></td>
        <td width="26%">会员姓名</td>
        <td width="22%" bgcolor="#FFFFFF"><%=order.getReallyName()%></td>
      </tr>
      <tr  align="center">
        <td height="25">送货电话</td>
        <td bgcolor="#FFFFFF"><%=order.getTel()%></td>
        <td>送货地址</td>
        <td bgcolor="#FFFFFF"><%=order.getAddress()%></td>
      </tr>
      <tr  align="center">
        <td height="25">付款方式</td>
        <td bgcolor="#FFFFFF"><%=order.getSetMoney()%></td>
        <td>运送方式</td>
        <td bgcolor="#FFFFFF"><%=order.getPost()%></td>
      </tr>
      <tr align="center">
        <td height="25" >备注信息</td>
        <td bgcolor="#FFFFFF"><%=order.getBz()%></td>
        <td>订货时间</td>
        <td bgcolor="#FFFFFF"><%=order.getCreateTime()%></td>
      </tr>
    </table>
	<br>
	    <strong>商品详细信息</strong>	  <br><br>
	    <table width="74%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
          <tr>
            <td><div align="center">商品名称</div></td>
            <td><div align="center">商品数量</div></td>
            <td><div align="center">商品价格</div></td>
          </tr>
          <%
          int sum=0;
          for(int i=0;i<orderDetailList.size();i++){
            OrderDetail form=(OrderDetail)orderDetailList.get(i);
            sum=sum+form.getPrice()*form.getNum();
       
            %>
            
          <tr bgcolor="#FFFFFF">
            <td><div align="center"><%=form.getGoods().getGoodsName() %></div></td>
            <td><div align="center"><%=form.getNum()%></div></td>
            <td><div align="center"><%=form.getPrice()%>元</div></td>
          </tr>
          <%}%>
      </table> 
	    <br>
    总金额:<%=sum%><br>
    <table width="76%" height="19"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="72%">
              <div align="left">
                <%if(order.getSign()==1){%>
                已经出货
                <%}else{%>
                没有出货
                <%}%>
              </div></td><td width="28%"><div align="right"><a href="javascript:history.go(-1)">返回</a></div></td>
      </tr>
    </table>



    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
