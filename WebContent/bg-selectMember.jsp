<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.Member"%>
<%
List list = (List)request.getAttribute("memberList");
int number=(Integer)request.getAttribute("currentPage");
int maxPage=(Integer)request.getAttribute("pageCount");
int pageNumber=(Integer)request.getAttribute("count");
%>
 <script Language="JavaScript">
 function deleteMember(date) {
  if(confirm("确定要删除吗？")){
    window.location="memberAction.do?action=4&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
            <td><div align="center"><strong>会员信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
				 
	    <table width="71%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">

	    <tr>
          <td width="14%" height="25"><div align="center">编号</div></td>
          <td width="14%"><div align="center">会员账号</div></td>
          <td width="14%"><div align="center">会员姓名</div></td>
           <td width="14%"><div align="center">会员年龄</div></td>

    <td width="38%"><div align="center">操作</div></td>
        </tr>
        <%
        List memberList = (List)request.getAttribute("memberList");
        for(int i=0;i<memberList.size();i++){
     	 Member form=(Member)memberList.get(i);
          %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getName()%></div></td>
          <td><div align="center"><%=form.getReallyName()%></div></td>
          <td><div align="center"><%=form.getAge()%>岁</div></td>
        <td><div align="center">

		 <a href="member?action=9&id=<%=form.getId()%>">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;

		 <a href="member?action=8&memberId=<%=form.getId()%>">删除</a>

		  </div></td>
        </tr>
        <%}%>
      </table><br>
	   <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
   <tr align="center">
    <td width="17%">共为<%=maxPage%>页</td>
			<td width="22%">共有<%=pageNumber%>条记录</td>
            <td width="26%">当前为第<%=number%>页</td>
    <td width="19%"><%if(number==1){%> 上一页<%}else{%><a href="memberAction.do?action=2&i=<%=number-1%>">上一页</a></td><%}%>
            <td width="16%"><%if(maxPage<(number+1)){%>下一页<%}else{%><a href="memberAction.do?action=2&i=<%=number+1%>">下一页</a></td><%}%>



   </tr>
 </table>
		
	</table>	
<jsp:include page="bg-down.jsp" flush="true" />




</body>
</html>
