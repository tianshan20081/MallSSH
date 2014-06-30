<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<jsp:useBean id="countTime" scope="page" class="com.java1234.util.CountTime"/>
<body>
<!--左侧01-->
	<%if(session.getAttribute("currentMember")==null){%>
	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
      <tr>
        <td valign="top">
       	 <table width="100%"  border="0" cellpadding="0" cellspacing="0">
			  <tr>
	            <td height="16">&nbsp;</td>
	          </tr>
         </table>
         <form name="form" method="post" action="member?action=1" onSubmit="return checkEmpty(form)">
          <table width="185" border="0" align="center">
            <tr>
              <td width="60" height="25">用户名：</td>
              <td width="115"> <input name="member.name" type="text" size="17"></td>
            </tr>
            <tr>
              <td height="25">密&nbsp;&nbsp;码：</td>
              <td><input name="member.password" type="password" size="17"></td>
            </tr>
			 <tr>
              <td height="26"><input type="image" class="input1"  src="image/fg-land.gif" width="51" height="20"></td>
              <td height="26">  &nbsp;&nbsp;<a href="fg-memberRegister.jsp">注册</a>&nbsp;&nbsp;<a href="fg-One.jsp">找回密码？</a></td>
			 </tr>	  
          </table>
		  </form>
		</td>
      </tr>
    </table>
    
	<%}else{%>
	
	<table width="100%" height="138"  border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
      <tr>
        <td valign="top">
	        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
				 <tr>
		            <td height="30">&nbsp;</td>
		          </tr>
	        </table>
       
          <table width="167" border="0" align="center">
            <tr>
              <td width="161" height="25"><font color="#FB6801">${currentMember.name },</font>欢迎回来</td>
              </tr>
            <tr>
              <td height="25"><%=countTime.currentlyTime()%></td>
              </tr>
			 <tr>
              <td height="25" >会员姓名：${currentMember.reallyName }</td>
              </tr>	 
			  <tr>
              <td height="20" align="right" valign="middle"><a href="member?action=2">安全退出</a></td>
              </tr>	
          </table>
	  </td>
     </tr>
    </table>
		<%}%>
		
<!--左侧02-->		
        <table width="100%" height="194" border="0" background="image/fg_left02.jpg">
          <tr>
            <td valign="top">
	            <table width="150" border="0">
	              <tr>
	                <td height="32">&nbsp;</td>
	              </tr>
	            </table>
                <table width="179" border="0" align="center">
	                <tr>
	                 <td width="171" height="143">
	                 <!-- 商城动画上滚信息 -->
					  <marquee direction="up" height="114" onmouseout="this.start()" onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
			               <c:forEach var="a" items="${allAffiche }" varStatus="status">
			               		<img src="image/sign.gif">&nbsp;<a href="#" onClick="window.open('affiche?action=4&affiche.id=${a.id}','','width=500,height=400');">${a.name }</a><br><br>
	           		  		</c:forEach>
	           		  </marquee>			      
	           		 </td>
	                </tr>
                </table>
             </td>
          </tr>
        </table>	
        
	    <table width="100%" height="193" border="0" cellpadding="0" cellspacing="0" background="image/fg_left03.jpg">
          <tr>
            <td valign="top">
	            <table width="194" border="0">
	              <tr>
	                <td height="40">&nbsp;</td>
	              </tr>
	   			</table>
	   			     
				<c:forEach var="goods" items="${allGoods }" varStatus="status">
					<c:if test="${status.index<7 }">
					<table width="178" height="19" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_left04.jpg">
				    <tr>
					    <td width="14"></td>
		                <td width="164"><a href="goods!goodsDetail?id=${goods.id }&no=${status.index+1 }">&nbsp;&nbsp;${goods.goodsName }</a></td>
					</tr>   
	               	</table>
	               	</c:if>			
				</c:forEach>			
			</td>
          </tr>
        </table>
        
	    <table width="207" height="181" border="0" cellpadding="0" cellspacing="0" background="image/fg_left05.jpg">
          <tr>
            <td valign="top">
	            <table width="173">
	              <tr>
	                <td height="35">&nbsp;</td>
	              </tr>
	            </table>
              <table width="186" align="center">
                <tr>
                  <td height="38">
				  <MARQUEE direction="up" height="114" onmouseout="this.start()" 
             		onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
             		
             		
             		<c:forEach var="link" items="${linkList }" varStatus="status">
		           		<img src="image/sign1.gif">&nbsp; <a href="${link.linkAddress }" target="_blank">${link.linkName }</a><br><br>
		            </c:forEach>
           	 </marquee>				 
           		</td>
               </tr>
              </table>
             </td>
          </tr>
      </table>

</body>
</html>
