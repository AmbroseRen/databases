<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="AmbroseRen.system.entity.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<style>
			.rowl{
				boakground-color:#fff8dc;
			}
			.row2{
				background-color:#f0f0f0;
			}
		</style>
	</head>
	<body style="font-size:30px;color:red;">
		<%
			List<User> users =new ArrayList<User>();
			for(int i=0;i<8;i++){
				User user =new User();
				user.setName("user0"+i);
				user.setGender("M");
				users.add(user);
			}
			request.setAttribute("users", users);
		%>		
		<table border="1" width="200" height="300" cellpadding="0" cellspacing="0">
			<tr>
				<td>姓名</td><td>性别</td>
				<td>index</td><td>count</td>
			</tr>
			<c:forEach items="${users}" var="u" varStatus="s">
				<tr class="row${s.index % 2+1 }">
					<td>${u.name}</td><td>${u.gender}</td>					
					<td>${s.index}</td><td>${s.count}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>