<%@ page contentType="text/html; charset=utf-8" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城</title>
</head>
<html>
<link href="css/css.css" rel="stylesheet" type="text/css"> 
<script language="javascript">
function resetValue(){
	document.getElementById("password").value="";
	document.getElementById("passwordOne").value="";
}
function checkEmpty(){
	if( $("#password").val()=="" || $("#passwordOne").val()=="") {
		alert("表单信息不能为空");
		return false;
	}
	if(document.getElementById("password").value!=document.getElementById("passwordOne").value){
		window.alert("您两次输入的密码不一致，请重新输入");
		return false;
	}
	if(isNaN(document.getElementById("age").value)){
		window.alert("年龄只能为数字");
		return false;
	}
}
</script>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#F5F5F5" align="center">
<img src="image/fg1.jpg" width="752" height="39">


<form action="member?action=7&id=${currentMember.id }" method="post" onsubmit="return checkEmpty()">
<table width="298"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="105" height="35">
          <div align="right">会员名称：</div></td>
        <td width="187"><div align="center">
          <input type="hidden" name="name" value="${currentMember.name }">${currentMember.name }
        </div></td>
      </tr>
       <tr>
        <td height="35">
          <div align="right">原来的密码：</div></td>
        <td><div align="center">
           <input type="hidden" name="result" value="${currentMember.result }">
            <input type="hidden" name="question" value="${currentMember.question }">
          <input type="hidden" name="passwordOld" value="${currentMember.password }">
          <input type="password" name="oldPassword">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">新密码：</div></td>
        <td><div align="center">
          <input type="password" name="member.password" id="password">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">密码确认：</div></td>
        <td><div align="center">
          <input type="password" name="passwordOne" id="passwordOne">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">真实姓名：</div></td>
        <td><div align="center">
          <input type="text" name="reallyName" value="${currentMember.reallyName }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">年龄：</div></td>
        <td><div align="center">
          <input type="text" name="age" value="${currentMember.age }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">职业：</div></td>
        <td><div align="center">
          <input type="text" name="profession" value="${currentMember.profession }">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Email地址：</div></td>
        <td><div align="center">
          <input name="email" type="text"  value="${currentMember.email }">
        </div></td>
      </tr>
    </table>
    <br>
<input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
<a href="#" onClick="resetValue()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
</form>
  <p>&nbsp;  </p>    </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
