<%@page import="com.easybuy.model.ECartProduct"%>
<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.easybuy.model.EProduct"%>
<!DOCTYPE html>
<html>
<head>
<title>易买网-我的购物车</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<style type="text/css">
font {
	font-size: 1px;
}
</style>
</head>
<script>
	function countSumMoney(i) {
		var buyNum = $("#buyNum").val();
		console.log(buyNum);
		$('#'+i).html(buyNum*2);

	}
</script>
<body>
	<%@ include file="header.jsp"%>
	<div id="main" class="wrap">
		<div class="cart-product">
			<h2>我的购物车</h2>
			<table>
				<tr>
					<th style="width: 400px">商品信息</th>
					<th>单价</th>
					<th>商品数量</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
			</table>
			<%
				List<EProduct> cartProductList = (List) request.getAttribute("cartProductList");
				ECartProduct cartProduct = (ECartProduct) request.getAttribute("cartProduct");
				for (int i = 0; i < cartProductList.size(); i++) {
			%>
			<div style="background-color: whitesmoke;">
				<table>
					<tr>
						<td><a href="#" target="_blank">
								<div class="cart-p-name">
									<img src=<%=cartProductList.get(i).getEPFile()%> />
								</div>
								<div class="cart-p-name">
									<font><%=cartProductList.get(i).getEPName() + "-->"%> <%=cartProductList.get(i).getEPDesc()%></font>
								</div>
						</a></td>
						<td class="cartPrice"><%=cartProductList.get(i).getEPPrice()%>
						</td>
						<!--商品数量   通过ajax获取，可以支持动态改变 -->
						<td id="cartProductNum"><input type="text" id="buyNum"
							onkeyup="countSumMoney(<%=i %>);" /></td>
						<!-- 总金额 -->
						<td><span id=<%=i %>></span></td>
						<td><a href="#">删除</a></td>
						</div>
					</tr>
					<hr>
				</table>
				<%
					}
				%>
			</div>
</body>

</html>