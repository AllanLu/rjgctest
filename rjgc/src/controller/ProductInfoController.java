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
		//产品信息控制器，根据Productid调用ProductInfoService类的getProduct(int Productid)方法获取商品信息
		//获得ProductModel对象，传递参数并跳转到productInfo.jsp显示产品信息
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		ProductModel product = new ProductModel();
		int productid = 0;
		try{
			productid=Integer.parseInt(request.getParameter("productid"));
			}
		catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		ProductDao pd = new ProductDao();
		try{
			product = pd.getProductByProductid(productid);
			if(product.equals(null)){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"null错误\");");
				out.println("window.location.href='jsp/index.jsp';");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("product", product);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/productInfo.jsp");
				rd.forward(request,response);
				
			
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}