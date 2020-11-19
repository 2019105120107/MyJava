<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书查询</title>
<style type="text/css">
	body,input{
		margin:5;
		padding:5;
		background:grey;
	}
	input{
		background:#ffffcc;
	}
	.xian{
		height:600px;
		width:800px;
		margin:0 auto;
		background:#ffffff;
		border:5px solid #ccc;
	}
</style>
</head>
<body>
	<div class="xian">
		<form action="BookMServlet?type=bookQuery" method="post">
			请输入您所要查询图书的ID：<br>
			<input type="text" id="bookid" name="bookid">
			<input type="submit" value="确认">
		</form>
		<button onclick="location='welcomeM.jsp'">返回</button>
	</div>
</body>
</html>