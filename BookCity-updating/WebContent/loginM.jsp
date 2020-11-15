<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div id="xi">
		<font size="5" align="center" style="color:green;">
 			<p>管理员用户登录</p>
		</font>
		<form action="BookMServlet?type=loginM" method="post">
			<table border="0" cellpadding="2" width="400" align="center">
				<tr>
					<td align="right">账号：</td>
					<td>
						<input type="text" id="adaccount" name="adaccount" placeholder="请输入账号" />
					</td>

				</tr>
				<tr>
					<td align="right">密码：</td>
					<td>
						<input type="password" name="adpassword" id="adpassword"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<input type="submit" name="submit" value="登录" />
					</td>
					<td><a href="login.jsp">返回普通用户登录</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>