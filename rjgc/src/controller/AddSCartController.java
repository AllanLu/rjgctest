package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		//int productnum=Integer.parseInt((String)session.getAttribute("productnum"));
		int productnum=(int)session.getAttribute("productnum");
		ProductModel product =(ProductModel)session.getAttribute("product");
		UserModel user = (UserModel)request.getSession().getAttribute("user");
		//boolean flag=(boolean)session.getAttribute("flag");
		int Productid=product.getProductid();
		float Productprice=product.getProductprice();
		float price=Productprice*productnum;
		String username=user.getName();
		int userid=user.getId();
		//int sid=(int)session.getAttribute("Supplierid");
		//�ж��Ƿ��¼������¼�ˣ����ProductModel����productInfo.jspҳ��
		//boolean islogin=(boolean)session.getAttribute("islogin");
		ShoppingcartModel shopcart=new ShoppingcartModel();
		shopcart.setBuyername(username);
		shopcart.setProductid(Productid);
		shopcart.setProductnum(productnum);
		shopcart.setProductprice(price);
		shopcart.setBuyerid(userid);
		//shop.setShoppingcartid(shoppingcartid);//��ӹ��ﳵid��Ҫ���ⷽ��
		ProductDao productdao=new ProductDao();
		//PrintWriter out=response.getWriter();
		//out.println("<html><body>");
		try {
			productdao.insertnewshoppingcart(shopcart);
			//out.println("��ӳɹ���");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/UserJsp/shoppingCart.jsp");
			rd.forward(request,response);
			//response.sendRedirect("jsp/UserJsp/shoppingCart.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}