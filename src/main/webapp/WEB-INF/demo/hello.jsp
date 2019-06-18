<%@ page import="java.util.*"  contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;">
		青山不改，绿水长流。<br/>
		current time:
		<% 
			
			Date date =new Date();
			out.println(date);
		%>
		<br/>
		current time2:<%= new Date() %>
		<%
			for(int i=0;i<100;i++){
				out.println("Hello World<br>");	
			}			
		%>
	</body>
</html>