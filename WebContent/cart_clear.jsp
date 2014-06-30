<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
<%
session.removeAttribute("cartList");
session.removeAttribute("sum");
session.removeAttribute("goodsIdList");
response.sendRedirect("cart_see.jsp");
%>
