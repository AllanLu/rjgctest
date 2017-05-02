<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="service.SupplierService" %>
<%@ page import="model.SupplierModel" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家首页</title>
</head>

<body>
<a href="supplierAddProduct.jsp">添加商品</a>
<a href="supplierModify.jsp">修改信息</a>
<% SupplierModel supplier = new SupplierModel();
supplier.setSuppliername("mk");
SupplierService ss = new SupplierService();
//ss.getSupplierByName(supplier.getSuppliername());
session.setAttribute("supplier", supplier); %>
<!--该jsp页面主要实现web访问界面，其中有产品的目录等，类似淘宝的主页-->
</body>
</html>