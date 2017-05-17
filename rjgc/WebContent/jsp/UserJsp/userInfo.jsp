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
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户信息修改</title>

    <!-- Bootstrap -->
    <link href="。。/css/bootstrap.min.css" rel="stylesheet" type="text/css"><!-- css位置 -->


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="header">
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
<!--未登录时，导航栏给出登录按钮，跳转到login.jsp，登录后，导航栏显示用户名，点击用户名跳转到用户信息界面，页面其它内容与登录无关-->
<%
	if(request.getSession().getAttribute("user") != null) {
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		out.print("<div class='useronline'><a href='../index.jsp'>你好！  "+user.getName()+"</div>");
		out.print("<div class='supplier'><a href='../UserJsp/userInfo.jsp'>个人中心</a>");
		out.print("<a href='../UserJsp/shoppingCart.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='../supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='../supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='../login.jsp'>退出</a></div>");
	} else {
		out.print("<div class='user'><ul><li><a href='../login.jsp'>用户登录</a></li></div>");
		out.print("<div class='supplier'><a href='../login.jsp'>个人中心</a>");
		out.print("<a href='../login.jsp'>购物车</a><p>丨</p>");
		out.print("<a href='../supplierLogin.jsp'>商家登录</a>");
		out.print("<a href='../supplierLogin.jsp'>商家中心</a></div>");
		out.print("<div class='exit'><a href='../login.jsp'>退出</a></div>");
	}
%>
</div>
	<div class = "row">
		<div class = "col-md-4"></div>
		<div class = "col-md-4">
    		

    			<form class = "form-horizontal" role="form" method="post" action="../../UModify.do"><!-- servlet记得修改 -->
    				<div class = "center">
      					<h2 class="text-center text-success">供应商信息修改</h2>
      					<%
      					UserModel user = (UserModel)request.getSession().getAttribute("user");
						%>
      					<div class="form-group">
        					<label for="exampleInputEmail1"><strong>用户ID</strong></label>
        					<input type="text" name="BuyerId" style="width:90%" class="form-control" id="BuyerId" value=<%=user.getId()%> disabled="true">
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1"><strong>用户名</strong></label>
        					<input type="text" name="Buyername" style="width:90%" class="form-control" id="Buyername">
      					</div>
      					<div class="form-group">
        					<label for="exampleInputPassword1">密码</label>
        					<input type="password" name="BuyerPassword" style="width:90%" class="form-control" id="BuyerPassword" placeholder="Password">
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">联系方式</label>
        					<input type="text" name="BuyerTelephone" style="width:90%" class="form-control" id="BuyerTelephone" placeholder="Tel">
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">地址</label>
        					<input type="text" name="BuyerAddress" style="width:90%" class="form-control" id="BuyerAddress" placeholder="Address" >
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">真名</label>
        					<input type="text" name="RealName" style="width:90%" class="form-control" id="RealName" placeholder="Realname">
      					</div>
      					<button type="submit" class="btn btn-success">提交</button>

    					
					</div>
    			</form>
    	</div>
    	<div class = "col-md-4"></div>
	</div>

</body>
</html>