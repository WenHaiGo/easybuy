<%@page import="com.easybuy.model.EUser"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" import="com.easybuy.model.EProduct"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>

	<%@ include file="manageHeader.jsp"%>
	<!-- 引入菜单文件 -->

	<div id="main" class="wrap">
		<!--左侧分类  -->
		<%@ include file="manageMenu.jsp"%>
		<div class="main">
			<h2>用户管理</h2>

			<div class="manage">
				<table class="list">
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>性别</th>
						<th>Email</th>
						<th>手机</th>
						<th>操作</th>
					</tr>
					<%
						List<EUser> allUser = (List) request.getAttribute("allUser");
						for (int i = 0; i < allUser.size(); i++) {
					%>
					<tr>
						<td class="first w4 c"><%=allUser.get(i).getId()%></td>
						<td class="w1 c"><%=allUser.get(i).getEUId()%></td>
						<td class="w2 c"><%=allUser.get(i).getEUSex()%></td>
						<td><%=allUser.get(i).getEUEmail()%></td>
						<td class="w4 c"><%=allUser.get(i).getEUMoible()%></td>
						<td class="w1 c">
							<a href="ManageOperateServlet?param=updateUser&updateId=<%=allUser.get(i).getId()%>">修改</a> <a
							<a
							href="ManageOperateServlet?param=delUser&id=<%=allUser.get(i).getId()%>">删除</a>
						</td>
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
