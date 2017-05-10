<!DOCTYPE html>

<html lang="zh-cn">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
    String path = request.getContextPath();
	%>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>供应商信息修改</title>

    <!-- Bootstrap -->
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css"><!-- css位置 -->


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <div class="container-fluid">
	<div class="row">
	
		<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">首页</a><!-- 所有超链接待修改 -->
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="#">买家中心</a></li>
            <li><a href="#">卖家中心</a></li>
            
        </ul>
    </div>
    </div>
</nav>
<%@ page import="model.*" %>
<%
	SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");
		
	String sname=sModel.getSuppliername();
	String stel=sModel.getSuppliertel();
	String sintro=sModel.getSupplierintroduction();
	String saddr=sModel.getSupplieraddress();
%>
	
	</div>
	<div class = "row">
		<div class = "col-md-4"></div>
		<div class = "col-md-4">
    		

    			<form class = "form-horizontal" role="form" method="post" action="../SModify.do"><!-- servlet记得修改 -->
    				<div class = "center">
      					<h2 class="text-center text-success">供应商信息修改</h2>
      					<%
						if (session.getAttribute("flag") != null) {
							String message = (String) session.getAttribute("message");
							out.print("<font color='red'>" + message + "</font><br>");
							session.removeAttribute("flag");
							session.removeAttribute("message");
						}
						%>
      					<div class="form-group">
        					<label for="exampleInputEmail1"><strong>供应商名称</strong></label>
        					<input type="text" name="SupplierChangeName" style="width:90%" class="form-control" id="SupplierChangeName" value=<%=sname%> >
      					</div>
      					<div class="form-group">
        					<label for="exampleInputPassword1">供应商密码</label>
        					<input type="password" name="supplierpassword" style="width:90%" class="form-control" id="SupplierChangePassword" placeholder="Password">
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">供应商联系方式</label>
        					<input type="text" name="suppliertel" style="width:90%" class="form-control" id="SupplierChangeTel" placeholder="Tel" value=<%=stel%> >
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">商家地址</label>
        					<input type="text" name="supplieraddress" style="width:90%" class="form-control" id="SupplierChangeAddress" placeholder="Address" value=<%=saddr%> >
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1">简介</label>
        					
        					<textarea class="form-control" style="width:90%" rows="3" id="SupplierChangeIntro" placeholder=<%=sintro%> name="supplierintro" ></textarea>
      					</div>
      					<button type="submit" class="btn btn-success">提交</button>

    					
					</div>
    			</form>
    	</div>
    	<div class = "col-md-4"></div>
	</div>

</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>
