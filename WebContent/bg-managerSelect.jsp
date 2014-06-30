<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

 <script Language="JavaScript">
 function deleteManager(date) {
  if(confirm("确定要删除吗？")){
    window.location="manager?action=1&m.id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城的后台</title>
<script src="js/jquery-1.11.0.js"></script>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>

<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top">
    	<jsp:include page="bg-left.jsp" flush="true" />
    </td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	</td>

</table>
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
