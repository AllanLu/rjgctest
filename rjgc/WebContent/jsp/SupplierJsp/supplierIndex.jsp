<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="service.SupplierService" %>
<%@ page import="model.SupplierModel" %>
<%@ page import="model.ProductModel" %>
<%@ page import="dao.ProductDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../../css/index.css">
<title>商家首页</title>
</head>

<body>
<div class="header">
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
<!--未登录时，导航栏给出登录按钮，跳转到login.jsp，登录后，导航栏显示用户名，点击用户名跳转到用户信息界面，页面其它内容与登录无关-->
<%
	if(request.getSession().getAttribute("supplier") != null) {
		SupplierModel supplier = (SupplierModel)request.getSession().getAttribute("supplier");
		out.print("<div class='useronline'>你好！  "+supplier.getSuppliername()+"</div>");
		out.print("<a href='supplierModify.jsp'>商家信息修改</a></div>");
		out.print("<div class='exit'><a href='../supplierLogin.jsp'>退出</a></div>");
	} 
%>
</div>
<div class="title">
<a href="#"><img border="0" src="../images/1.png" height=150px width=150px/></a>
<h1>计 1 4 1 支 农 生 鲜</h1></div>
<div class="content">
<% ProductDao pd=new ProductDao(); 
ArrayList<ProductModel> productList=(ArrayList<ProductModel>)session.getAttribute("productList");
for(ProductModel product:productList){
%>
<div class="product">
<p><%= product.getProductname() %></p>
<p><%= product.getProductorigin() %></p>
<p><%= product.getProductdate() %></p>
<p><%= product.getProductprice() %></p>
<p><%= product.getProductintroduction() %></p>
<p><%= product.getSupplierid() %></p>
</div>
<%
}
%>
</div>
<div class="footer">
<p>Copyright 2017 by 141.</p>
</div>
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
</body>
</html>