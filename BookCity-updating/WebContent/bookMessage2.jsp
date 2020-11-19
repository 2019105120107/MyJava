<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.lhz.jsj.javabean.TBook,cn.lhz.jsj.dao.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户查询图书</title>
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
	TBook tbook = (TBook)session.getAttribute("selBook_typeinfo");
	IBookCityM ibcm = new IBookCityMImpl();
	List<TBook> booklist = ibcm.bookTypeSel(tbook);
%>
	<div class="xian">
		<form action="CartMServlet?type=bookMCart" method="post">
			<font size="4" ><p>您查找的图书为：</p></font>
			<table border="1" cellspacing="0" cellpadding="0" >
				<tr>
					<th colspan="6">书籍信息</th>
				</tr>
				<tr>
					<th>书名</th>
					<th>图书类型</th>
					<th>图书库存量</th>
					<th>图书单价</th>
					
				</tr>
					<%
						for(int i=0;i<booklist.size();i++){
					%>
					
					<tr align="center" >
						<td><font color="green"><% out.print(booklist.get(i).getBookName()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookType()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookStock()); %></font></td>
						<td><font color="green"><% out.print(booklist.get(i).getBookPrice()); %></font></td>
						
					</tr>
					<%	} %>
			</table>
			<p>
				<a href="cart.jsp">查看购物车</a>
			</p>
		</form>
		<button onclick="location='selBook_type.jsp'">返回</button>
	</div>
</body>
</html>