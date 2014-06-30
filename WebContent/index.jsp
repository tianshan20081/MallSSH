<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子商城</title>
<script src="js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(function(){
		if("${error }"=="")
			return;
		alert("${error }");
	});
</script>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>

<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="207" valign="top" bgcolor="#F5F5F5">
		<!--左侧01-->
	    <jsp:include page="fg-left.jsp" flush="true"/>
    </td>
    <td width="559" valign="top" bgcolor="#FFFFFF">
	 <!--右侧01-->	
		<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	   
	    <div align="center">
	       <%if(session.getAttribute("currentMember")!=null){%>
	        <img src="image/fg_right02.jpg">
	    </div>
	    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
	        <tr> 
	        	<c:forEach var="freeGoods" items="${freeGoodsList }" varStatus="status">
					<c:if test="${status.index<2 }">
			           <td valign="top">			
			            <table width="257" height="136" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#999999">
			              <tr>
			                <td width="33%" height="80" rowspan="5" bgcolor="#FFFFFF"><input name="pricture${status.index }" type="image" src="${freeGoods.picture }" width="140" height="126"></td>
			                <td width="67%" height="20" bgcolor="#FFFFFF"><div align="center">${freeGoods.goodsName }</div></td>
			              </tr>
			              <tr>
			                <td height="20" bgcolor="#FFFFFF"><div align="center" style="text-decoration:line-through;color:#910402">原价：${freeGoods.nowPrice }元</div></td>
			              </tr>
			              <tr>
			                <td height="20" bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">现价：${freeGoods.freePrice }元</font></div></td>
			              </tr>
			              <tr>
			                <td height="20" bgcolor="#FFFFFF"><div align="center">${freeGoods.introduce }</div></td>
			              </tr>
			              <tr>
			                <td height="13" bgcolor="#FFFFFF"><div align="center" class="linkBlack"><a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${freeGoods.id}','','width=500,height=200');">查看详细内容</a></div></td>
			              </tr>
			            </table>
			           </td>
				</c:if>
	        </tr>
	   	 </c:forEach>
		</table>
	<div align="center">
	 <%}%>
	    <img src="image/fg_right01.jpg">
	</div>
	<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
	          <tr>
	            <td height="215" valign="top">
	            <%if(session.getAttribute("currentMember")!=null){%>
	            <c:forEach var="nowGoods" items="${nowGoodsList }" varStatus="status">
					<c:if test="${status.index<2 }">
							<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
				              	 <tr>
				               	 	<td>				
				               	 		<table border="1px red solid" width="99%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
				                  			<tr>
				                    			<td height="150" bordercolor="#666666" >
				                      				<table width="96%"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC" >
				                       					 <tr>
				                         					 <td width="36%" rowspan="4" bgcolor="#FFFFFF">
				                         					 	<div align="center">
				                         					 		<!-- 商品图片 -->
				                             						 <input name="pricture${status.index }" type="image" src="${nowGoods.picture }" width="110" height="100">
				                          						</div>
				                          					</td>
				                          					<td width="64%" bgcolor="#FFFFFF"><div align="center">${nowGoods.goodsName }</div></td>
				                        				</tr>
								                        <tr>
								                          <td bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">单价：${nowGoods.nowPrice }元</font></div></td>
								                        </tr>
								                        <tr>
								                          <td bgcolor="#FFFFFF"><div align="center">${nowGoods.introduce }</div></td>
								                        </tr>
								                        <tr>
								                          <td  bgcolor="#FFFFFF" class="linkBlack"  align="center">
								                              
								                              <a href="#" onClick="window.open('goods!goodSelectOne?goodsId=${nowGoods.id}','','width=500,height=200');">查看详细内容</a>
								                             
								                                    </td>
								                        </tr>
				                    				</table>
				                    			</td>
				                  			</tr>
	                		</table></td></tr></table>
					</c:if>
				</c:forEach>
				<%}%>
	                <%if(session.getAttribute("currentMember")==null){%>
	               <c:forEach var="nowGoods" items="${nowGoodsList }" varStatus="status">
					<c:if test="${status.index<5 }">
			              <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
			              	 <tr>
			               	 	<td>				
			               	 		<table border="1px red solid" width="99%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
			                  			<tr>
			                    			<td height="150" bordercolor="#666666" >
			                      				<table width="96%"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC" >
			                       					 <tr>
			                         					 <td width="36%" rowspan="4" bgcolor="#FFFFFF">
			                         					 	<div align="center">
			                         					 		<!-- 商品图片 -->
			                             						 <input name="pricture${status.index }" type="image" src="${nowGoods.picture }" width="110" height="100">
			                          						</div>
			                          					</td>
			                          					<td width="64%" bgcolor="#FFFFFF"><div align="center">${nowGoods.goodsName }</div></td>
			                        				</tr>
							                        <tr>
							                          <td bgcolor="#FFFFFF"><div align="center"><font color="#F14D83">单价：${nowGoods.nowPrice }元</font></div></td>
							                        </tr>
							                        <tr>
							                          <td bgcolor="#FFFFFF"><div align="center">${nowGoods.introduce }</div></td>
							                        </tr>
							                        <tr>
							                          <td  bgcolor="#FFFFFF" class="linkBlack"  align="center">
							                                       		登录后才能购买</td>
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
				<%}%>
			</td>
          </tr>
		</table>
	</td> 
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
