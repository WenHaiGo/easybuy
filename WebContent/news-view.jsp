<%@page import="com.easybuy.model.ENews"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
</html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="childNav"></div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 阅读新闻
	</div>
	<div id="main" class="wrap">
		<div class="left-side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.html" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul id="showNews">
					<!--全部使用jquery动态生成ajax的应用  -->

				</ul>
			</div>
		</div>
		<div id="news" class="right-main">
			<h1>铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机</h1>
			<div class="content">
				<%
					ENews e = (ENews) request.getAttribute("newsContent");
				%>
				<p><%=e.getENContent()%></p>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
