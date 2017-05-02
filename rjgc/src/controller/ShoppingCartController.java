package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/shoppingCartController.do"})
public class ShoppingCartController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//购物车控制器，调用ProductInfoService类的getProductList()方法获取session中的ProductModel对象列表
		//传递ProductModel对象列表并跳转到shoppingCart.jsp显示给用户
	}
}