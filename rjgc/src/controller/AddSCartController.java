package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ProductModel;
import service.ProductInfoService;

@WebServlet(urlPatterns = {"/addSCartController.do"})
public class AddSCartController extends HttpServlet {
	public  AddSCartController()
	{
		super();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		//接收ProductModel对象和flag
		String path="../images/";
	    String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";
		HttpSession session=request.getSession();
		Part image=request.getPart("image");
		String message="";
		String productName=request.getParameter("productName");
		String origin=request.getParameter("origin");
		String date=request.getParameter("date");
		String life=request.getParameter("life");
		String price=request.getParameter("price");
		String introduction=request.getParameter("introduction");
		String storedid=request.getParameter("storedid");
		String stockNum=request.getParameter("stockNum");
		boolean flag=(boolean)session.getAttribute("flag");
		int Productid=(int)session.getAttribute("Productid");
		int sid=(int)session.getAttribute("Supplierid");
		//判断是否登录，若登录了，则带ProductModel返回productInfo.jsp页面
		boolean islogin=(boolean)session.getAttribute("islogin");
		if(islogin)
		{
			ProductModel pModel=new ProductModel();
			pModel.setProductdate(date);
			pModel.setProductname(productName);
			pModel.setProductorigin(origin);
			pModel.setProductprice(Float.parseFloat(price));
			pModel.setSupplierid(""+sid);
			pModel.setImagepath(path);
			pModel.setProductlife(life);
			pModel.setStocknum(Integer.parseInt(stockNum));
			pModel.setStoredid(storedid);
			pModel.setProductintroduction(introduction);
			ProductInfoService pService=new ProductInfoService();
			response.sendRedirect("jsp/productInfo.jsp");
		}
		//否则，跳转到login.jsp，带上参数flag和Productid
		else
		{
			session.setAttribute("flag", flag);
			session.setAttribute("Productid", Productid);
			response.sendRedirect("jsp/login.jsp");
		}
	}
}