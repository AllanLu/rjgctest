<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
    String path = request.getContextPath();
	%>
<html>
<head>
<title>供应商注册</title>
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
<link rel="stylesheet" href="../css/jquery-ui.css">
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
</head>

<body>
	<div class="main-wthree">
		<div class="container">
			<div class="sin-w3-agile">
				<h2>供应商注册</h2>
				<%
					if (session.getAttribute("flag") != null) {
						String rgmessage = (String) session.getAttribute("rgmessage");
						out.print("<font color='red'>" + rgmessage + "</font><br>");
						session.removeAttribute("flag");
						session.removeAttribute("rgmessage");
					}
				%>
				<form action="../SRegister.do" method="post">
					<div class="username">
						<span class="username">供应商名:</span> <input type="text"
							name="suppliername" class="name" placeholder="" required />
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">密码：</span> <input type="password"
							name="password" class="password" id="pw1" placeholder="" required />
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">重复密码：</span> <input type="password"
							name="passwordr" class="password" id="pw2" placeholder=""
							required onkeyup="pw()" />
						<div class="clearfix"></div>
					</div>
					<a id="tishi"></a> <input type="hidden" name="type" value="com" />
					<div class="login-w3">
						<input type="submit" class="login" value="注册" />
					</div>
					<div class="clearfix"></div>
				</form>
				<script>
					function pw() {
						var pw1 = document.getElementById("pw1").value;
						var pw2 = document.getElementById("pw2").value;
						if (pw1 == pw2) {
							document.getElementById("tishi").innerHTML = "<font color='green'>两次密码相同</font>";
							document.getElementById("submit").disabled = false;
						} else {
							document.getElementById("tishi").innerHTML = "<font color='red'>两次密码不相同</font>";
							document.getElementById("submit").disabled = true;
						}
					}
				</script>
				<div class="back">
					<a href="../supplierLogin.jsp">前往登陆页面</a>
				</div>
				<div class="footer">
					<p>&copy; 2016 Pooled . All Rights Reserved</p>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>