<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updatePwd.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/updatePwd.js"></script>
</head>
<body>
	<div id="xi">
		<font size="5" align="center" style="color:green;">
 			<p>用户修改密码</p>
		</font>
		<form action="BookMServlet?type=update" method="post">
			<table border="0" cellpadding="2" width="500" align="center">
				<tr>
					<td align="right">原密码：</td>
					<td>
						<input type="password" name="oldpwd" id="oldpwd" />
						<font id="codemsg1" size="2" style="color:red;"></font>
					</td>
				</tr>
				<tr>
					<td align="right">新密码：</td>
					<td>
						<input type="password" name="newpwd" id="newpwd" onblur="codeCheck2();"/>
						<font id="codemsg2" size="2" style="color:red;"></font>
					</td>
				</tr>
				<tr>
					<td align="right">再输入一次新密码：</td>
					<td>
						<input type="password" name="code3" id="code3" onblur="codeCheck3();"/>
						<font id="codemsg3" size="2" style="color:red;"></font>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<input type="submit" name="submit" value="确认" />
					</td>
				</tr>
			</table>
		</form>
		<button onclick="location='welcomeC.jsp'" >返回</button>
	</div>
</body>
</html>