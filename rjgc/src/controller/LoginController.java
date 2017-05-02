package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserModel;
import dao.UserDao;

@WebServlet(urlPatterns = {"/loginController.do"})
public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		String Buyername=request.getParameter("Buyername");
		String BuyerPassword=request.getParameter("BuyerPassword");
		//所传来界面的标记，flag决定了登录后跳转的界面或控制器
		String flag=request.getParameter("flag");
		//Productid在跳转产品信息界面时有用
		String Productid=request.getParameter("Productid");
		UserModel user = new UserModel();
		user.setName(Buyername);
		user.setPassword(BuyerPassword);
		UserDao userdao = new UserDao();
		boolean islogin = false;
		//调用LoginCheck方法检查用户名密码
		try {
			islogin = userdao.LoginCheck(user);
			if (islogin) {
				user = userdao.getUserByUsername(user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//登录成功，根据flag跳转到对应的页面或Servlet，此模块还需要有代码补充
				response.sendRedirect("index.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("eFlag", "error");
				//登录失败，返回登录错误
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}