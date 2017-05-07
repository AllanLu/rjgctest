package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.ProductModel;

/**
 * Servlet implementation class ProductSort
 */
@WebServlet(urlPatterns = {"/Productsort.do"})
public class ProductSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
    	ArrayList<ProductModel> productList=null;
		ProductModel product = new ProductModel();
		String productsort="";
		try{
			productsort=request.getParameter("productsort");
			}
		catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		ProductDao pd = new ProductDao();
		try{
			productList = pd.sort(productsort);
			if(productList.equals(null)){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"null´íÎó\");");
				out.println("window.location.href='jsp/index.jsp';");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");				
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("productList", productList);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/productsort.jsp");
				rd.forward(request,response);
				
			
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
