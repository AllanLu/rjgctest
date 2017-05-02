package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addSCartController.do"})
public class AddSCartController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//接收ProductModel对象和flag
		//判断是否登录，若登录了，则带ProductModel返回productInfo.jsp页面
		//否则，跳转到login.jsp，带上参数flag和Productid
		//
	}
}