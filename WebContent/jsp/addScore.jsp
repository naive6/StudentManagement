<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path=request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生成绩</title>
</head>
<body>
	<form action="" name="form2" method="post">
	<p>数学成绩：<input type="text" name="math"></p>
	<p>语文成绩：<input type="text" name="chinese"></p>
	<p>英语成绩：<input type="text" name="english"></p>
	<p>&nbsp;<input type="submit" value="添加" onclick="form2.action='<%=path%>/score/Score_add.action';form2.submit"></p>
	<p>&nbsp;<input type="submit" value="修改" onclick="form2.action='<%=path%>/score/Score_update.action';form2.submit"></p>
	</form>
</body>
</html>