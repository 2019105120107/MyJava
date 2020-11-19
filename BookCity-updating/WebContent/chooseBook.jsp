<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选购图书</title>
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
		<form action="CartMServlet?type=choose" method="post">
			<font size="3"> 请选择要购买的图书编号和数量：</font><br>
				编号：<input type="text"  name="choosebookid" id="choosebookid" placeholder="图书编号" "/><br>
				数量：<input type="text"  name="choosebooknum" id="choosebooknum" placeholder="购买数量" "/>
				&nbsp;&nbsp;
			<button type="submit" >加入购物车</button>
		</form>
		<button onclick="location='welcomeC.jsp'">返回</button>
	</div>
</body>
</html>