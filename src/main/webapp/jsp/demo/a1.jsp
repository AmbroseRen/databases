<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
		<%!	/* jsp声明 */
			int i =100; 
			int sum(int a1,int a2){
				return a1 +a2;
			}
		%>
		<%=i + 100 %>
		<%=sum(1,1) %>
	</body>
</html>
