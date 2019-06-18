<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bmi</title>
</head>
	<body style="font-size:30px;color:red;">
		<form action="bmiO.d" method="post">
			<fieldset>
				<legend>计算bmi指数</legend>
				身高（米）:<input name="height"/>
				体重（公斤）：<input name="weight"/>
				<input type="submit" value="提交"/>
			</fieldset>
		</form>
	</body>
</html>