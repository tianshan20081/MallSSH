<%@ page contentType="text/html; charset=utf-8" %>

<%java.util.Date date=new java.util.Date();%>
<html>
<script language="javascript">

function checkEmpty(){
	if( $('#name').val()==""
		|| $("#reallyName").val()==""
		|| $("#address").val()==""
		|| $("#tel").val()=="") {
		alert("表单信息不能为空");
		return false;
	}
	
function resetValue(){
	document.getElementById("address").value="";
	document.getElementById("tel").value="";
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城</title>
<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
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
	<strong>收银结帐</strong>   
	
	<form name="form" method="post" action="order?action=3"  onSubmit="checkEmpty()">
		  <table width="68%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" colspan="2"> <div align="center" class="style1">注意：请您不要恶意或非法提交订单以免造成不必要的麻烦！ </div></td>
            </tr>
			   <tr>
              <td height="30"><div align="center">订单编号：</div></td>
              <td>&nbsp;<input type="hidden" name="order.num" value="<%=date.getTime()%>"><%=date.getTime()%></td>
            </tr>
            <tr>
              <td width="24%" height="30"><div align="center">会员名称：</div></td>
              <td width="76%">&nbsp;<input type="text" name="order.name" id="name" value="${currentMember.name }"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">真实姓名：</div></td>
              <td>&nbsp;<input type="text" name="order.reallyName" id="reallyName" value="${currentMember.reallyName }"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">联系地址：</div></td>
              <td>&nbsp;<input type="text" name="order.address" id="address"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">联系电话：</div></td>
              <td>&nbsp;<input type="text" name="order.tel" id="tel"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">付款方式：</div></td>
              <td>&nbsp;
			  <select name="order.setMoney" class="textarea">
			        <option value="">请选择</option>
      <option value="银行付款">银行付款</option>
      <option value="邮政付款">邮政付款</option>
      <option value="现金支付">现金支付</option>
    </select>
			  </td>
            </tr>

            <tr>
              <td height="30"><div align="center">运送方式：</div></td>
              <td>&nbsp;<select name="order.post" class="textarea">
			        <option value="">请选择</option>
      <option value="普通邮寄">普通邮寄</option>
      <option value="特快专递">特快专递</option>
      <option value="EMS专递方式">EMS专递方式</option>
    </select>
			  </td>
            </tr>
            <tr>
              <td height="60"><div align="center">备注信息：</div></td>
              <td>&nbsp;<textarea name="order.bz"></textarea></td>
            </tr>
        </table>
		  <br>
                <input type="submit" name="Submit2" value="提交">&nbsp;
               <input type="reset"  name="reset" value="清除">&nbsp;
          <input type="button" name="back" value="返回" onClick="javasrcipt:history.go(-1)">
      </form>
</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>