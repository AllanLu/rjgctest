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
 * 供应商注册
 */
@WebServlet("/SRegister.do")
public class SRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String rgmessage=null;//存储给页面的消息
		String sName=request.getParameter("suppliername");
		String password=request.getParameter("password");
		SupplierModel sModel=new SupplierModel();//封装
		sModel.setSuppliername(sName);
		sModel.setSupplierPassword(password);
		SupplierService ss=new SupplierService();
		int sid=ss.SupplierRegister(sModel);//调用注册服务
		sModel.setSupplierid(sid);
		//判断返回值的各种情况
		if(sid>=0){
			//返回正常sid，注册成功，转到主页
			session.setAttribute("supplier", sModel);
			response.sendRedirect("jsp/supplierindex.jsp");
		}else if(sid==-1){
			rgmessage="用户名已存在";
			session.setAttribute("message", rgmessage);
			session.setAttribute("flag",true);
			response.sendRedirect("jsp/SupplierJsp/supplierRegister.jsp");
		}else{
			rgmessage="数据库错误";
			session.setAttribute("message", rgmessage);
			session.setAttribute("flag",true);
			response.sendRedirect("jsp/SupplierJsp/supplierRegister.jsp");
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
