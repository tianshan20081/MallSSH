<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>
<body>
	<script language='javascript'>alert('<%=request.getAttribute("result")%>');window.location.href='affiche?action=0&page=1';</script>
</body>
</html>
