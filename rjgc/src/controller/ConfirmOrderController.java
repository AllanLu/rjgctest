package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductModel;
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
		List<ProductModel> list = (List<ProductModel>)session.getAttribute("list");
		productinfoservice.saveHistory(list);
		
		//�������͵�confirmOrder.jsp��ʾ
		response.sendRedirect("confirmOrder.jsp");
		//response.setStatus(307); 
		//response.setHeader("Location","confirmOrder.jsp");  
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
			doPost(request,response);
	}
}