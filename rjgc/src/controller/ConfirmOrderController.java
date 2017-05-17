package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductModel;
import model.ShoppingcartModel;
import model.UserModel;
import service.ProductInfoService;
import service.UserService;

@WebServlet(urlPatterns = {"/confirmOrderController.do"})
public class ConfirmOrderController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//确认支付控制器
		
		//获取用户信息
		UserService userservice=new UserService();
		HttpSession session = request.getSession();
		UserModel user =userservice.getUserFromSession(session);
		
		//调用ProductInfoService的saveHistory(List<ProductModel> list)方法，将商品加入历史记录表
		ProductInfoService productinfoservice=new ProductInfoService();
		List<ShoppingcartModel> list0 = (List<ShoppingcartModel>)session.getAttribute("shoplist");
		List<ShoppingcartModel> list1=new ArrayList<ShoppingcartModel>();
		//session.removeAttribute("shoplist");
		String[] prolist=request.getParameterValues("product");
		if(prolist!=null)
		{
			int num=0,leng=prolist.length,i=0,j=0;
			for(i=0;i<leng;i++)
			{
				list1.add(list0.get(Integer.parseInt(prolist[i])));
			}
			session.setAttribute("shoplist", list1);
			//productinfoservice.saveHistory(list1);
			response.sendRedirect("jsp/UserJsp/confirmOrder.jsp");
		}
		else
			response.sendRedirect("jsp/UserJsp/shoppingCart.jsp");
		
		
		
		//将参数送到confirmOrder.jsp显示
		
		//response.setStatus(307); 
		//response.setHeader("Location","confirmOrder.jsp");  
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
			doPost(request,response);
	}
}