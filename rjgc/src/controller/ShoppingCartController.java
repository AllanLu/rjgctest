package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		System.out.println("111");
		//String path=request.getContextPath(); 
		response.sendRedirect("jsp/UserJsp/shoppingCart.jsp");
		//购物车控制器,删除购物车表中的数据
		//传递ProductModel对象列表并跳转到shoppingCart.jsp显示给用户
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		ProductModel product = new ProductModel();
		int shoppingcartid = 0;
		try{
			shoppingcartid=Integer.parseInt(request.getParameter("Shoppingcartid"));
			}
		catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		ProductDao pd = new ProductDao();
		ProductInfoService productservice=new ProductInfoService();
		//product = pd.getProductByProductid(productid);
		productservice.Dropshoppingcart(shoppingcartid);
		HttpSession session = request.getSession();
		//session.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/UserJsp/shoppingCart.jsp");
		rd.forward(request,response);
	
}}