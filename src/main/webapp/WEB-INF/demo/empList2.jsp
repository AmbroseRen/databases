<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="AmbroseRen.system.dao.impl.*,AmbroseRen.system.entity.*,java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%
								Date date =new Date();							
								SimpleDateFormat sdf =
										new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");						
							%>
							<%=sdf.format(date) %>
							<br />
						</p>
					</div>

					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
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
							<td>年龄</td>
							<td>薪水</td>
							<td>操作</td>
						</tr>
						<%
							EmployeeDAO dao =new EmployeeDAO();
							List<Employee> es =dao.findAll();
							for(int i=0;i<es.size();i++){
								Employee e =es.get(i);
								%>
								<tr  class="row<%=(i % 2 + 1)%>">
									<td><%= e.getId() %></td><td><%= e.getEname() %></td>
									<td><%= e.getSalary() %></td><td><%= e.getAge() %></td>
									<td>
									<a href="emplist.html">删除</a>&nbsp;
									<a href="updateEmp.html">修改</a>
									</td>
								</tr>
								<%
								
							}
						%>
						<tr class="row1">
							<td>1</td><td>zhangshan</td>
							<td>20000</td><td>20</td>
							<td>
								<a href="emplist.html">删除</a>&nbsp;
								<a href="updateEmp.html">修改</a>
							</td>
						</tr>
						<tr class="row2">
							<td>2</td><td>lishi</td>
							<td>20000</td><td>20</td>
							<td>
								<a href="emplist.html">删除</a>&nbsp;
								<a href="updateEmp.html">修改</a>
							</td>
							
						</tr>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" 
							onclick="location='addEmp.html'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
