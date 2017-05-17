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
		//ȷ��֧��������
		
		//��ȡ�û���Ϣ
		UserService userservice=new UserService();
		HttpSession session = request.getSession();
		UserModel user =userservice.getUserFromSession(session);
		
		//����ProductInfoService��saveHistory(List<ProductModel> list)����������Ʒ������ʷ��¼��
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
		
		
		
		//�������͵�confirmOrder.jsp��ʾ
		
		//response.setStatus(307); 
		//response.setHeader("Location","confirmOrder.jsp");  
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
			doPost(request,response);
	}
}