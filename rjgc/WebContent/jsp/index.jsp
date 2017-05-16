<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.ProductModel" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" href="../css/index.css">
<link type="text/css" rel="stylesheet" href="../css/carousel.css">
	<style type="text/css">
		.caroursel{margin:150px auto;}
	</style>
</head>

<body>
<div class="header">
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
<div class="title">
<img border="0" src="../images/foryou.png" height=250px width=250px/>
<div class="search">
<form action="../Productsearch.do" method="post">
	<input type="text" name="keyword" id="keyword" placeholder="搜索商品">
	<button type="submit">搜索</button>
</form>
</div>
</div>
<div class="sort">
<ul>
<li><a href="index.jsp">首页</a>
<li><a href="<%=request.getContextPath() %>/Productsort.do?productsort=蔬菜">蔬菜</a></li>
<li><a href="<%=request.getContextPath() %>/Productsort.do?productsort=水果">水果</a></li>
<li><a href="<%=request.getContextPath() %>/Productsort.do?productsort=水产">水产</a></li>
</ul>
</div>
<div class="lunbotu">
<div class = "caroursel poster-main" data-setting = '{
	        "width":1170,
	        "height":270,
	        "posterWidth":800,
	        "posterHeight":300,
	        "scale":0.8,
	        "dealy":"2000",
	        "algin":"middle"
	    }'>
	        <ul class = "poster-list">
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=1"><img src="../images/a1.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=2"><img src="../images/a2.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=3"><img src="../images/a3.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=4"><img src="../images/a4.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=5"><img src="../images/a5.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=6"><img src="../images/a6.jpg" width = 700 height=300></li></a>
	            <li class = "poster-item"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=1"><img src="../images/a1.jpg" width = 700 height=300></li></a>
	        </ul>
	        
            
	        <div class = "poster-btn poster-prev-btn"></div>
	        <div class = "poster-btn poster-next-btn"></div>

	    </div>	
	<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="../js/jquery.carousel.js"></script>
    <script>
        Caroursel.init($('.caroursel'))
    </script>
    </div>
<div class="content">
<% ProductDao pd=new ProductDao(); 
ArrayList<ProductModel> productList=pd.Getall();
//(ArrayList<ProductModel>)session.getAttribute("productList");
for(ProductModel product:productList){
%>
<div class="product">
<div class="pic"><a href="<%=request.getContextPath()%>/productInfoController.do?productid=<%=product.getProductid() %>"><img border="0" src="<%= product.getImagepath() %>" height=180px width=200px/></a></div>
<div class="detail"><p>商品名称：<%= product.getProductname() %></p>
<p>来源：<%= product.getProductorigin() %></p>
<p>生产日期：<%= product.getProductdate() %></p>
<p>介绍：<%= product.getProductintroduction() %></p>
<p>价格：<%= product.getProductprice() %></p>
<p>供应商：<%= product.getSupplierid() %></p></div>
</div>
<%
}
%>
</div>
<div class="footer">
<p>Copyright 2017 by 141.</p>
</div>
</body>
</html>