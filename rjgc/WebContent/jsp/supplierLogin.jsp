<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家登录</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <style>
    .center {
      width: auto;
      display: table;
      margin-left: auto;
      margin-right: auto;
    }
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <br />
  <br />
  <br />
  <br />
    <h2 class="text-center text-success">商家登录</h2>

    <form role="form" action="../sLoginController.do" method="post">
<div class = "center">
      <div class="form-group">
        <label for="exampleInputEmail1"><strong>用户名</strong></label>
        <input type="text" name="Suppliername" style="width:90%" class="form-control" id="Suppliername" placeholder="Username">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" name="SupplierPassword" style="width:90%" class="form-control" id="SupplierPassword" placeholder="Password">
      </div>

      <button type="submit" class="btn btn-success">登录</button>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="supplierRegist.jsp">注册</a>
</div>
    </form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
