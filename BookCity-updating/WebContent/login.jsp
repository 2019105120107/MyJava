<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登陆</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div id="xi">
		<font size="5" align="center" style="color:green;">
 			<p>欢迎来到WeAre书城</p>
		</font>
		<form action="BookMServlet?type=login" method="post">
			<table border="0" cellpadding="2" width="400" align="center">
				<tr>
					<td align="right">账号：</td>
					<td>
						<input type="text" id="useraccount" name="useraccount" placeholder="请输入账号" />
					</td>

				</tr>
				<tr>
					<td align="right">密码：</td>
					<td>
						<input type="password" name="userpassword" id="userpassword"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<input type="submit" name="submit" value="登录" />
						<a href="register.jsp">注册</a>
						<a href="loginM.jsp">管理员登录</a>
					</td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>