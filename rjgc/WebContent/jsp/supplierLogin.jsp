<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家登录界面</title>
<link rel="stylesheet" href="../css/login.css">
</head>

<body>
<!--该jsp页面主要实登录的功能，form中还需要有两个隐藏的参数Productid和flag-->
<div class="login">
<%
	if(request.getSession().getAttribute("eFlag") =="error") {
		out.print("<div class='wrong'><p>用户名或密码错误</p></div>");
		session.setAttribute("eFlag", "e");
	}
%>
	<form id="loginform" action="../sLoginController.do" method="post">
		<div class="sign">
        	<input type="text" placeholder="用户名" name="Suppliername" id="Suppliername"><br>
        	<input type="password" placeholder="密码" name="SupplierPassword" id="SupplierPassword"><br>
        	<input type="submit" value="登录">
        	<a href="../SupplierJsp/supplierRegist.jsp">注册</a>
        </div>
    </form>
</div>
</body>
</html>