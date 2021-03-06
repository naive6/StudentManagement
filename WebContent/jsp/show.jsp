<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<%
	String path=request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table{
border-collapse: collapse;/* 表格的边框合并为一个边界 */
width: 100%;/* 表格宽度 */
}
table,th,td{
border:1px solid black;/* 为表格设置边框*/
}
th,td{
padding: 15px;/* 控制边框和表格内容之间的空间 */
}
th{
text-align: left;/* 表头左对齐 */
background-color: #4169e1; /*给表头设置背景颜色  */
color: white;
}
tr:NTH-CHILD(even) {
	background-color:  #f2f2f2;/* 对于斑马条纹表格，使用nth-child()选择器并添加background-color到所有偶数（或奇数）表行 */
}
#button1,#button2{
	border-radius: 10px;/*把元素设置为圆角 */
	background-color: #4169e1;/*背景颜色  */
	color: white;/* 字体颜色*/
	padding: 20px; /*  */
    width: 120px;
    height: 50px; 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	<div class="button" >
		<input type="button" id="button1" onclick="window.location.href='<%=path%>/jsp/addScore.jsp'" value="添加学生信息" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
		<input type="button" id="button2" onclick="window.location.href='<%=path%>/jsp/addScore_success.jsp'" value="修改学生信息" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
		<%-- <a href="<%=path%>/jsp/addScore_success.jsp">修改学生信息</a> --%>
	</div>
	<div>
		<table >
			<tr class="title">
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>地址</th>
				<th>成绩编号</th>
				<th>删除</th>
				<th>成绩查询</th>
			</tr>
				<s:iterator value="#session.studentList" var="stu">
			<tr class="list">
				<td><s:property value="#stu.sid"/></td>
				<td><s:property value="#stu.sname"/></td>
				<td><s:property value="#stu.gender"/></td>
				<td><s:property value="#stu.address"/></td>
				<td><s:property value="#stu.score.getScid()"/></td>
				<td><a href="<%=path%>/student/Student_delete.action?sid=<s:property value="#stu.sid"/>" onclick="javascript: return confirm('是否确定删除')">删除</a></td>
				<td><a href="<%=path%>/score/Score_query.action?scid=<s:property value="#stu.score.getScid()"/>&sid=<s:property value="#stu.sid"/>" >查询成绩</a></td>
			</tr>
				</s:iterator>
		</table>
	</div>
</body>
</html>