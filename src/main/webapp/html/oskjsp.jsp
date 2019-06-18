<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>软件盘</title>
<script>
function ad(str)
{
document.form1.p1.value = document.form1.p1.value + str;
}
</script>
</head>
<body>
<form method=post action="" name="form1">
密码:<input type="password" name="p1">
</form>
<input type="button" onclick="alert(document.form1.p1.value)" value="察看输入值">
<br><br><br><center>软件盘</center><br>
<a href=":ad('a')">a</a> <a href="javascript:ad('b')">b</a> <a href="javascript:ad('c')">c</a> <a href="javascript:ad('d')">d</a> <a href="javascript:ad('e')">e</a> <a href="javascript:ad('f')">f</a> <a href="javascript:ad('g')">g</a> <a href="javascript:ad('h')">h</a> <a href="javascript:ad('i')">i</a> <a href="javascript:ad('j')">j</a> <a href="javascript:ad('k')">k</a> <a href="javascript:ad('l')">l</a> <a href="javascript:ad('m')">m</a><br>
<a href="javascript:ad('n')">n</a> <a href="javascript:ad('o')">o</a> <a href="javascript:ad('p')">p</a> <a href="javascript:ad('q')">q</a> <a href="javascript:ad('r')">r</a> <a href="javascript:ad('s')">s</a> <a href="javascript:ad('t')">t</a> <a href="javascript:ad('u')">u</a> <a href="javascript:ad('v')">v</a> <a href="javascript:ad('w')">w</a> <a href="javascript:ad('x')">x</a> <a href="javascript:ad('y')">y</a> <a href="javascript:ad('z')">z</a><br><br>
<a href="javascript:ad('1')">1</a> <a href="javascript:ad('2')">2</a> <a href="javascript:ad('3')">3</a> <a href="javascript:ad('4')">4</a> <a href="javascript:ad('5')">5</a> <a href="javascript:ad('6')">6</a> <a href="javascript:ad('7')">7</a> <a href="javascript:ad('8')">8</a> <a href="javascript:ad('9')">9</a> <a href="javascript:ad('0')">0</a>
</body>
</html>