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
</head>
<script>
	function countSumMoney(i) {
		var price = $('#price'+i).html();
		var buyNum = $('#buyNum'+i).val();
		$('#sumMoney'+i).html(price*buyNum);
	}
	
	
	
   $(function(){
	   //点击非全选按钮执行的操作
	    $("input[type=checkbox][name!=allCheck]").click(function () {
	        //如果其他都选中了 全选也要选中
	        if ($("input[type=checkbox][name!=allCheck]:checked").length == $("input[type=checkbox][name!=allCheck]").length) {
	           alert($("input[type=checkbox][name!=allCheck]:checked").length)
	        	$("input[type=checkbox][name=allCheck]").prop("checked", true);
	        }
	        //如果检测到其他部分选中则取消全选
	        else {
	        	 alert($("input[type=checkbox][name!=allCheck]:checked").length+"维权选中")
	            $("input[type=checkbox][name=allCheck]").prop("checked", false);
	        }
	    })
	    //点击全选按钮执行的操作
	    $("input[type=checkbox][name=allCheck]").click(function () {
	        if ($(this).prop("checked") == true) {
	            $("input[type=checkbox]").each(function () {
	                $(this).prop("checked", true);
	            })
	        }
	        //如果取消全选 则其他也要取消
	        else {
	            $("input[type=checkbox]").each(function () {
	                $(this).prop("checked", false);
	            })
	        }
	    })
   })
</script>
<style>
</style>
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
			<input type="checkbox" class="check" Name="allCheck">全选
			<%
				List<EProduct> cartProductList = (List) request.getAttribute("cartProductList");
				List<ECartProduct> cartProductInfo = (List) request.getAttribute("cartProductInfo");

				for (int i = 0; i < cartProductList.size(); i++) {
			%>
			<div style="background-color: whitesmoke;">
				<table>
				<hr>
					<input type="checkbox" class="check">
					
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
						<td><a
							href="UserActionServlet?param=cartDele&EPId=<%=cartProductList.get(i).getEPId()%>">删除</a></td>
						</div>
					</tr>
					
				</table>
				<%
					}
				%>
			</div>
			
		</div>
	</div>
<!-- 不知道为什么如果只有换行符号的话就会沿用上一个div的颜色，只好弄一个分割作用的div -->
<div style="background-color: white;">
<br><br><br><br><br><br><br>
</div>
	<!-- 底部结算代码 -->

	<div class="bar-wrapper">

		<input type="checkbox" class="check" name="allCheck"> 全选
		<div class="bar-right">

			<div class="piece">
				已选商品<strong class="piece_num">0</strong>件
			</div>
			<div class="totalMoney">
				共计: <strong class="total_text">0.00</strong>
			</div>
			<div class="calBtn">
				<a href="javascript:;">结算</a>
			</div>
		</div>
	</div>

</body>

</html>