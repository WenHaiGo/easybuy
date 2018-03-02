<%@page import="com.easybuy.model.EUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header" class="wrap" >
		<!--加载中间主要页面-->
		<div id="logo">
			<a href="index.jsp"><img src="images/logo.gif" /></a>
		</div>
		<%
			String userName = (String) session.getAttribute("userName");
		%>

		<div class="help">
			<a href="UserActionServlet?param=cart" class="shopping">购物车</a> <a href="login.jsp"><%=userName == null ? "登陆" : userName%></a>
			<a href="register.html">注册</a> <a href="guestbook.html">留言</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
</body>
</html>