package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		HttpSession session=request.getSession();
		int productnum=Integer.parseInt(request.getParameter("productnum"));
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
		//PrintWriter out=response.getWriter();
		//out.println("<html><body>");
		try {
			productdao.insertnewshoppingcart(shopcart);
			//out.println("添加成功！");
			response.sendRedirect("jsp/user/shoppingCart.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}