package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.UserModel;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet(urlPatterns = {"/UModify.do"})
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			//��������Reg.jsp��ע���û����� ���ж��û����Ƿ��Ѿ����ڣ�������flag1=1��δ���ھ͵���adduser��ӽ����ݿ⣬flag2=1��
			response.setContentType("text/html;charset=utf-8");
			String Buyername=request.getParameter("Buyername");	
			String BuyerPassword=request.getParameter("BuyerPassword");
			String BuyerTelephone=request.getParameter("BuyerTelephone");
			String BuyerAddress=request.getParameter("BuyerAddress");
			String BuyerRealname=request.getParameter("BuyerRealname");
			String BuyerId=request.getParameter("BuyerId");
			UserModel user=new UserModel();
			user.setName(Buyername);
			user.setPassword(BuyerPassword);
			user.setTel(BuyerTelephone);
			user.setAddress(BuyerAddress);
			user.setRealName(BuyerRealname);
			user.setId(Integer.parseInt(BuyerId));
			UserDao userdao=new UserDao();
			try{
					userdao.changeinfo(user);
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("jsp/index.jsp");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

}
