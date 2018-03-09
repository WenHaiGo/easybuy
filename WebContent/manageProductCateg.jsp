<%@page import="com.easybuy.dbutils.CategUtils"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			<div class="main">
				<h2>分类管理</h2>
				<%
					List<CategUtils> CUList = (List<CategUtils>) request.getAttribute("CUList");
				%>
				<div class="manage">
					<table class="list">
						<tr>
							<th>ID</th>
							<th>分类名称</th>
							<th>操作</th>
						</tr>
						<%
							for (int i = 0; i < CUList.size(); i++) {
						%>

						<tr>
							<td class="first w4 c"><%=CUList.get(i).getId()%></td>
							<td><%=CUList.get(i).getName()%></td>
							<td class="w1 c"><a
								href="CategServlet?param=updateCateg&id=<%=CUList.get(i).getId()%>">修改</a>
								<a
								href="CategServlet?param=delCateg&categId=<%=CUList.get(i).getId()%>">删除</a></td>
						</tr>
						<%
							for (int j = 0; j < CUList.get(i).getList().size(); j++) {
						%>
						<tr>
							<td class="first w4 c"><%=CUList.get(i).getList().get(j).getEPCId()%></td>
							<td class="childClass"><%=CUList.get(i).getList().get(j).getEPCName()%></td>
							<td class="w1 c"><a
								href="CategServlet?param=updateCateg&id=<%=CUList.get(i).getList().get(j).getEPCId()%>">修改</a>
								<a
								href="CategServlet?param=delCateg&categId=<%=CUList.get(i).getList().get(j).getEPCId()%>">删除</a></td>
						</tr>

						<%
							}
						%>
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
