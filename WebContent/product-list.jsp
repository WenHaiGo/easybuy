<%@page import="com.easybuy.model.EProduct"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap"></div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a>
		&gt; 图书
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
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
		<div class="main">
			<div class="product-list">
				<h2>全部商品</h2>
				<div class="pager">
					<ul class="clearfix">
						<li><a href="#">上一页</a></li>
						<li class="current">1</li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">下一页</a></li>
					</ul>
				</div>
				<div class="clear"></div>
				<ul class="product clearfix">
					<% List<EProduct> categProducts = (List<EProduct>)request.getAttribute("categProduct");%>
					<%for(int i = 0;i<categProducts.size();i++) {%>

					<li>
						<dl>
							<dt>
								<a href="product-view.html" target="_blank"><img
									src="<%=categProducts.get(i).getEPFile() %>" /></a>
							</dt>
							<dd class="title">
								<a href="product-view.html" target="_blank"><%=categProducts.get(i).getEPName() %></a>
							</dd>
							<dd class="price"><%=categProducts.get(i).getEPPrice() %></dd>
						</dl>
					</li>

					<% }	%>
				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<li><a href="#">上一页</a></li>
						<li class="current">1</li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
