<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="AmbroseRen.system.entity.*" %>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
		<%
			User user =new User();
			user.setName("Sally");
			user.setAge(22);
			user.setInterest(new String[]{"cookie","snooker"});
			request.setAttribute("user", user);
			
			User user2 =new User();
			user2.setName("Tom");
			user2.setAge(33);
			session.setAttribute("user", user2);
		%>
		name:<%
			User user1 =(User)request.getAttribute("user");
			out.println(user1.getName());
		%><br/>
		name:${sessionScope.user.name}<br/>
		name:${user.name }<br/>
		name:${user["name"] }<br/>
		<%
			request.setAttribute("prop", "age");
		%>
		<!-- prop隐式加了getAge()转换 -->
		${user[prop]}
		${user.interest[0] }
	</body>
</html>