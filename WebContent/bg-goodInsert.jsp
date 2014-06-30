<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.BigType"%>
<%@page import="com.java1234.model.SmallType"%>
<script language="javascript">
function checkEmpty(){
}
function ChangeItem(){
var big=form.big.value;

window.location.href="goodsAction.do?action=2&bigId="+big;
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
            <td><div align="center"><strong>添加商品信息</strong></div></td>
          </tr>
        </table>
        <br>

  <form action="goods?action=3" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty()" >
        <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;所属大类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;
              <select name="goods.bigType.id" onChange="ChangeItem()"><option value="">请选择</option>
          <%
          	List btList = (List)request.getAttribute("btList");
          	for(int i=0;i<btList.size();i++){
            BigType bigForm=(BigType)btList.get(i);
            %>

          <option value="<%=bigForm.getId()%>" >

		  <%=bigForm.getBigName()%>
		  </option>
            <%}%>
            </select></td>
            <td width="20%">&nbsp;&nbsp;所属于小类别</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;
              <select name="goods.smallType.id"><option value="">请选择</option>
             <%
               List stList = (List)request.getAttribute("stList");
               for(int i=0;i<stList.size();i++){
               SmallType smallForm=(SmallType)stList.get(i);
               %>
                  <option value="<%=smallForm.getId()%>"><%=smallForm.getSmallName()%></option>

               <%}%>
            </select></td>
          </tr>
          <tr>
            <td height="25">&nbsp;&nbsp;商品名称</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.goodsName" type="text" size="20"></td>
            <td>&nbsp;&nbsp;生产厂商</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="goods.goodsFrom" type="text" size="20"></td>
          </tr>
          <tr>
            <td height="27">&nbsp;&nbsp;商品定价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.nowPrice" type="text" size="20"></td>
            <td>&nbsp;&nbsp;初始化特价</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="goods.freePirce" type="hidden" size="20" value="0">0元</td>
          </tr>
		  
		  <tr>
            <td height="28">&nbsp;&nbsp;商品图片</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="picture" type="file" id="picture"></td>
          </tr>
		  
		  
          <tr>
            <td height="28">&nbsp;&nbsp;简介</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="goods.introduce" type="text" size="50"></td>
          </tr>
        </table><br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
	  </form>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
