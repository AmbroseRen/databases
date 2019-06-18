<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%-- <%@ page import="entity.*" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>修改信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改员工:
					</h1>
					<%-- <%
						Employee e =(Employee)request.getAttribute("e");
					%> --%>
					<%-- <c:forEach items="employee" var="e" varStatus="i">
					</c:forEach> --%>
					<form action="update.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign="middle" align="right">
									ID:
								</td>
								<td valign="middle" align="left">
									${e.id }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ename" 
										value="${e.ename }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary"
										value="${e.salary }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" 
										value="${e.age }"/>
								</td>
							</tr>
						</table>
						<input type="hidden" name="id" value="${e.id }"/>
						<p>
							<input type="submit" class="button" value="确定" />
						</p>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>
