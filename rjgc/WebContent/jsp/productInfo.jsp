<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息</title>
</head>

<body>
<% UserModel user = (UserModel)request.getSession().getAttribute("user");
ProductModel product =(ProductModel)request.getSession().getAttribute("product");%>
<div class="product">
<p><%= product.getProductid() %></p>
<p><%= product.getProductname() %></p>
<p><%= product.getProductorigin() %></p>
<p><%= product.getProductdate() %></p>
<p><%= product.getProductprice() %></p>
<p><%= product.getProductintroduction() %></p>
<p><%= product.getSupplierid() %></p>
</div>
<form action="../shoppingCartController.do"method=post>
<% 
product.setProductid(1);
session.setAttribute("user", user);
session.setAttribute("product", product);
//response.sendRedirect("productInfo.jsp");
//RequestDispatcher rd = request.getRequestDispatcher("/productInfoController.do");
//rd.forward(request,response);
%>
<tr><div>数量<input type="text" name="Productnum" id="Productnum"></div><br>
<td><input type="submit" value="加入购物车"/></td>
</tr>
</form>
<!--该jsp页面主要实现展示商品信息，其中有加入购物车按钮和购买按钮-->
<!--该页面接收ProductInfoController类传来的ProductModel对象并显示-->
<!--点击加入购物车时将ProductModel对象提交到/addSCartController.do，并令flag=productInfo-->

</body>
</html>