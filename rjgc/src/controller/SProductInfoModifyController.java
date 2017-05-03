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

import dao.ProductDao;
import model.ProductModel;


@WebServlet(urlPatterns = {"/ProductModifyController.do"})
public class SProductInfoModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		ProductModel product = new ProductModel();
		int productid = (int)request.getAttribute("productid");
		ProductDao pd = new ProductDao();
		try{
			product = pd.getProductByProductid(productid);
			if(product.equals(null)){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"null´íÎó\");");
				out.println("window.location.href='jsp/SupplierJsp/supplierIndex.jsp';");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("product", product);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/SupplierJsp/supplierAddProduct.jsp");
				rd.forward(request,response);
				
			
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
