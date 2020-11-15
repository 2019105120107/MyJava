<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.lhz.jsj.javabean.TBook,cn.lhz.jsj.dao.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书信息</title>
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
	TBook tbook = (TBook)session.getAttribute("bookqueryinfo");
	IBookCityM ibcm = new IBookCityMImpl();
	List<TBook> booklist = ibcm.queryBook(tbook);
%>
	<div class="xian">
			<table border="1" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<th colspan="6">书籍信息</th>
				</tr>
				<tr>
					<td>书名</td>
					<td>图书类型</td>
					<td>图书库存量</td>
					<td>图书单价</td>
		
				</tr>
					<%
						for(int i=0;i<booklist.size();i++){
					%>
					<tr align="center">
						<td><font color="green"><% out.print(booklist.get(i).getBookName()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookType()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookStock()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookPrice()); %></font></td>
					</tr>
					<%	} %>
			</table>
			<button onclick="location='bookQuery.jsp'">返回</button>
	</div>
</body>
</html>