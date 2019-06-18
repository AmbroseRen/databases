<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="AmbroseRen.system.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
		<%
			User user =new User();
			user.setGender("M");
			request.setAttribute("user", user);
		%>
		性别：
			<c:choose>
				<c:when test="${user.gneder =='M' }">男</c:when>
				<c:when test="${user.gneder =='F' }">女</c:when>
				<c:otherwise>保密</c:otherwise>
			</c:choose>
	</body>
</html>