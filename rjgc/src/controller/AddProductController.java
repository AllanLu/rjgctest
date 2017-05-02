package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.*;
import service.*;
/**
 * 商家新加商品
 */
@WebServlet("/addproduct.do")
@MultipartConfig
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受jsp页面传送的数据
		String path="../images/";//调用路径
	    String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";//存储路径
		HttpSession session=request.getSession();
		Part image=request.getPart("image");//获得图片文件
		String message="";
		//获得商品的信息
		String productName=request.getParameter("productName");
		String origin=request.getParameter("origin");
		String date=request.getParameter("date");
		String life=request.getParameter("life");
		String price=request.getParameter("price");
		String introduction=request.getParameter("introduction");
		String storedid=request.getParameter("storedid");
		String stockNum=request.getParameter("stockNum");
		//取得sid
		SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");
		int sid=sModel.getSupplierid();
		
		if(image==null){//判断图片是否存在
			message="缺少图片文件";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/supplierAddProduct.jsp");
		}else if(image.getSize()>3*1024*1024) {//判断大小是否超标
			image.delete();
			message="图片文件太大，请重新选择";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/supplierAddProduct.jsp");
		//连接数据库调用存储过程，并存放图片
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间
			//SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=df.format(new Date());
			path=path+sid+"_"+time+".jpg";
			imagePath=imagePath+sid+"_"+time+".jpg";//文件名格式：sid_20XX05XX10XX00.jpg
			//封装
			ProductModel pModel=new ProductModel();
			pModel.setProductdate(date);
			pModel.setProductname(productName);
			pModel.setProductorigin(origin);
			pModel.setProductprice(Float.parseFloat(price));
			pModel.setSupplierid(""+sid);
			pModel.setImage(path);
			pModel.setProductlife(life);
			pModel.setStocknum(Integer.parseInt(stockNum));
			pModel.setStoredid(storedid);
			pModel.setProductintroduction(introduction);
			//调用添加商品的服务类方法
			ProductInfoService pService=new ProductInfoService();
			int stat=pService.addProductToProduct(pModel);
			//判断返回值
			if(stat==0){
				File file=new File(imagePath);
				file.createNewFile();
				image.write(imagePath);
				message="游戏发布成功！";
				session.setAttribute("message", message);
				session.setAttribute("flag", true);
				response.sendRedirect("jsp/supplierindex.jsp");
			}else{
				message="添加失败";
				session.setAttribute("message", message);
				session.setAttribute("flag", true);
				response.sendRedirect("jsp/supplierAddProduct.jsp");
			}
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
