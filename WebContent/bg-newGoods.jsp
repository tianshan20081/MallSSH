<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子商城</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>
	<jsp:include page="fg-top.jsp" flush="true" />
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="207" valign="top" bgcolor="#F5F5F5">  
				<!--左侧01 --><jsp:include page="fg-left.jsp" flush="true" /></td>
			<td width="559" valign="top" bgcolor="#FFFFFF">
				<!--右侧01--> <jsp:include page="fg-goodSorts.jsp" flush="true" />

				<div align="center">
					<img src="image/fg_right01.jpg">
				</div>
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="215" valign="top">
							<c:forEach var="newGoods" items="${newGoodsList }" varStatus="status">
								<c:if test="${status.index<6 }">
								<table width="100%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="99%" border="0" align="center" cellpadding="0"
												cellspacing="0" bordercolor="#CCCCCC">
												<tr>
													<td height="150" bordercolor="#666666">
														<table width="96%" border="1" align="center"
															cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
															bgcolor="#CCCCCC">
															<tr>
																<td width="36%" rowspan="4" bgcolor="#FFFFFF"><div
																		align="center">
																		<input name="picture${status.index+1 }" type="image"
																			src="${newGoods.picture }" width="110"
																			height="100">
																	</div>
																</td>
																<td width="64%" bgcolor="#FFFFFF"><div
																		align="center">${newGoods.goodsName }</div>
																</td>
															</tr>
															<tr>
																<td bgcolor="#FFFFFF"><div align="center">
																		<font color="#F14D83">单价：${newGoods.nowPrice }元</font>
																	</div>
																</td>
															</tr>
															<tr>
																<td bgcolor="#FFFFFF"><div align="center">${newGoods.introduce }</div>
																</td>
															</tr>
															<tr>
																<td bgcolor="#FFFFFF" class="linkBlack" align="center">
																	<%
																		if (session.getAttribute("currentMember") != null) {
																	%>
																	<a href="#"
																	onClick="window.open('goods!goodSelectOne?goodsId=${newGoods.id}','','width=500,height=200');">查看详细内容</a>
																	<%
																		} else {
																	%> 登录后才能购买</td>
																<%
																	}
																%>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								</c:if>
							</c:forEach>
						</td>


					</tr>
				</table></td>
		</tr>
	</table>

	<jsp:include page="fg-down.jsp" flush="true" />

</body>
</html>
