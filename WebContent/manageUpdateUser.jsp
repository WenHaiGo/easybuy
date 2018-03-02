<%@page import="com.easybuy.model.EUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><html xmlns="http://www.w3.org/1999/xhtml">
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
			<h2>修改用户</h2>
			<div class="manage">
				<!-- 得到从manageUser.jsp要删除用户的id -->
				<%
					EUser user = (EUser) request.getAttribute("user");
				%>
				<form
					action="ManageOperateServlet?param=submitUpdate&submitUpdateId=<%=user.getId()%>"
					method="post">
					<table class="form">
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" class="text" name="userName"
								value="<%=user.getEUId()%>" /></td>
						</tr>
						<tr>
							<td class="field">姓名：</td>
							<td><input type="text" class="text" name="name"
								value="<%=user.getEUName()%>" /></td>
						</tr>
						<tr>
							<td class="field">密码：</td>
							<td><input type="text" class="text" name="passWord"
								value="<%=user.getEUPwd()%>" /></td>
						</tr>
						<tr>
							<td class="field">性别：</td>
							<td><input type="radio" name="sex" value="1"
								checked="checked" />男 <input type="radio" name="sex" value="1" />女</td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><select name="birthyear">
									<option value="2000">2000</option>
									<option value="1999">1999</option>
							</select>年 <select name="birthmonth">
									<option value="12">12</option>
									<option value="11">11</option>
							</select>月 <select name="birthday">
									<option value="2">2</option>
									<option value="1">1</option>
							</select>日</td>
						</tr>
						<tr>
							<td class="field">手机号码：</td>
							<td><input type="text" class="text" name="mobile"
								value="<%=user.getEUMoible()%>" /></td>
						</tr>
						<tr>
							<td class="field">送货地址：</td>
							<td><input type="text" class="text" name="address"
								value="<%=user.getEUAddress()%>" /></td>
						</tr>
						<tr>
							<td class="field">头像：</td>
							<td><input type="file" class="text" name="photo" /></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="添加" /></label></td>
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
