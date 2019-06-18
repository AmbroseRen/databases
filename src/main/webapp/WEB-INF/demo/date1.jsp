<%@ page import="java.util.* ,java.text.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head></head>
	<body>
		<%
			Date date =new Date();
			out.println(date.getMonth()+1+"月"+date.getDate()+"日"+date.getYear()+"年");
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(sdf.format(date));
		%>
	</body>
</html>