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
		//List<ShoppingcartModel> shop=new ArrayList<ShoppingcartModel>();
		//ShoppingcartModel shop=new ShoppingcartModel();
		ProductInfoService productservice=new ProductInfoService();
		//shop= (ShoppingcartModel)session.getAttribute("shoppcart");
		//session.setAttribute("shop", shop);
		int shopid=(int) session.getAttribute("shopcartid");
		productservice.Dropshoppingcart(shopid);
		
		//String path=request.getContextPath(); 
		response.sendRedirect("jsp/UserJsp/shoppingCart.jsp");
		//购物车控制器,删除购物车表中的数据
		//传递ProductModel对象列表并跳转到shoppingCart.jsp显示给用户
	}
}