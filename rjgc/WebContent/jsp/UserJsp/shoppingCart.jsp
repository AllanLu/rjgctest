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
int num=0;
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的购物车</title>
<link rel="stylesheet" href="/rjgc/css/shoppingcart.css">
</head>
<body><div class="header">
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
<!--未登录时，导航栏给出登录按钮，跳转到login.jsp，登录后，导航栏显示用户名，点击用户名跳转到用户信息界面，页面其它内容与登录无关-->
<%
	if(request.getSession().getAttribute("user") != null) {
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		out.print("<div class='useronline'>你好！  "+user.getName()+"</div>");
		out.print("<div class='supplier'><a href='/rjgc/jsp/UserJsp/userInfo.jsp'>个人中心</a>");
		out.print("<a href='/rjgc/jsp/index.jsp'>返回首页</a><p>丨</p>");
		out.print("<a href='/rjgc/jsp/UserJsp/shoppingCart.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='/rjgc/jsp/supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='/rjgc/jsp/supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='/rjgc/jsp/login.jsp'>退出</a></div>");
	} else {
		out.print("<div class='user'><ul><li><a href='/rjgc/jsp/login.jsp'>用户登录</a></li></div>");
		out.print("<div class='supplier'><a href='/rjgc/jsp/login.jsp'>个人中心</a>");
		out.print("<a href='/rjgc/jsp/login.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='/rjgc/jsp/supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='/rjgc/jsp/supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='/rjgc/jsp/login.jsp'>退出</a></div>");
	}
%>
</div>

  <% UserModel user = (UserModel)request.getSession().getAttribute("user");
 //ArrayList<ShoppingcartModel> shoplist=(ArrayList<ShoppingcartModel>)session.getAttribute("shop");
 List<ShoppingcartModel> shoplist=new ArrayList<ShoppingcartModel>();
ProductInfoService productservice=new ProductInfoService();
shoplist=productservice.getProductList(user.getId());
ProductModel product =new ProductModel();
int n=0;
%> <form action="<%=path%>/confirmOrderController.do"method=post>
<br><br>
<table border="0" align="center" width="50%">
            <tr>
                <th>
                    商品
                </th>
                <th>
                    价格
                </th>
                <th>
                    数量
                </th>
                <th>
                    图片
                </th>
                <th>
                    操作
                </th>
                </tr>
              
<%
//product=productservice.getProduct(product.getProductid());
if (shoplist!=null){
for(ShoppingcartModel shoppingcart:shoplist){
%>
<%product=productservice.getProduct(shoppingcart.getProductid()); %>
                <tr>
                    <td>
                        <p><%= product.getProductname() %></p>
                    </td>
                    <td>
                        <p><%= shoppingcart.getProductprice() %></p>
                    </td>
                    <td>
                        <p><%= shoppingcart.getProductnum() %></p>
                    </td>
                    <td>
                        <a href="/rjgc/productInfoController.do?productid=<%= product.getProductid() %>"><img  src="/rjgc/rjgc/<%= product.getImagepath() %>"/> </a>
                    </td>
                    <td>
                    <input type="checkbox"name="product"value="<%=num %>"/>
<a href="<%=path%>/shoppingCartController.do?Shoppingcartid=<%=shoppingcart.getShoppingcartid() %>">删除</a>
<%num=num+1; %>
                    </td>
                </tr>

<%
}}else {
    %>
    <div class="shop">
    <p><strong>购物车为空 快去购买 </strong></p>
    
    </div>
    <%
} %>

      <%
     // List<ShoppingcartModel> list=new ArrayList<ShoppingcartModel>();
     // String[] prolist=request.getParameterValues("product");
     // int j=0;
      //for (int i=0;i<num;i++){
        //  if (prolist(i)!=null){
        //   int k=Integer.parseInt(prolist[i]);
        //   list.add(shoplist.get(k));  
        // }    
        //  }
//session.setAttribute("list", list);
session.setAttribute("shoplist",shoplist);
%>
        </table>
        <br><br><br><br>
<td><input type="submit" value="确认购买"/></td>
</form>

</body>
</html>