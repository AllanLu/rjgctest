package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductModel;
import dao.ProductDao;
import service.ProductInfoService;
@WebServlet(urlPatterns = {"/productInfoController.do"})
public class ProductInfoController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		ProductModel product =(ProductModel)session.getAttribute("product");
		ProductInfoService productservice=new ProductInfoService();	
		try {
			product=productservice.getProduct(product.getProductid());
			session.setAttribute("product", product);
			//response.sendRedirect("/jsp/productInfo.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path=request.getContextPath(); 
		response.sendRedirect(path+"/jsp/productInfo.jsp");
		//test
		//��Ʒ��Ϣ������������Productid����ProductInfoService���getProduct(int Productid)������ȡ��Ʒ��Ϣ
		//���ProductModel���󣬴��ݲ�������ת��productInfo.jsp��ʾ��Ʒ��Ϣ
	}
}