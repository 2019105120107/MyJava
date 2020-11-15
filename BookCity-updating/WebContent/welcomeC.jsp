<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/welcome.css">
</head>
<body>
	<div class="xian">
		<font size="6" color="black">
			<p>欢迎账号为 ${userinfo.userAccount}的用户的使用,您可以</p>
		</font><br>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="updatePwd.jsp"><font size="4" color="green">修改密码</font></a><br>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="selBook.jsp"><font size="4" color="green">按类型/书名查询图书</font></a><br>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="chooseBook.jsp"><font size="4" color="green">选购图书</font></a><br>
		&nbsp;&nbsp;&nbsp;&nbsp;
		
		<table border="1" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<th colspan="6">当前拥有书籍信息</th>
				</tr>
				<tr>
					<td>ID</td>
					<td>书名</td>
					<td>图书类型</td>
					<td>图书库存量</td>
					<td>图书单价</td>
		
				</tr>
				<tr >
					<td>1</td>
					<td>老人与海</td>
					<td>成年</td>
					<td>100</td>
					<td>21.5</td>
				</tr>
				<tr >
					<td>2</td>
					<td>咆哮</td>
					<td>成年</td>
					<td>150</td>
					<td>30.0</td>
				</tr>
			</table>
		
		<button onclick="location='login.jsp'">退出</button>
		
	</div>
</body>
</html>