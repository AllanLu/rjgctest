package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SupplierService;
import dao.SupplierDao;
import model.SupplierModel;
@WebServlet(urlPatterns = {"/sLoginController.do"})
public class SLoginController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		String Suppliername=request.getParameter("Suppliername");
		String SupplierPassword=request.getParameter("SupplierPassword");
		//先调用SLoginInfoCheck(String Suppliername,String SupplierPassword)验证用户名密码
		SupplierService supllierservice = new SupplierService();
		SupplierDao supplierdao = new SupplierDao();
		SupplierModel supplier = new SupplierModel();
		boolean flag=false;
		try {
			flag=supllierservice.SLoginInfoCheck(Suppliername, SupplierPassword);
			if (flag) {
				supplier = supplierdao.getSupplier(supplier);
				HttpSession session = request.getSession();
				System.out.println("g");
				session.setAttribute("supplier", supplier);
				//登录成功，根据flag跳转到对应的页面或Servlet，此模块还需要有代码补充
				response.sendRedirect("/sIndexController.do");
			} else {
				HttpSession session = request.getSession();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				//登录失败，返回登录错误
				System.out.println("gg");
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"用户名或密码错误\");");
				out.println("window.location.href='jsp/supplierLogin.jsp';");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				//response.sendRedirect("jsp/supplierLogin.jsp");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//验证错误，则返回supplierLogin.jsp
		//验证通过，则跳到/sIndexController.do
	}
}