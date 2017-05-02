<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<link rel="stylesheet" href="../css/reg.css">
</head>

<body>
<!--该jsp页面主要实现用户注册    判断flag1是否==1，若等于1则提示用户名已存在，若flag2==1，则提示注册成功-->
	<form id="regist" action="../RegController.do" method="post">
		<div class="reg">
        	<input type="text" placeholder="用户名" name="Buyername" id="Buyername"><br>
        	<input type="text" placeholder="密码" name="BuyerPassword" id="BuyerPassword"><br>
        	<input type="text" placeholder="手机号" name="BuyerTelephone" id="BuyerTelephone"><br>
        	<input type="text" placeholder="地址" name="BuyerAddress" id="BuyerAddress"><br>
        	<input type="submit" value="注册">
        </div>
	</form>
</body>
</html>