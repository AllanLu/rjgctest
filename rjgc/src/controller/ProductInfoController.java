package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/productInfoController.do"})
public class ProductInfoController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//产品信息控制器，根据Productid调用ProductInfoService类的getProduct(int Productid)方法获取商品信息
		//获得ProductModel对象，传递参数并跳转到productInfo.jsp显示产品信息
	}
}