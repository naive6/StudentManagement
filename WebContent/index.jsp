<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type=text]:FOCUS {
	border: 3px solid #555;
}

input[type=text] {
	border: 3px solid #ccc;
	height: 30px;
}

input[type=password]:FOCUS {
	border: 3px solid #555;
}

input[type=password] {
	border: 3px solid #ccc;
	height: 30px;
}

p {
	font-family: "Times New Roman", Times, serif;
	font-size: 35px;
	font-style: normal;
}
.containter{
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<div class="panel">
		<div class="containter">
			<form action="" name="form1" method="post">
				<p>
					用户名：<input type="text" name="username" />
				</p>
				<p>
					密码：<input type="password" name="password" />
				</p>
				<input type="submit" value="登录"
					onclick="form1.action='<%=path%>/user/User_login.action';form1.submit">
				<input type="submit" value="注册"
					onclick="form1.action='<%=path%>/user/User_register.action';form1.submit">
			</form>
		</div>
	</div>
</body>
</html>