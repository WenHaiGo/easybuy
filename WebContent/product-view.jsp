<%@page import="com.easybuy.model.EProduct"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<!--我认为必要的代码还是要有的  这样会让人知道页面的基本结构是什么  -->
	<div id="header" class="wrap">
	<!--从js里面加载头部页面  -->
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a>
		&gt; 图书
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<div class="box">
				<h2>商品分类</h2>
				<dl id="leftNav">
				</dl>
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
		<div id="product" class="main">
			<%
				EProduct e = (EProduct) request.getAttribute("EProduct");
			%>
			<h1><%=e.getEPName() %></h1>
			<div class="infos">
				<div class="thumb">
					<img src=<%=e.getEPFile() %> />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price"><%=e.getEPPrice() %></span>
					</p>
					
					<p>
						销售数量：<span class="price"><%=e.getEPSaleNum() %></span>
					</p>
					<p>库 存：<%=e.getEPStock() %></p>

					<div class="button">
						<input type="button" name="button" value="" onclick="goBuy(1)" /><a
							href="#">放入购物车</a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
				<br /> <%=e.getEPDesc() %><br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
