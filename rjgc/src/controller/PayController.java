package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/payController.do"})
public class PayController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//支付控制器，接收购物车或商品Total price
		//
		HttpSession session=request.getSession(true);
		String username=(String)session.getAttribute("username");
		String price=request.getParameter("price");
		request.setAttribute("username",username);
		request.setAttribute("price",price);
		RequestDispatcher rd=request.getRequestDispatcher("/pay.jsp");
		rd.forward(request,response);
	}
}