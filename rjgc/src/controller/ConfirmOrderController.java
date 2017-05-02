package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductModel;

@WebServlet(urlPatterns = {"/confirmOrderController.do"})
public class ConfirmOrderController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//确认支付控制器
		//获取用户信息
		//调用ProductInfoService的saveHistory(List<ProductModel> list)方法，将商品加入历史记录表
		//将参数送到confirmOrder.jsp显示
	}
}