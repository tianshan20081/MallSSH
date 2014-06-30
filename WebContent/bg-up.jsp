<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.java1234.model.Manager" %>
<%
if(session.getAttribute("currentManager")==null){
out.print("<script language=javascript>alert('您已经与服务器断开连接，请重新登录！');window.location.href='bg-land.jsp';</script>");
}else{
Manager manager = (Manager)session.getAttribute("currentManager");
%>
<table width="788" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg_01.jpg">
  <tr>
    <td valign="top"><table width="770" border="0" align="center">
      <tr >
        <td width="413" height="53" valign="bottom"><div align="right"></div></td>
        <td width="347" valign="bottom" align="right"><font color="#FFFFFF"><a href="manager?action=3&page=1" class="a2">商品查询</a> | <a href="bigType?action=0&page=1" class="a2">大类别查询</a> | <a href="smallType?action=0&page=1" class="a2">小类别查询</a> | <a href="goindex" class="a2">返回首页</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="15" height="25">&nbsp;</td>
    <td width="579"><font color="#FFFFFF">当前登录：<%=manager.getAcount()%></font></td>
    <td width="194"><font color="#FFFFFF"></td>
  </tr>
</table>
<%}%>