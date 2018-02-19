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
</style>
</head>
<script>
	function countSumMoney(i) {
		var price = $('#price'+i).html();
		var buyNum = $('#buyNum'+i).val();
		$('#sumMoney'+i).html(price*buyNum);
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
				List<ECartProduct> cartProductInfo = (List) request.getAttribute("cartProductInfo");
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
						<!-- 商品单价 -->
						<td class="cartPrice" id="price<%=i%>"><%=cartProductList.get(i).getEPPrice()%>
						</td>
						<!--商品数量   通过ajax获取，可以支持动态改变 -->
						<td id="cartProductNum"><input type="text" id="buyNum<%=i%>"
							onkeyup="countSumMoney(<%=i%>);" onabort="countSumMoney(<%=i%>);"
							value=<%=cartProductInfo.get(i).getPNum()%> /></td>
						<!-- 总金额 -->
						<td class="cartPrice"><span id="sumMoney<%=i%>"><%=cartProductInfo.get(i).getPNum() * cartProductList.get(i).getEPPrice()%></span></td>
						<td><a href="UserActionServlet?param=cartDele&EPId=<%=cartProductList.get(i).getEPId() %>">删除</a></td>
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