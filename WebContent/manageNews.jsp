<%@page import="com.easybuy.model.ENews"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
	<!-- 加载头部文件 -->
	<%@ include file="manageHeader.jsp"%>
	<!--加载常用头部导航栏  -->

	<div id="main" class="wrap">
		<%@ include file="manageMenu.jsp"%>
		<div class="main">
			<h2>新闻管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>ID</th>
						<th>新闻标题</th>
						<th>操作</th>
					</tr>
					<%
						List<ENews> allNews = (List) request.getAttribute("allNews");
						for (int i = 0; i < allNews.size(); i++) {
					%>
					<tr>
						<td class="first w4 c"><%=allNews.get(i).getENId()%></td>
						<td><%=allNews.get(i).getENTitle()%></td>
						<td class="w1 c"><a
							href="ManageOperateServlet?param=updateNews&updateNewsId=<%=allNews.get(i).getENId()%>">修改</a>
							<a href="ManageOperateServlet?param=delNews&delNewsId=<%=allNews.get(i).getENId()%>">删除</a></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
