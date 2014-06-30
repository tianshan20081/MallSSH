<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
</script>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#FFFFFF" align="center">
<img src="image/fg2.jpg" width="752" height="45">
 

  
  
    <%if(request.getAttribute("form")==null){%>
 <p><strong>不存在此会员名称,请重新输入！！！</strong></p>
 <meta http-equiv="refresh" content="3;URL=index.jsp">
  <%}else{%>
  <p><strong>输入答案</strong></p>
  <form name="form" method="post" action="member?action=4" onSubmit="return checkEmpty(form)">
    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35">
          <div align="right">问题:</div></td>
        <td width="187"><div align="left">
            <input type="hidden" name="member.name" value="${form.name  }">
            <input type="hidden" name="member.question" value="${form.question }">
            ${form.question }
        </div></td>
      </tr>
       <tr>
        <td width="105" height="35">
          <div align="right">答案:</div></td>
        <td width="187">
          <div align="left">
            <input type="text" name="member.result">
          </div></td>
      </tr>
    </table>
    <br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
  </form>
<%}%>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
