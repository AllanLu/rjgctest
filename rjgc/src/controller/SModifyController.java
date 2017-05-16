package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import service.*;
/**
 * Servlet implementation class SModifyController
 */
@WebServlet("/SModify.do")
public class SModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");//获取sid
		//获得修改的信息
		String stel=request.getParameter("suppliertel");
		String sintro=request.getParameter("supplierintro");
		String spw=request.getParameter("supplierpassword");
		String saddr=request.getParameter("supplieraddress");
		String sname=request.getParameter("suppliername");
		String message=null;
		sModel.setSupplieraddress(saddr);
		sModel.setSupplierintroduction(sintro);
		sModel.setSuppliertel(stel);
		sModel.setSupplierPassword(spw);
		sModel.setSuppliername(sname);
		//调用服务类方法
		SupplierService service=new SupplierService();
		SupplierModel result=service.SupplierModify(sModel);
		//判断返回
		if(result==null){
			message="修改信息失败";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/SupplierJsp/supplierModify.jsp");
		}else if(result.getSupplierid()==-1){
			message="用户名已存在";
			session.setAttribute("message", message);
			session.setAttribute("flag",true);
			response.sendRedirect("jsp/SupplierJsp/supplierModify.jsp");
		}else{
			session.setAttribute("supplier", result);
			response.sendRedirect("jsp/SupplierJsp/supplierModify.jsp");
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
