<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="index.html">首页</a></li>
				<li><a href="user.html">用户</a></li>
				<li><a href="product.html">商品</a></li>
				<li><a href="order.html">订单</a></li>
				<li><a href="guestbook.html">留言</a></li>
				<li><a href="news.html">新闻</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">
			<!--读取当前用户  -->
			管理员<%=(String) session.getAttribute("manageUser")%>您好，今天是<%=new Date(System.currentTimeMillis())%>，欢迎回到管理后台。
		</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
	</div>

</body>
</html>