<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="AmbroseRen.system.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
		<%
			User user =new User();
			user.setName("花花");
			user.setGender("F");
			request.setAttribute("user", user);
		%>
		姓名:${user.name }
		性别:<c:if test="${user.gender == 'M' }">男</c:if>
		   <c:if test="${user.gender == 'F' }">女</c:if> <br/>		  
		   
		   性别：
		   <c:if test="${user.gender =='M'}">男</c:if>
		   <c:if test="${user.gender !='M'}">女</c:if> <br/>
		  
		  性别：
		  <c:if test="${user.gender =='M'}" var="rs" scope="page">男</c:if> 
		  							<!-- pageContext.setAttribute("rs",false) -->		
		  <c:if test="${!rs }">女</c:if> <br/>
	</body>
</html>