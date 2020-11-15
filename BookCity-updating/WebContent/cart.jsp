<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.lhz.jsj.javabean.*,cn.lhz.jsj.dao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
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
<%
	Cart cart = (Cart)session.getAttribute("cart");
	
%>
	<div class="xian">
		<p>您目前购买的图书为：</p>
			<table border="1" cellspacing="0" cellpadding="0" >
				<tr>
					<th colspan="6">书籍信息</th>
				</tr>
				<tr>
					<th>ID</th>
					<th>书名</th>
					<th>图书类型</th>
					<th>购买数量</th>
					<th>图书单价</th>
					
				</tr>
					<tr align="center" >
						<td><font color="green"><%=cart.getBookId()%></font></td>
						<td><font color="green"><%=cart.getBookName()  %></font></td>
						<td><font color="green"><%=cart.getBookType()%></font></td>
						<td><font color="green"><%=cart.getBookStock() %></font></td>
						<td><font color="green"><%=cart.getBookPrice() %></font></td>
						<c:set value="${ cart.getBookPrice()*cart.getBookStock()}" var="total"></c:set>
					</tr>
			</table>
			<p>目前您的购物车总价格为：${total }元</p>
			<a href="downloadSell.jsp">订单下载</a>
			<button onclick="location='chooseBook.jsp'">返回</button>
	</div>
</body>
</html>