<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子商城</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css"> 
<script src="js/jquery-1.11.0.js"></script>
<script language="javascript">
function resetValue(){
	document.getElementById("name").value="";
	document.getElementById("password").value="";
	document.getElementById("passwordOne").value="";
	document.getElementById("reallyName").value="";
	document.getElementById("age").value="";
	document.getElementById("profession").value="";
	document.getElementById("email").value="";
	document.getElementById("question").value="";
	document.getElementById("result").value="";
}

function checkEmpty(){
	if( $('#name').val()==""
		|| $("#password").val()==""
		|| $("#passwordOne").val()==""
		|| $("#reallyName").val()==""
		|| $("#age").val()==""
		|| $("#profession").val()==""
		|| $("#email").val()==""
		|| $("#question").val()==""
		|| $("#result").val()=="") {
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


<form action="member?action=0" method="post" onsubmit="return checkEmpty()">

<table width="270"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="107" height="35">
          <div align="right">会员名称：</div></td>
        <td width="163">
            <div align="left">
             <input type="text" value="" name="member.name" id="name" />
          </div></td></tr>
      <tr>
        <td height="35">          
          <div align="right">会员密码：</div></td>
        <td>
            <div align="left">
              <input type="password" value="" name="member.password" id="password" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">密码确认：</div></td>
        <td>
            <div align="left">
              <input type="password" value="" name="passwordOne" id="passwordOne" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">真实姓名：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.reallyName" id="reallyName" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">年龄：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.age" id="age" />         
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">职业：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.profession" id="profession" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">Email地址：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.email" id="email" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">找回密码问题：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.question" id="question" />
          </div></td></tr>
      <tr>
        <td height="35">
          <div align="right">答案：</div></td>
        <td>
            <div align="left">
              <input type="text" value="" name="member.result" id="result" />
          </div></td></tr>
    </table>
    <br>
<input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
<!-- 下面两个是链接 -->
<a href="#" onClick="resetValue()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
<form>

  <p>&nbsp;  </p>    </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
