<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.ShoppingcartModel" %>
<%@page import="service.ProductInfoService" %>
<%
    String path = request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的购物车</title>
<style type="text/css">


</style>
</head>

<body><div class="header">
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
<!--未登录时，导航栏给出登录按钮，跳转到login.jsp，登录后，导航栏显示用户名，点击用户名跳转到用户信息界面，页面其它内容与登录无关-->
<%
	if(request.getSession().getAttribute("user") != null) {
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		out.print("<div class='useronline'>你好！  "+user.getName()+"</div>");
		out.print("<div class='supplier'><a href='../UserJsp/userInfo.jsp'>个人中心</a>");
		out.print("<a href='../UserJsp/shoppingCart.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='../supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='../supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='../login.jsp'>退出</a></div>");
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
  
  <% UserModel user = (UserModel)request.getSession().getAttribute("user");
 //ArrayList<ShoppingcartModel> shoplist=(ArrayList<ShoppingcartModel>)session.getAttribute("shop");
 List<ShoppingcartModel> shoplist=new ArrayList<ShoppingcartModel>();
ProductInfoService productservice=new ProductInfoService();
shoplist=productservice.getProductList(user.getId());
ProductModel product =new ProductModel();
int n=0;
//product=productservice.getProduct(product.getProductid());
if (shoplist!=null){
for(ShoppingcartModel shoppingcart:shoplist){
%>
<%product=productservice.getProduct(shoppingcart.getProductid()); %>
<div class="shop">
<p><strong>商品名称：</strong><%= product.getProductname() %></p>
<p><strong>购买数量：</strong><%= shoppingcart.getProductnum() %></p>
<p><strong>总价：</strong><%= shoppingcart.getProductprice() %></p>
<input type="checkbox"name="product"value="1"/>
<form action="<%=path%>/shoppingCartController.do"method="post">
<% 
session.setAttribute("shopcartid", shoppingcart.getShoppingcartid());
session.setAttribute("user", user);
%>
<input type="submit"value="删除"/></form>
</div>
<%
}}else {
	%>
	<div class="shop">
	<p><strong>购物车为空 快去购买 </strong></p>
	
	</div>
	<%
} %>


</body>
</html>