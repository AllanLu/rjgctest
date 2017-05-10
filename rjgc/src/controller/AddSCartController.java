package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ProductModel;
import model.ShoppingcartModel;
import model.UserModel;
import service.ProductInfoService;
import dao.ProductDao;
@WebServlet(name="addscartcontrol",urlPatterns = {"/addSCartController.do"})
public class AddSCartController extends HttpServlet {
	//public  AddSCartController()
	//{
	//	super();
	//}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//接收ProductModel对象和flag
		//String path="../images/";
	    //String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";
		HttpSession session=request.getSession();
		//Part image=request.getPart("image");
		//String message="";
		//String productName=request.getParameter("productName");
		//String origin=request.getParameter("origin");
		//String date=request.getParameter("date");
		//String life=request.getParameter("life");
		//String price=request.getParameter("price");
		//String introduction=request.getParameter("introduction");
		//String storedid=request.getParameter("storedid");
		//String stockNum=request.getParameter("stockNum");
		int productnum=Integer.parseInt(request.getParameter("Productnum"));
		ProductModel product =(ProductModel)session.getAttribute("product");
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		//boolean flag=(boolean)session.getAttribute("flag");
		int Productid=product.getProductid();
		float Productprice=product.getProductprice();
		float price=Productprice*productnum;
		String username=user.getName();
		//int sid=(int)session.getAttribute("Supplierid");
		//判断是否登录，若登录了，则带ProductModel返回productInfo.jsp页面
		//boolean islogin=(boolean)session.getAttribute("islogin");
		ShoppingcartModel shopcart=new ShoppingcartModel();
		shopcart.setBuyername(username);
		shopcart.setProductid(Productid);
		shopcart.setProductnum(productnum);
		shopcart.setProductprice(price);
		//shop.setShoppingcartid(shoppingcartid);//添加购物车id需要特殊方法
		ProductDao productdao=new ProductDao();
		try {
			productdao.insertnewshoppingcart(shopcart);
			response.sendRedirect("jsp/productinfo.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}