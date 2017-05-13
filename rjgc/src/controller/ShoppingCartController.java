package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductModel;
import service.ProductInfoService;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpSession;
import model.ShoppingcartModel;
import model.UserModel;
import model.ProductModel;
import dao.ProductDao;
import service.ProductInfoService;
@WebServlet(urlPatterns = {"/shoppingCartController.do"})
public class ShoppingCartController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		UserModel user=new UserModel();
		HttpSession session = request.getSession();
		user =(UserModel)session.getAttribute("user");
		List<ShoppingcartModel> shop=new ArrayList<ShoppingcartModel>();
		ProductInfoService productservice=new ProductInfoService();
		shop=productservice.getProductList(user.getId());
		session.setAttribute("shop", shop);
		//String path=request.getContextPath(); 
		response.sendRedirect("jsp/UserJsp/shoppingCart.jsp");
		//购物车控制器，调用ProductInfoService类的getProductList()方法获取session中的ProductModel对象列表
		//传递ProductModel对象列表并跳转到shoppingCart.jsp显示给用户
	}
}