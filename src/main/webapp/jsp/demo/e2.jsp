<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<html>
	<head></head>
	<body style="font-size:30px;color:black;">
		1 + 1 = ${1 + 1 }<br/>
		"a" + "b" = ${"1" + "1"}<br/>	
		1 < 2 吗? ${1 < 2 }<br/>
		<%
			request.setAttribute("s1", "abc");
		%>
		${s1 == 'abc' }<br/>
		${sessionScope.s1 == 'abc' }<br/>
		${1<2 && 2>3 }<br/>
		
		empty运算：<br/>
		<%
			request.setAttribute("s2", "0");
			List list1 =new ArrayList();
			list1.add(1, "element1");
			//list1.add(false);
			request.setAttribute("list1", list1);
		%>
		空字符串:${empty s2 }<br/>
		空集合:${empty list1 }<br/>
		null:${empty null }<br/>
		找不到数据:${empty a }<br/>
		
		${param.uname} 等价 request.setAttrubute("uname");
	</body>
</html>