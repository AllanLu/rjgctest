<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.ShoppingcartModel" %>
<%@page import="service.ProductInfoService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
#textarea {
	position: absolute;
	width: 356px;
	height: 22px;
	left: 667px;
	top: 235px;
}
#button {
	position: absolute;
	left: 1029px;
	top: 233px;
	width: 57px;
	height: 26px;
	background-color: #D6D6D6;
}
#nav {
	line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;
}
#form1 {
	position: absolute;
	left: 967px;
	top: 576px;
	height: 46px;
	background-color: #FFFFFF;
	width: 464px;
	visibility: inherit;
}
body,td,th {
	color: #630;
	font-family: monospace;
	font-weight: bold;
}
.首页 {
	position: absolute;
	background-color: #CCCCCC;
	width: 79px;
	height: 27px;
	top: 632px;
	left: 777px;
}
</style>
</head>

<body><div class="header">
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
<!--未登录时，导航栏给出登录按钮，跳转到login.jsp，登录后，导航栏显示用户名，点击用户名跳转到用户信息界面，页面其它内容与登录无关-->
<%
	if(request.getSession().getAttribute("user") != null) {
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		out.print("<div class='useronline'>你好！  "+user.getName()+"</div>");
		out.print("<div class='supplier'><a href='UserJsp/userInfo.jsp'>个人中心</a>");
		out.print("<a href='UserJsp/shoppingCart.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='login.jsp'>退出</a></div>");
	} else {
		out.print("<div class='user'><ul><li><a href='login.jsp'>用户登录</a></li></div>");
		out.print("<div class='supplier'><a href='login.jsp'>个人中心</a>");
		out.print("<a href='login.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='login.jsp'>退出</a></div>");
	}
%>
</div>
<h1><img src="1.jpg" width="174" height="161" /><strong>购物车     </strong>
  <input type="submit" name="button" id="button" value="搜索" />
  <input name="textarea" type="text" id="textarea" value="" size="45" />
</h1>
<p>
  <label for="textarea"></label>
</p>

<p><strong> 全部商品
</strong></p>
<hr />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="2.png" width="313" height="290" /></p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>您的购物车还是空的，赶紧购物吧~
  </strong> &nbsp;&nbsp;&nbsp;
  <input name="button3" type="submit" class="首页" id="button3" value="返回首页" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;</p>
  <% UserModel user = (UserModel)request.getSession().getAttribute("user");
 //ArrayList<ShoppingcartModel> shoplist=(ArrayList<ShoppingcartModel>)session.getAttribute("shop");
 List<ShoppingcartModel> shoplist=new ArrayList<ShoppingcartModel>();
ProductInfoService productservice=new ProductInfoService();
shoplist=productservice.getProductList(user.getName());
ProductModel product =(ProductModel)request.getSession().getAttribute("product");
for(ShoppingcartModel shoppingcart:shoplist){
%>
<div class="shop">
<p><%= shoppingcart.getProductnum() %></p>
<p><%= shoppingcart.getProductprice() %></p>
</div>
<%
}%>
</body>
</html>