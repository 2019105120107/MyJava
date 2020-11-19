<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新图书的数量</title>
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
		<form action="BookMServlet?type=bookUpdate" method="post">
			请输入您所要更新图书的ID：<br>
			<input type="text" id="bookid" name="bookid"><br>
			您还可以增加图书或者减少图书后的数量（增加或减少两项只可二选一）：<br>
			增加：<input type="text" id="bookadd" name="bookadd" value="请输入增加后图书数量"><br>
			减少：<input type="text" id="bookcut" name="bookcut" value="请输入减少后图书的数量"><br>
			
			<input type="submit" value="确认">
		</form>
		<button onclick="location='welcomeM.jsp'">返回</button>
	</div>
</body>
</html>