<%
	Cookie[] cookies =request.getCookies();
	if(cookies !=null){
		for(int i=0;i<cookies.length;i++){
			String name =cookies[i].getName();
			String value =cookies[i].getValue();
			out.println("<h1>name:"+name+";<br/>value:"+value+"</h1>");
		}
	}
%>