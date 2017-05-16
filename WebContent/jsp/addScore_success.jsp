<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成绩成功</title>
</head>
<body>
	<form action="" name="form1" method="post">
		<p>
			学号：<input type="text" name="sid">
		</p>
		<p>
			姓名：<input type="text" name="sname">
		</p>
		<p>
			性别：<input type="text" name="gender">
		</p>
		<p>
			地址：<input type="text" name="address">
		</p>
		<p>
			<input type="submit" value="添加" onclick="form1.action='<%=path%>/student/Student_add.action';form1.submit">
		</p>
		<p>
			<input type="submit" value="修改" onclick="form1.action='<%=path%>/student/Student_update.action';form1.submit">
		</p>
	</form>
</body>
</html>