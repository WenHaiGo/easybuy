<%@page import="com.easybuy.model.EPCateg"%>
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
				<h2>修改分类</h2>
				<div class="manage">
					<%
						List<CategUtils> allCateg = (List<CategUtils>) request.getAttribute("allCateg");
						EPCateg currentCateg = (EPCateg) request.getAttribute("currentCateg");
					%>
					<form
						action="CategServlet?param=submitUpdate&id=<%=currentCateg.getEPCId()%>"
						method="post">
						<table class="form">
							<tr>
								<td class="field">父分类：</td>

								<td><select name="parentId">
										<option value="0" selected="selected">根栏目</option>
										<%
											for (int i = 0; i < allCateg.size(); i++) {
										%>
										<option><%=allCateg.get(i).getName()%></option>
										<%
											}
										%>

								</select></td>
							</tr>
							<tr>
								<td class="field">分类名称：</td>
								<td><input type="text" class="text" name="className"
									value="<%=currentCateg.getEPCName()%>" /></td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="更新" /></label></td>
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
