<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%
    String path = request.getContextPath();
	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/productinfo.css">
<title>商品信息</title>
</head>

<body>
<div class="header">
<%
	if(request.getSession().getAttribute("user") != null) {
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		out.print("<div class='useronline'>你好！  "+user.getName()+"</div>");
		out.print("<div class='supplier'><a href='jsp/UserJsp/userInfo.jsp'>个人中心</a>");
		out.print("<a href='jsp/UserJsp/shoppingCart.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='jsp/supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='jsp/supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='jsp/login.jsp'>退出</a></div>");
	} else {
		out.print("<div class='user'><ul><li><a href='jsp/login.jsp'>用户登录</a></li></div>");
		out.print("<div class='supplier'><a href='jsp/login.jsp'>个人中心</a>");
		out.print("<a href='jsp/login.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='jsp/supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='jsp/supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='jsp/login.jsp'>退出</a></div>");
	}
%>
</div>
<% UserModel user = (UserModel)request.getSession().getAttribute("user");
ProductModel product =(ProductModel)request.getSession().getAttribute("product");%>
<div class="product">
<div class="left">
<div class="image"><img class="border="0"  src="rjgc/<%= product.getImagepath() %>" width=250px/></div>
</div>
<div class="info">
<p>商品名称: <%= product.getProductname() %></p>
<p>商品源: <%= product.getProductorigin() %></p>
<p>价格: <%= product.getProductprice() %></p>
<p>生产日期: <%= product.getProductdate() %></p>
<p>过期日期: <%= product.getProductlife() %></p>
<p>库存量: <%= product.getStocknum() %></p>


<form action="<%=path%>/addSCartController.do"method=post>
<% 
product.setProductid(1);
session.setAttribute("user", user);
session.setAttribute("product", product);
%>
<tr><div>数量:  <input type="text" name="Productnum" id="Productnum" size=4></div><br>
<td><input type="submit" value="加入购物车"/></td>
</tr>
</form>
</div>
<!--该jsp页面主要实现展示商品信息，其中有加入购物车按钮和购买按钮-->
<!--该页面接收ProductInfoController类传来的ProductModel对象并显示-->
<!--点击加入购物车时将ProductModel对象提交到/addSCartController.do，并令flag=productInfo-->

<div class="detail">
<hr/>
<p style="font-size:20px">商品详情</p>
<p><%= product.getProductintroduction() %></p></div>
</div>
</body>
</html>