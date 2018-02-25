<%@page import="com.easybuy.model.EProduct"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
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
								<a href="ProductServlet?param=productView&EPId=<%=categProducts.get(i).getEPId() %>" target="_blank"><img
									src="<%=categProducts.get(i).getEPFile() %>" /></a>
							</dt>
							<dd class="title">
								<a href="ProductServlet?param=productView&EPId=<%=categProducts.get(i).getEPId() %>" target="_blank"><%=categProducts.get(i).getEPName() %></a>
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
