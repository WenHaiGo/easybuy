<%@page import="com.easybuy.model.ENews"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script>
	$(function() {
		//失去焦点的时候利用ajax判断用户名是否存在【注意】网络太慢应该会导致延迟
		//得到用户名
		$
				.ajax({
					url : 'ShowNewsServlet',
					type : 'post',
					data : {
						param : 'newsListPage',
					},
					dataType : 'json',
					success : function(data) {
						for (var i = 0; i < data.length; i++) {
							var href = 'ShowNewsServlet?param=newsDetailPage&newsTitle='+data[i].ENTitle;
							//var news = $('<li><a href='+href+'>'
								//	+ data[i].ENTitle + '</a></li>');
							$("#showNews").append('<li><a href='+href+'>'
									+ data[i].ENTitle + '</a></li>');
						}
					}
				})

	})
</script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a
				href="register.html">注册</a><a href="guestbook.html">留言</a>
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
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
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
