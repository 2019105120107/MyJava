<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按照图书的类型查找图书</title>
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
		<form action="BookMServlet?type=selBook_type" method="post" id="searchform">
			<table width="100%" border="0" cellpadding="0">
				<tr>
					<td style="text-align:right;padding-right:220px">
						按图书类型（成年/未成年）搜索:
						<input type="text" name="textfield" id="textfield" value="请输入图书类型"
						onmouseover="this.focus();"
						onclick="myclick(this,'textfield');"
						onBlur="myblur(this,'textfield');">
						<input type="submit" value="确认">
					</td>
				</tr>
			</table>
		</form>
		<button onclick="location='welcomeC.jsp'">返回</button>
	</div>
</body>
</html>