<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加图书</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bookAdd.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bookAdd.js"></script>

</head>
<body>
	<div class="x">
		<font size="5" align="center" style="color:green;">
 			<p>管理员增加图书</p>
		</font>
		<form action="BookMServlet?type=bookAdd" method="post" name="form1">
			<table border="0" cellpadding="2" width="550" align="center">
				<tr>
					<td align="right">图书ID：</td>
					<td>
						<input type="text" id="bookid" name="bookid" placeholder="请输入图书ID" onblur="idCheck();" />
						<font id="idmsg" size="2" style="color:red;"></font>
					</td>

				</tr>
				<tr>
					<td align="right">名字：</td>
					<td>
						<input type="text" name="bookname" id="bookname" onblur="nameCheck();">
						<font id="namemsg" size="2" style="color:black;"></font>
					</td>
				</tr>
				<tr>
					<td align="right">类型：</td>
					<td>
						<input type="radio" name="booktype" value="成年" checked="checked">成年
						<input type="radio" name="booktype" value="未成年">未成年
					</td>
				</tr>
				<tr>
					<td align="right">数量（/本）：</td>
					<td>
						<input type="text" name="bookstock" id="bookstock" onblur="stockCheck();">
						<font id="stockmsg" size="2" style="color:red;"></font>
					</td>
					
				</tr>
				<tr>
					<td align="right">价格：</td>
					<td>
						<input type="text" name="bookprice" id="bookprice" onblur="priceCheck();">
						<font id="pricemsg" size="2" style="color:red;"></font>
					</td>
					
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<input type="submit" value="确认" onclick="subCheck();">
					</td>
					
				</tr>
			</table>
		</form>
		<button onclick="location='welcomeM.jsp'" >返回</button>
	</div>
</body>
</html>