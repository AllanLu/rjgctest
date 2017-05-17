<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商家注册</title>
<link href="../../css/sModify.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
  <div class = "row">
	<div class = "col-md-4"></div>
	 <div class="col-md-4"> 		
      <form id="regist" action="../SRegister.do" method="post" class = "form-horizontal">
                <div class="center">
                	<h2 class="text-center text-success">供应商注册</h2>			
						<%
						if (session.getAttribute("flag") != null&&session.getAttribute("message")!=null) {
							String message = (String) session.getAttribute("message");
							out.print("<font color='red'>" + message + "</font><br>");
							session.removeAttribute("flag");
							session.removeAttribute("message");
						}
						%>
						 
						<div class="form-group">
        					<label for="exampleInputEmail1"><strong>供应商名称</strong></label>
        					<input type="text"
							name="suppliername" style="width:90%" class="form-control" />
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1"><strong>密码</strong></label>
        					 <input type="password"
							name="password" style="width:90%" class="form-control" id="pw1"  />
      					</div>
      					<div class="form-group">
        					<label for="exampleInputEmail1"><strong>重复密码</strong></label>
        					<input type="password"
							name="passwordr" style="width:90%" class="form-control" id="pw2" onKeyUp="pw()" />
		          		  <a id="tishi">
      					</div>
						  
						  <input type="submit" class="btn btn-success" value="注册" style="margin:0 0 0 20px" >
				          <button href="supplierLogin.jsp" style="margin:0 0 0 50px" class="btn btn-success">返回登录</button> 
                         
                </div>
         </form>
    				<script>
					function pw() {
						var pw1 = document.getElementById("pw1").value;
						var pw2 = document.getElementById("pw2").value;
						if (pw1 == pw2) {
							document.getElementById("tishi").innerHTML = "<font color='green'>两次输入密码一致</font>";
							document.getElementById("submit").disabled = false;
						} else {
							document.getElementById("tishi").innerHTML = "<font color='red'>密码不一致</font>";
							document.getElementById("submit").disabled = true;
						}
					}
					</script>
   </div>
   </div>
 </div>
</body>
</html>