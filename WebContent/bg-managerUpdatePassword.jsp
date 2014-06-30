<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.Manager"%>
<%
Manager form=(Manager)session.getAttribute("currentManager");
%>
<script language="javascript">
function checkEmpty(form){
}
</script><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城的后台</title>
</head>
 
<html:html>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>修改管理员密码</strong></div></td>
          </tr>
        </table>
        <br>
<form name="form" method="post" action="manager?action=6&manager.acount=<%=form.getAcount()%>" onSubmit="return checkEmpty()">
       <table width="60%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr><input name="selectPassword" type="hidden"  value="<%=form.getPassword()%>">
            <td width="29%" height="30"><div align="center">原密码</div></td>
            <td width="71%" bgcolor="#FFFFFF">&nbsp;
            <input name="old" type="password" size="30"></td>
          </tr>
          <tr>
            <td height="30"><div align="center">新密码</div></td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="manager.password" type="password" size="30"></td>
          </tr>
          <tr>
            <td height="30"><div align="center">再次输入新密码</div></td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="passwordNext" type="password" size="30"></td>
          </tr>
        </table>
        <p>
        <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>	
        </p>
</form>

		</table>	
<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html:html>
