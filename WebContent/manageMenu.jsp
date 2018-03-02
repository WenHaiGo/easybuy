<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd>
					<em><a href="manageAddUser.jsp">新增</a></em><a
						href="ManageUserServlet?param=showAllUser">用户管理</a>
				</dd>
				<dt>商品信息</dt>
				<dd>
					<em><a href="productClass-add.html">新增</a></em><a
						href="ManageOperateServlet?param=manageCateg">分类管理</a>
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
					<em><a href="news-add.html">新增</a></em><a href="ManageOperateServlet?param=manageNews">新闻管理</a>
				</dd>
			</dl>
		</div>
	</div>
</body>
</html>