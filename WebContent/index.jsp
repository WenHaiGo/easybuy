<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>

<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<!--我认为必要的代码还是要有的  这样会让人知道页面的基本结构是什么  -->
	<!--加载头部页面-->
	<%@ include file="header.jsp"%>
	<div id="childNav"></div>
	<div id="main" class="wrap">
		<div class="lefter">
			<!--加载左侧分类页面-->
			<div class="box">
				<h2>商品分类</h2>
				<dl id="leftNav"></dl>
			</div>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
					<dt>
						<img src="images/product/0_tiny.gif" />
					</dt>
					<dd>
						<a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a>
					</dd>
					<dt>
						<img src="images/product/0_tiny.gif" />
					</dt>
					<dd>
						<a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a>
					</dd>
				</dl>
			</div>
		</div>
		<!--进入第二个主页面中间  -->
		<div class="main">
			<div class="price-off">
				<h2>今日特价</h2>
				<ul class="product clearfix" id="special_price">
					<!--  ajax会动态的加载数据-->
				</ul>
			</div>
			<div class="side">
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
					<!--全部使用jquery动态生成ajax的应用  -->
					<ul id="showNews"></ul>
				</div>
			</div>
			<div class="spacer clear"></div>
			<div class="hot">
				<h2>热卖推荐</h2>
				<ul class="product clearfix" id="hotProduct">
				</ul>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">
		<a style="" href="ManageUserActionServlet">后台管理</a> Copyright
		&copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
	</div>
</body>

</html>