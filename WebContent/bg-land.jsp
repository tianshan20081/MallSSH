<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录</title>
<script src="js/jquery-1.11.0.js"></script>
<style type="text/css">
<!--
body {
	background-color: #f0f0f0;
}
-->
</style></head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
 <script language="javascript">
$(function(){
	if("${error }"=="")
		return;
	alert("${error }");
});

 function checkEmpty(){
	 if($('#account').val()==""){
	  window.alert("请输入管理员账号");
	   return false;
	 }
	 if($("#password").val()==""){
	 window.alert("请输入管理员密码");
	 return false;
	 }
	 return true;
 } 
 
 </script>
<body> 
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	
	
<form method="post" action="manager?action=0&page=1" onSubmit="checkEmpty()">
<table width="547" height="294" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg-land.jpg">
  <tr>
    <td width="125">&nbsp;</td>
    <td width="422" valign="bottom"><table width="411" border="0">
      <tr>
        <td width="55" height="38"><font color="#9A6634"><strong>用户名：</strong></font>          </td>
        <td width="104"><input name="manager.acount" type="account" class="bgtext" size="15"></td>
        <td width="45">&nbsp;<font color="#9A6634"><strong>密码：</strong></font>          </td>
        <td width="113"><input name="manager.password" type="password" class="bgtext" size="15"></td>
        <td width="72"><div align="right">
          <input name="Submit" type="image" class="bgButtoninput" src="image/bg-land.gif" >
        </div></td>
      </tr>
      <tr>
        <td height="30" colspan="5"><div align="right"><a href="index" class="a1">返回</a>&nbsp;&nbsp;</div></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
	</td>
  </tr>
</table>


</body>
</html>
