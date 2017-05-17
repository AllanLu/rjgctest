<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	%>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>
<html>
<head>
<title>发布商品</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<link href="<%=path%>/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="<%=path%>/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../css/morris.css" type="text/css" />
<!-- Graph CSS -->
<link href="<%=path%>/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="../css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<%
ProductModel pModel=(ProductModel)session.getAttribute("product");

String pname=pModel.getProductname();
String porigin=pModel.getProductorigin();
String pdate=pModel.getProductdate();
String plife=pModel.getProductlife();
float pprice=pModel.getProductprice();
int pstock=pModel.getStocknum();
String pintro=pModel.getProductintroduction();
String pstore=pModel.getStoredid();
String pimg=pModel.getImagepath();
String ptype=pModel.getProductsort();
						%>
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->

				<!--header end here-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="supplierIndex.jsp">主页</a><i
						class="fa fa-angle-right"></i></li>
				</ol>
				<div class="inbox-mail">
					<!-- tab content -->
					<div class="col-md-8 tab-content tab-content-in w3">
						<div class="tab-pane text-style active" id="tab1">
							<div class="inbox-right">

								<div class="mailbox-content">
									<form action="../../productinfoedit.do" method="post"
										enctype="multipart/form-data">
										<table class="table">
											<tbody>
												<tr class="table-row">

													<td class="table-text">
														<h6>商品名称</h6> <input type="text" class="form-control"
														name="productName" value=<%=pname%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>产地</h6> <input type="text" class="form-control"
														name="origin" value=<%=porigin%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>生产日期</h6> <input type="text" class="form-control"
														name="date" value=<%=pdate%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>保质期</h6> <input type="text" class="form-control"
														name="life" value=<%=plife%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>价格</h6> <input type="number" class="form-control"
														name="price" value=<%=pprice%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>库存</h6> <input type="number" class="form-control"
														name="stockNum" value=<%=pstock%>>
													</td>
												</tr>
												<tr class="table-row">
												<td class="table-text">
												<h6>分类</h6><select id="type" name="type">
													<option value="蔬菜" ${ptype=="蔬菜"?'selected':''}>蔬菜</option>
													<option value="水果" ${ptype=="水果"?'selected':''}>水果</option>
													<option value="禽肉类" ${ptype=="禽肉类"?'selected':''}>禽肉类</option>
													<option value="水产品" ${ptype=="水产品"?'selected':''}>水产品</option>
												</select>
												</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>简介</h6> <input type="text" class="form-control"
														name="introduction" value=<%=pintro%>>
													</td>
												</tr>
												<tr class="table-row">

													<td class="table-text">
														<h6>仓库编号</h6> <input type="text" class="form-control"
														name="storedid" value=<%=pstore%>>
													</td>
												</tr>

												<tr class="table-row">

													<td class="table-text"><a>图片上传（jpg）：</a> <input
														type="file" name="image" /></td>
												</tr>
												<%
													if (session.getAttribute("flag") != null) {
														String message = (String) session.getAttribute("message");
														out.print("<font color='red'>" + message + "</font><br>");
														session.removeAttribute("flag");
														session.removeAttribute("message");
													}
												%>

												<tr class="table-row">

													<td class="table-text"><input class="btn btn-primary"
														type="submit" value="确定提交" /></td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
							</div>
						</div>

					</div>
					<div class="clearfix"></div>
				</div>
				<!-- script-for sticky-nav -->

				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<!--COPY rights end here-->
			</div>
		</div>
		</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->
	<script src="<%=path%>/js/jquery.nicescroll.js"></script>
	<script src="<%=path%>/js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<!-- /Bootstrap Core JavaScript -->

</body>
</html>