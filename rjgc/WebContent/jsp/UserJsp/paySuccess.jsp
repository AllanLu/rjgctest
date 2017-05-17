<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付成功</title>
</head>

<body>
<!--该jsp页面用支付跳转-->
 
        <table width="80%" align="center">      
            <tr>  
                <td>
                <div class="main"> 
                 <h2 style="background-color:#009933">在线支付</h2>
  <div class="pay_main_cont">
		<div class="articleContent">
        <div class="allinpay">
         
          <hr/>
          <p class="yhwy" style="font-size:24px"><b>已支付成功,您的包裹已整装待发！谢谢！</b></p>
            <p class="yhwy" style="font-size:24px"><img src="../../images/baoguo.jpg" alt="cmb" width="436" height="257" disabled />&nbsp;</p>
              <hr/>
            <p class="backBtn" >
              <button onclick="javascript:window.location.href='../index.jsp'" style="width:120px;height:40px;"><b>返回首页</b></button>
            </p>
            <p class="backBtn" >&nbsp; </p>
        </div>
    </div>
  </div>
 </div>
                </td>  
            </tr>  
            <tr>  
                <td align="center" bgcolor="#009933">Copyright 2017 by 141.</td>  
            </tr>  
        </table>  
 
</body>
</html>