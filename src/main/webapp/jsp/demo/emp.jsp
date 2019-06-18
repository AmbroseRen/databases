<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="AmbroseRen.system.entity.*" %>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
		<%
			Emp emp =new Emp();
			emp.setName("u1");
			emp.setAge(22);
			emp.setGender("男");
			request.setAttribute("emp", emp);//绑定对象
		%>
		${emp}
		${empty emp.gender }
		city:${paramValues.city[0] }
	</body>
</html>