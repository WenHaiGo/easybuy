<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<div id="childNav">
		<div class="welcome wrap">
			管理员<%=(String) session.getAttribute("manageUser")%>您好，今天是<%=new Date(System.currentTimeMillis())%>，欢迎回到管理后台。
		</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="productClass-add.html">新增</a></em><a
							href="productClass.html">分类管理</a>
					</dd>
					<dd>
						<em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="order.html">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="guestbook.html">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>管理首页</h2>
			<div id="welcome" class="manage">
				<div class="shadow">
					<em class="corner lb"></em> <em class="corner rt"></em>
					<div class="box">
						<div class="msg">
							<p>欢迎回来</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
