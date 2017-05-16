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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收银台</title>
</head>

<body>
<!--该jsp页面用于提交订单后的付款功能-->
<!--<form action="${pageContext.request.contextPath}/servlet/PayServlet" method="post"> -->
<table width="80%" align="center">      
    <tr>  
                <td>
                <div class="main"> 
                 <h2 style="background-color:#009933">在线支付</h2>
  <div class="pay_main_cont">
		<div class="articleContent">
        <div class="allinpay">
         
          <hr/>
            <p class="yhwy">银行卡网银支付：</p>
            <div class="bankList">
                <p>
                  <label>
                    <input name="payment" value="1002" id="bank_icbc"  type="radio" />
                    <img src="../../images/icbc.gif" disabled alt="icbc" /></label>
                  <label>
                    <input name="payment" value="1005" id="bank_abc" type="radio" />
                    <img src="../../images/abc.gif" disabled alt="abc" /></label>
                  <label>
                    <input name="payment" value="1052" id="bank_boc" type="radio" />
                    <img src="../../images/boc.gif" disabled alt="boc" /></label>
                  <label>
                    <input name="payment" value="1003" id="bank_ccb" type="radio" />
                    <img src="../../images/ccb.gif" disabled alt="ccb" /></label>
                  <label>
                    <input name="payment" value="1020" id="bank_comm" type="radio" />
                    <img src="../../images/comm.gif" disabled alt="comm" /></label>
                    </p><p>
                  <label>
                    <input name="payment" value="1001" id="bank_cmb" type="radio" /> 
                    <img src="../../images/cmb.gif" disabled alt="cmb" /></label>
                  <label>
                    <input name="payment" value="1004" id="bank_spdb"  type="radio" />
                    <img src="../../images/spdb.gif" disabled alt="spdb" /></label>
                  <label>
                    <input name="payment" value="1006" id="bank_cmbc" type="radio" />
                    <img src="../../images/cmbc.gif" disabled alt="cmbc" /></label>
                  <label>
                    <input name="payment" value="1009" id="bank_cib" type="radio" />
                    <img src="../../images/cib.gif" disabled alt="cib" /></label>
                  <label>
                    <input name="payment" value="1022" id="bank_ceb"  type="radio" />
                    <img src="../../images/ceb.gif" disabled alt="ceb" /></label>
                </p>
                <p>
                  <label>
                     <input name="payment" value="1010" id="bank_pingan"  type="radio" />
                    <img src="../../images/pingan.gif" disabled alt="pingan" /></label>
                  <label>
                    <input name="payment" value="1021" id="bank_citic"  type="radio" />
                    <img src="../../images/citic.gif" disabled alt="citic" /></label>
                  <label>
                    <input name="payment" value="1028" id="bank_psbc"  type="radio" />
                    <img src="../../images/psbc.gif" disabled alt="psbc" /></label>
                  <label>
                       <input name="payment" value="1027" id="bank_cgb"  type="radio" />
                    <img src="../../images/cgb.gif" disabled alt="cgb" /></label>
              </p>
            </div>
         <!--   <div class="bankList">
                <label>
                <input type="radio" name="payment" value="7" /><strong style="line-height:38px; font-weight:normal">财付通支付：</strong>
                <img src="/themes/baifuni/public/images/bank_img/pt_cft.gif" class="zfb" />
                </label>
            </div>  -->
            <div class="bankList">
                <label>
                <input type="radio" name="payment" value="4" /><strong style="line-height:38px; font-weight:normal">支付宝支付：</strong>
                <img src="../../images/pt_zfb.gif" class="zfb" />
                </label>
            </div>        
            <div class="bankList">
                <label>
                <input type="radio" name="payment" value="8" />
                <strong style="line-height:38px; font-weight:normal">快钱支付：  </strong>
                <img src="../../images/pt_kuaiqian.gif" class="zfb" />
                </label>
            </div>
              <hr/>
            <p class="allinpayBtn" >
              <input type="image" name="Submit" src="../../images/qwzf.jpg" onclick="javascript:window.location.href='paySuccess.jsp'" />
            </p>
        </div>
        <div id="pay_form" style="display:none"></div>
    </div>
  </div>
 </div>
                </td>  
            </tr>  
            <tr>  
                <td align="center" bgcolor="#009933">Copyright 2017 by 141.</td>  
            </tr>  
        </table>  
   <!--</form>-->  
</body>
</html>