<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UserModel" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.ShoppingcartModel" %>
<%@page import="service.ProductInfoService" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>确认订单</title>
</head>

<body>
</form>
<form name="form1" method="post" action="">
  <table width="750" height="431" border="0">
    <tr>
      <td width="744" height="122"><table width="700" border="0">
        <tr>
          <td><table width="700" border="0">
            <tr bgcolor="#CCCCCC">
              <th width="170" bgcolor="#CCCCCC" scope="col">收货人信息：</th>
              <th width="520" bgcolor="#CCCCCC" scope="col">&nbsp;</th>
            </tr>
            <tr>
              <td><div>收货人姓名：</div></td>
              <td><label for="textfield"></label>
                <input type="text" name="Buyername" id="textfield"></td>
            </tr>
            <tr>
              <td><div>收货人地址：</div></td>
              <td><label for="textfield2"></label>
                <input type="text" name="Buyeraddress" id="textfield2"></td>
            </tr>
            <tr>
              <td><div>联系电话：</div></td>
              <td><label for="textfield3"></label>
                <input type="text" name="Buyerphone" id="textfield3"></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td><table width="700" border="0">
        <tr bgcolor="#CCCCCC">
          <th width="170" scope="col">确认订单信息：</th>
          <th width="520" scope="col">&nbsp;</th>
        </tr>
      </table>
        <table width="700" border="1">
          <tr>
            <th width="134" scope="col">商品编号</th>
         
            <th width="95" scope="col">单价</th>
            <th width="95" scope="col">数量</th>
            <th width="108" scope="col">金额  </th>
          </tr>
          
          <%
		  UserModel user = (UserModel)request.getSession().getAttribute("user");
		  List<ShoppingcartModel>  cart = (List<ShoppingcartModel>) request.getSession().getAttribute("shoplist");
		
		  ProductModel product =new ProductModel();
		/*  for(ShoppingcartModel shoppingCart:cart){
				   out.println("<tr>");
	               out.println("<td>" + shoppingCart.getProductid() + "</td>"
				             // +"<td>" + shoppingCart.getProductname() + "</td>"
				              +"<td>" + shoppingCart.getProductprice() + "</td>" 
				              +"<td>" + shoppingCart.getProductnum() + "</td>"
				              +"<td>" + shoppingCart.getProductprice()* shoppingCart.getProductnum() + "</td>");
			  
		  }*/
		  for(int i=0;i<cart.size();i++){
			  ShoppingcartModel shoppingCart=cart.get(i);
			  
			   out.println("<tr>");
              out.println("<td>" + shoppingCart.getProductid() + "</td>"
			             // +"<td>" + shoppingCart.getProductname() + "</td>"
			              +"<td>" + shoppingCart.getProductprice() + "</td>" 
			              +"<td>" + shoppingCart.getProductnum() + "</td>"
			              +"<td>" + shoppingCart.getProductprice()* shoppingCart.getProductnum() + "</td>");
		  
	  		}

		  // for (ProductModel product : list) {
			//   out.println("<tr>");
            //   out.println("<td>" + product.getProductId() + "</td>"
			 //             +"<td>" + product.getProductName() + "</td>"
			//              +"<td>" + product.getProductPrice() + "</td>"
			 //             +"<td>" + shoppingcart.getProductnum() + "</td>"
			 //             +"<td>" + product.getProductPrice()* shoppingcart.getProductnum() + "</td>");
			//	out.println("</tr>");
        
		  %>
        </table>
      <p>&nbsp;</p></td>
    </tr>
    <tr>
      <td height="120"><table width="700" border="0">
        <tr bgcolor="#CCCCCC">
          <th width="171" scope="col">送货方式</th>
          <th width="519" scope="col">&nbsp;</th>
        </tr>
      </table>
        <table width="700" border="0">
          <tr>
            <td height="44"><p>
              <label>
                <input type="radio" name="RadioGroup1" value="10" id="RadioGroup1_0">
                顺丰 </label>
              <label>
                <input type="radio" name="RadioGroup1" value="8" id="RadioGroup1_1">
                中通</label>
               <label>
                 <input type="radio" name="RadioGroup1" value="6" id="RadioGroup1_2">
                EMS</label>
            </p></td>
          </tr>
        </table>
      <p>&nbsp;</p></td>
    </tr>
    <tr>
      <td><table width="700" border="0">
        <tr>
          <td width="389"><p>&nbsp;</p>
            <p>
              <label for="textarea"></label>
            </p></td>
          <td width="301"><table width="307" border="0">
            <tr>
              <td width="155">商品金额总计：</td>
              <td width="142">
              <%
			   //UserModel user = (UserModel)request.getSession().getAttribute("user");
		   List<ShoppingcartModel>  list = (List<ShoppingcartModel>) request.getSession().getAttribute("shoplist");
			  int total=0;
			  for(ShoppingcartModel shoppingcart:list)
			  {
				  total+=shoppingcart.getProductprice()*shoppingcart.getProductnum();
			  }
			  out.println(total);
			  session.setAttribute("total", total);
			  %>
              </td>
            </tr>
            <tr>
              <td>运费：</td>
              <td>              
              <%
			  //int Radio = (int)request.getParameterValues(RadioGroup1);
			  //out.println(Radio);
			  out.println(5);
			  %>
              </td>
            </tr>
            <tr>
              <td>您还需支付：</td>
              <td>
              <%
			  //int Radio = request.getValue("RadioGroup1");
			  //int Radio = (int)request.getParameterValues(RadioGroup1);
			  // List<ShoppingcartModel>  list = (List<ShoppingcartModel>) request.getSession().getAttribute("list");
			  //int total=0;
			 // for(ShoppingcartModel shoppingcart:shoplist)
			 // {
			//	  total+=product.getProductPrice()*shoppingcart.getProductnum();
			 // }
			  //out.println(Radio+total);
			  out.println(5+total);
			  %>
          
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="button" name="button1" id="button1" value="提交订单" onclick="javascript:window.location.href='pay.jsp'" /></td>
            </tr>
         
          </table></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</form>
<!--该jsp页面主要实现确认订单功能-->

</body>
</html>