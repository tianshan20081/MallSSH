<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.java1234.model.Link"%>
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
            <td><div align="center"><strong>连接网站信息的查询</strong></div></td>
          </tr>
        </table>
        <br>
 <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">
        <tr>
          <td width="14%" height="25"><div align="center">数据编号</div></td>
          <td width="28%"><div align="center">网站名称</div></td>
          <td width="28%"><div align="center">网站连接地址</div></td>
          <td width="30%"><div align="center">操作</div></td>
        </tr>
		     <% 
        	List lList = (List)request.getAttribute("lList");
        	int flag = lList.size();
        	if(flag>6) {
        		flag = 6;
        	}
        	for(int i=0;i<flag;i++) {
        		Link form = (Link)lList.get(i);
        %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getLinkName()%></div></td>
          <td><div align="center"><%=form.getLinkAddress()%></div></td>
          <td><div align="center"><a href="manager?action=7&page=1&linkId=<%=form.getId()%>">删除</a></div></td>
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
        <a href="linkAction.do?action=0&i=<%=number-1%>">上一页</a></td>
          <%}%>
          <td width="18%"><%if(maxPage<(number+1)){%>
            下一页
              <%}else{%>
              <a href="linkAction.do?action=0&i=<%=number+1%>">下一页</a></td>
          <%}%>

          <td width="20%">
            <img src="image/bg-add.gif" width="9" height="9">&nbsp;<a href="bg-linkInsert.jsp">添加网站信息</a></td>

        </tr>
      </table>




    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />




</body>
</html>
