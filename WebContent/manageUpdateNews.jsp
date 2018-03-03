<%@page import="com.easybuy.model.ENews"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
	<%@ include file="manageHeader.jsp"%>
	<!--加载常用头部导航栏  -->

	<div id="main" class="wrap">
		<%@ include file="manageMenu.jsp"%>
		<div class="main">
			<h2>修改新闻</h2>
			<div class="manage">
				<%
					System.out.print("dsuigdfshdfguhilgnijio");
					ENews news = (ENews) request.getAttribute("news");
				%>
				<form
					action="ManageOperateServlet?param=submitUpdateNews&submitUpdateNewsId=<%=news.getENId()%>"  method="post">
					<table class="form">
						<tr>

							<td class="field">新闻标题：</td>
							<td><input type="text" class="text" name="title"
								value="<%=news.getENTitle()%>" /></td>
						</tr>
						<tr>
							<td class="field">新闻内容：</td>
							<td><textarea name="content"><%=news.getENContent()%></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="修改" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
