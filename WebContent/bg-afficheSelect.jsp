<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.Affiche"%>
<%
int number=(Integer)request.getAttribute("currentPage");
int maxPage=(Integer)request.getAttribute("pageCount");
int pageNumber=(Integer)request.getAttribute("count");
%>
 <script Language="JavaScript">
 function deleteAffiche(date) {
  if(confirm("确定要删除吗？")){
    window.location="afficheAction.do?action=3&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城的后台</title>
<style type="text/css">
<!--
.style1 {color: #5F5F5F}
-->
</style>
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
            <td><div align="center"><strong>公告信息的查询</strong></div></td>
          </tr>
        </table>
        <br>

	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="17%" height="25"><div align="center">数据编号</div></td>
          <td width="19%"><div align="center">公告标题</div></td>
          <td width="27%"><div align="center">公告发布时间</div></td>
          <td width="37%"><div align="center">操作</div></td>
        </tr>
		    <% 
        	List aList = (List)request.getAttribute("aList");
        	int flag = aList.size();
        	if(flag>6) {
        		flag = 6;
        	}
        	for(int i=0;i<flag;i++) {
        		Affiche form = (Affiche)aList.get(i);
        %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center" ><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getName()%></div></td>
          <td><div align="center"><%=form.getIssueTime()%></div></td>
          <td><div align="center" ><a href="affiche?action=3&afficheId=<%=form.getId()%>">修改</a>&nbsp;&nbsp;<a href="affiche?action=2&afficheId=<%=form.getId()%>">查询内容</a>&nbsp;&nbsp;<a href="affiche?action=0&page=1&afficheId=<%=form.getId()%>&no=1">删除</a></div></td>
      <%}%>  </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%">共为<%=maxPage%>页</td>
          <td width="16%">共有<%=pageNumber%>条记录</td>
          <td width="14%">当前为第<%=number%>页</td>
          <td width="19%"><%if(number==1){%>
      上一页
        <%}else{%>
        <a href="affiche?action=0&page=<%=number-1%>">上一页</a></td>
          <%}%>
          <td width="18%"><%if(maxPage<(number+1)){%>
            下一页
              <%}else{%>
              <a href="affiche?action=0&page=<%=number+1%>">下一页</a></td>
          <%}%>
          <td width="20%">&nbsp;
          <a href="bg-afficheInsert.jsp"><img src="image/bg-add.gif" width="9" height="9">&nbsp;添加公告</a></td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />










</body>
</html>
