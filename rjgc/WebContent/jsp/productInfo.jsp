<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="dao.SupplierDao" %>
<%@ page import="model.SupplierModel" %>
<%
    String path = request.getContextPath();
	int num=1;
	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/productinfo.css">
<script src="https://cdn.jsdelivr.net/jquery/3.2.1/jquery.min.js" charset="utf-8"></script>
<link href="https://fonts.lug.ustc.edu.cn/css?family=Roboto:300,400,500" rel="stylesheet">
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
ProductModel product =(ProductModel)request.getSession().getAttribute("product");
String supplierid0=product.getSupplierid();
int supplierid =Integer.parseInt(supplierid0);
SupplierModel supplier=new SupplierModel();
SupplierDao supplierdao=new SupplierDao();
supplier.setSupplierid(supplierid);
supplier = supplierdao.getSupplierbyid(supplier);
%>

<main class="container">
 
  <div class="left-column">
    <img data-image="red" class="active" src="rjgc/<%= product.getImagepath() %>" alt="">
  </div>
 
 
  <div class="right-column">
 
    <!-- Product Description -->
    <div class="product-description">
      <span></span>
      <h1><%= product.getProductname() %></h1>
<p><strong>单价: </strong><%= product.getProductprice() %></p>
<p><strong>商品源: </strong><%= product.getProductorigin() %></p>
<p><strong>生产日期: </strong><%= product.getProductdate() %></p>
<p><strong>过期日期: </strong><%= product.getProductlife() %></p>
<p><strong>库存量: </strong><%= product.getStocknum() %></p>
<p><strong>商家名称: </strong><%= supplier.getSuppliername() %></p>
<p><strong>商家地址: </strong><%= supplier.getSupplieraddress() %></p>
<p><strong>商家介绍: </strong><%= supplier.getSupplierintroduction() %></p>
<p><strong>商家电话：</strong><%= supplier.getSuppliertel() %></p>
    </div>
    <!-- Product Pricing -->
	<div class="quantity">
        <button class="plus-btn" type="button" name="button">
            <img src="rjgc/../images/plus.svg" alt="">
        </button>
        <input type="text" name="name" value="1">
        <button class="minus-btn" type="button" name="button">
            <img src="rjgc/../images/minus.svg" alt="">
        </button>
        </div>
    <div class="product-price">
      <span>￥<%= product.getProductprice()*num %></span>
      <form action="<%=path%>/confirmOrderController.do"method=post>
      
<td><input type="submit" value="立即购买"/></td>
</form>
<form action="<%=path%>/addSCartController.do"method=post>
<%String productnum=Integer.toString(num); %>
<td><input type="submit" value="加入购物车"/></td>
</form>
    </div>
</div>
</main>
<script type="text/javascript">
      $('.minus-btn').on('click', function(e) {
    		e.preventDefault();
    		var $this = $(this);
    		var $input = $this.closest('div').find('input');
    		 num = parseInt($input.val());
    		if (num > 1) {
    			num = num - 1;
    		} else {
    			num = 0;
    		}
        $input.val(num);
        
    	});

    	$('.plus-btn').on('click', function(e) {
    		e.preventDefault();
    		var $this = $(this);
    		var $input = $this.closest('div').find('input');
    		num = parseInt($input.val());
       		if (num <1000 ) {
      		num = num + 1;
    		} else {
    			num =1000 ;
    		}

    		$input.val(num);
    	});

      $('.like-btn').on('click', function() {
        $(this).toggleClass('is-active');
      });
</script>
</body>
</html>