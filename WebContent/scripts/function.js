
		
$(function() {document.getElementById("header").innerHTML='<div id="logo">'+
	'<a href="http://localhost:8080/yimai/index.html"><img src="images/logo.gif" /></a>'+
'</div>'+
'<div class="help">'+
'<a href="#" class="shopping">购物车</a> <a href="login.html">登录</a> <a'+
	'href="register.html">注册</a> <a href="guestbook.html">留言</a>'+
'</div>'+
'<div class="navbar">'+
'<ul class="clearfix">'+
	'<li class="current"><a href="#">首页</a></li>'+
	'<li><a href="#">图书</a></li>'+
	'<li><a href="#">百货</a></li>'+
	'<li><a href="#">品牌</a></li>'+
	'<li><a href="#">促销</a></li>'+
'</ul>'+
'</div>'})


$(function() {

	$
			.ajax({
				url : 'ProductServlet',
				type : 'post',
				data : {
					param : 'specialProduct',
				},
				dataType : 'json',
				success : function(data) {
					// 从前端传来一个json里面是商品的所有信息。然后使用jquery读出来

					// 这里data应该是一个list集合

					for (var i = 0; i < data.length; i++) {
						$("#special_price")
								.append(
										'<li>'
												+ '<dl>'
												+ '<dt><a href="ProductServlet?param=productView&EPId=1" target="_blank"><img src=' + data[i].EPFile + ' /></a></dt>'
												+ '<dd class="title"><a href="ProductServlet?param=productView&EPId=1" target="_blank">'
												+ data[i].EPName
												+ '</a></dd>'
												+ '<dd class="price">￥108.0</dd>'
												+ '</dl></li>')
					}

				}

			})

	// 失去焦点的时候利用ajax判断用户名是否存在【注意】网络太慢应该会导致延迟
	// 得到用户名

	// 获取新闻题目列表信息
	$
			.ajax({
				url : 'ShowNewsServlet',
				type : 'post',
				data : {
					param : 'newsListPage',
				},
				dataType : 'json',
				success : function(data) {

					// 加载新闻标题列表
					for (var i = 0; i < data.length; i++) {
						var href = 'ShowNewsServlet?param=newsDetailPage&newsTitle='
								+ data[i].ENTitle;
						$("#showNews").append(
								'<li><a href=' + href + '>'
										+ data[i].ENTitle + '</a></li>');
					}
				}
			})

	// 加载分类上栏和下栏

	$.ajax({
		url : 'ProductServlet',
		type : 'post',
		data : {
			param : 'productCateg',
		},
		dataType : 'json',
		success : function(data) {

			// 加载分类：
			// <li><a href="product-list.html">影视</a></li>
			for (var i = 0; i < data.length; i++) {
				// 加载顶部的菜单分类
				if (data[i].EPCIsOften == 1) {
					$("#topNav").append(
							'<li><a href=product-list.html>'
									+ data[i].EPCName + '</a></li>');
				}

				// 加载左侧分类信息：
				// 对于有有父类和子类的分类表其实就是根据pid来加载的 但是这个又不像是城市地区那样的，所以还是有点不一样
				// 最本质的就是要知道什么时候分多少级，如果有一个功能不知道分多少级如何根据一个程序一劳永逸
				// data[i].EPCId==1表示图书音像分类，
				if (data[i].EPCId == 1) {

					$("#leftNav")
							.append('<dt>' + data[i].EPCName + '</dt>');
					// 加载所有子类 注意优化代码减少不必要的循环
					for (var j = 0; j < data.length; j++) {
						if (data[j].EPCParentId == 1) {
							$("#leftNav").append(
									'<dd><a href = "product-list.html" >'
											+ data[j].EPCName
											+ ' </a> </dd>')
						}

					}

				}
				// data[i].EPCId==2表示百货分类
				if (data[i].EPCId == 2) {
					$("#leftNav")
							.append('<dt>' + data[i].EPCName + '</dt>');

					for (var j = 0; j < data.length; j++) {
						if (data[j].EPCParentId == 2) {
							$("#leftNav").append(
									'<dd><a href = "product-list.html" >'
											+ data[j].EPCName
											+ ' </a> </dd>')
						}

					}

				}
			}
		}
	})

})



// JavaScript Document
window.onload = function(){
	showChater();
	scrollChater();
}
window.onscroll = scrollChater;
window.onresize = scrollChater;

function FocusItem(obj)
{
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj)
{
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
		case "userName":
			if(obj.value == "") {
				msgBox.innerHTML = "用户名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.innerHTML = "确认密码不能为空";
				msgBox.className = "error";
				return false;
			} else if(obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次输入的密码不相同";
				msgBox.className = "error";
				return false;
			}
			break;
		case "veryCode":
			if(obj.value == "") {
				msgBox.innerHTML = "验证码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}

function checkForm(frm)
{
	var els = frm.getElementsByTagName("input");
	for(var i=0; i<els.length; i++) {
		if(typeof(els[i].getAttribute("onblur")) == "function") {
			if(!CheckItem(els[i])) return false;
		}
	}
	return true;
}

function showChater()
{
	var _chater = document.createElement("div");
	_chater.setAttribute("id", "chater");
	var _dl = document.createElement("dl");
	var _dt = document.createElement("dt");
	var _dd = document.createElement("dd");
	var _a = document.createElement("a");
	_a.setAttribute("href", "#");
	_a.onclick = openRoom;
	_a.appendChild(document.createTextNode("在线聊天"));
	_dd.appendChild(_a);
	_dl.appendChild(_dt);
	_dl.appendChild(_dd);
	_chater.appendChild(_dl);
	document.body.appendChild(_chater);
}

function openRoom()
{
	window.open("chat-room.html","chater","status=0,scrollbars=0,menubar=0,location=0,width=600,height=400");
}

function scrollChater()
{
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92 + "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25 + "px";
}

function inArray(array, str)
{
	for(a in array) {
		if(array[a] == str) return true;
	}
	return false;
}

function setCookie(name,value)
{
  var Days = 30;
  var exp  = new Date();
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
}

function getCookie(name)
{
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}

function delCookie(name)
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
}

function goBuy(id, price)
{
	var newCookie = "";
	var oldCookie = getCookie("product");
	if(oldCookie) {
		if(inArray(oldCookie.split(","), id)) {
			newCookie = oldCookie;
		} else {
			newCookie = id + "," + oldCookie;
		}
	} else {
		newCookie = id;
	}
	setCookie("product", newCookie);
	location.href = "shopping.html";
}

function delShopping(id)
{
	var tr = document.getElementById("product_id_"+ id);
	var oldCookie = getCookie("product");
	if(oldCookie) {
		var oldCookieArr = oldCookie.split(",");
		var newCookieArr = new Array();
		for(c in oldCookieArr) {
			var cookie = parseInt(oldCookieArr[c]);
			if(cookie != id) newCookieArr.push(cookie);
		}
		var newCookie = newCookieArr.join(",");
		setCookie("product", newCookie);
	}
	if(tr) tr.parentNode.removeChild(tr);
}

function reloadPrice(id, status)
{
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_" + id);
	if(status) {
		number.value++;
	} else {
		if(number.value == 1) {
			return false;
		} else {
			number.value--;
		}
	}
	priceBox.innerHTML = "￥" + price * number.value;
}






// ajax代码
