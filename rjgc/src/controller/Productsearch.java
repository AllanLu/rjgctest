package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Productsearch
 */
@WebServlet(urlPatterns = {"/Productsearch.do"})
public class Productsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
    	response.setContentType("text/html;charset=utf-8");
    	request.setCharacterEncoding("utf-8");
    	ArrayList<ProductModel> productList=null;
		ProductModel product = new ProductModel();
		String search="";
		try{
			search=request.getParameter("keyword");
			System.out.println(search);
			}
		catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		ProductDao pd = new ProductDao();
		try{
			productList = pd.search(search);
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
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/productsearch.jsp");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}