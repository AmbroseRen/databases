<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="config.jsp" %>
<%@include file="plugins.jsp" %>
<%-- <%@ page import="java.util.* " %> --%> 
<!-- jsp空白过滤 -->
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>temp</title>
<link href="${root}/css/temp.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

</style>

<script type="text/javascript" src="${root}/js/demo.js"></script>
<script type="text/javascript">
$(function(){
	alert("初始化加载！");
})
function main(){
	alert("test");
//	window.location.href='${pageContext.request.contextPath}/cab/mainPage';
}
</script>
</head>
<body>
	<div id="" class="" style="" onclick="main()">
		<button>test</button>
	</div>
	<%-- 选择菜单 --%>
	<div class="layui-layer layui-layer-page layui-layer-molv layer-anim" id="menuLayer" type="page" times="2" showtime="0" contype="object"
		style="z-index: 19891016; width: 300px; height: 450px; top: 100px; left: 500px; display:none">
		<div class="layui-layer-title" style="cursor: move;">选择菜单</div>
		<div class="layui-layer-content" style="height: 358px;">
			<div style="padding: 10px;" class="layui-layer-wrap">
				<ul id="menuTree" class="ztree"></ul>    <%-- 动态加载树 --%>
			</div>
		</div>
		<span class="layui-layer-setwin"> <a class="layui-layer-ico layui-layer-close layui-layer-close1 btn_cancle" ></a></span>
		<div class="layui-layer-btn layui-layer-btn-">
			<a class="layui-layer-btn0 btn-confirm">确定</a>
			<a class="layui-layer-btn1 btn-cancle">取消</a>
		</div>
	</div>
	<div>
	
	</div>
</body>
</html>