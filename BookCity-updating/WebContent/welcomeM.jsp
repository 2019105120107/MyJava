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
			<p>欢迎账号为 ${admininfo.adAccount}的管理员的使用，您可以有以下操作：</p>
			</font>
			<a href="bookAdd.jsp"><font size="4">增加图书</font></a>&nbsp;&nbsp;
			<a href="bookDel.jsp"><font size="4">删除图书</font></a><br>
			<a href="bookUpdate.jsp"><font size="4">修改图书数量</font></a>&nbsp;&nbsp;
			<a href="bookQuery.jsp"><font size="4">查询图书</font></a><br>
			<a href="checkSell.jsp"><font size="4">查看销售榜单</font></a>&nbsp;&nbsp;
			<a href="downloadSell.jsp"><font size="4">下载销售数据</font></a><br>
			
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