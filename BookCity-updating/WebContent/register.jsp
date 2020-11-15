<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<div class="x">
		<font size="5" align="center" style="color:green;">
 			<p>顾客用户注册</p>
		</font>
		<form action="BookMServlet?type=register" method="post" name="form1">
			<table border="0" cellpadding="2" width="550" align="center">
				<tr>
					<td align="right">账号：</td>
					<td>
						<input type="text" id="useraccount" name="useraccount" placeholder="请输入账号" onblur="userCheck();" />
						<font id="usermsg" size="2" style="color:red;"></font>
					</td>

				</tr>
				<tr>
					<td align="right">密码：</td>
					<td>
						<input type="password" name="userpassword" id="userpassword" onblur="codeCheck2();">
						<font id="codemsg0" size="2" style="color:black;">密码长度为8-20位，不区分大小写</font>
					</td>
				</tr>
				<tr>
					<td align="right">再次输入密码：</td>
					<td>
						<input type="password" name="userpasswordr" id="userpasswordr" onblur="codeCheck();">
						<font id="codemsg" size="2" style="color:red;"></font>
					</td>
				</tr>
				<tr>
					<td align="right">电话：</td>
					<td>
						<input type="text" name="phone" id="phone" onblur="phoneCheck();">
						<font id="phonemsg" size="2" style="color:red;"></font>
					</td>
					
				</tr>
				<tr>
					<td align="right">地址：</td>
					<td>
						<input type="text" name="address" id="address" onblur="addrCheck();">
						<font id="addrmsg" size="2" style="color:red;"></font>
					</td>
					
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<input type="submit" value="注册" onclick="subCheck();">
						<a href="login.jsp">已有账号？去登陆</a>
					</td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>