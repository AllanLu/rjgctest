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

import dao.ProductDao;
import model.ProductModel;
import model.SupplierModel;
@WebServlet(urlPatterns = {"/sIndexController.do"})
public class SIndexController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		SupplierModel supplier=new SupplierModel();
		HttpSession session = request.getSession();
		supplier=(SupplierModel)session.getAttribute("supplier");
		ProductDao productdao=new ProductDao();
		List<ProductModel> productList =new ArrayList<ProductModel>();
		productList=productdao.getProductBySupplierid(supplier.getSupplierid());
		session.setAttribute("productList", productList);
		response.sendRedirect("jsp/SupplierJsp/supplierIndex.jsp");
		//调用ProductDao的getProductBySupplierid(int Supplierid)获取该商家已上线的商品列表
		//并显示到主页上
	}
}