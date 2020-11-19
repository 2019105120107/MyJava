<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查找图书</title>
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
		<form action="" method="post">
			<tr>
				<td></td>
				<td>
					<a href="selBook_type.jsp">
						<font size="4" color="pink">
							<p>按类型查找图书：</p>
						</font>
					</a>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="selBook_name.jsp">
						<font size="4" color="pink">
							<p>按书名查找图书：</p>
						</font>
					</a>
				</td>
			</tr>
			
		</form>
		<button onclick="location='welcomeC.jsp'" >返回</button>
	</div>
</body>
</html>