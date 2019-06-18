<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%-- <%@ page import="dao.*,entity.*,java.util.*" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1 style="text-align:center" >
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>ID</td>
							<td>姓名</td>
							<td>薪水</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
					<!-- request.setAttribute("employees", employees); -->
						<c:forEach items="${employees}" var="e" varStatus="i">
					<tr class="row${i.index % 2+1 }">
						<td>${e.id}</td><td>${e.ename }</td>
						<td>${e.salary}</td><td>${e.age}</td>
						<td>
							<a href="del.do?id=${e.id}" 
									onclick="return confirm('确定删除${e.ename}');">删除</a>&nbsp;
							<a href="load.do?id=${e.id }">修改</a>
						</td>
					</tr>
				</c:forEach>
						<%-- <%
							
							List<Employee> es =(List<Employee>)request.getAttribute("employees");
							for(int i=0;i<es.size();i++){
								Employee e =es.get(i);
								%>
								<tr  class="row<%=(i % 2 + 1)%>">
									<td><%= e.getId() %></td><td><%= e.getEname() %></td>
									<td><%= e.getSalary() %></td><td><%= e.getAge() %></td>
									<td>
									<a href="del.do?id=<%= e.getId()%>" 
										onclick="return confirm('确定删除<%=e.getEname()%>');">删除</a>&nbsp;
									<a href="load.do?id=<%=e.getId() %>">修改</a>
									</td>
								</tr>
								<%
								
							}
						%> --%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加员工" 
							onclick="location='toAdd.do'"/>
					</p>
				</div>
			</div>
				<%@ include file="footer.jsp" %>			
		</div>
	</body>
</html>
