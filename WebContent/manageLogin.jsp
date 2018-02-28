<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function-manage.js"></script>
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
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="cornerrt"></em>
			<div class="box">
				<!-- 如果检测到点击购物车进入就触发这个操作 -->
				<h1>欢迎进入后台管理登陆页面</h1>
				<form id="loginForm" method="post">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" id="userName"
								name="EUId" /><span></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="password"
								name="EUPwd" /><span></span></td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><input class="text verycode" type="text" name="veryCode" /><img
								id="veryCode" src="" /><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="button" name="立即登录" value="立即登录"
									onclick="manageCheckLogin(this)">立即登录</button></td>
							<td><span id="loginSpan" style="display: none">账号或者密码错误</span></td>
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
