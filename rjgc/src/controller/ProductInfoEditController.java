package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ProductModel;
import model.SupplierModel;
import service.ProductInfoService;

/**
 * Servlet implementation class ProductInfoEdit
 */
@WebServlet("/productinfoedit.do")
public class ProductInfoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 修改商品信息
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ProductModel pModel=(ProductModel)session.getAttribute("product");//获取pid
		String path="../images/";//调用路径
	    String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";//存储路径
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
		SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");
		int sid=sModel.getSupplierid();
		if(image==null){
			pModel.setImagepath(null);
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间
			//SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=df.format(new Date());
			path=path+sid+"_"+time+".jpg";
			imagePath=imagePath+sid+"_"+time+".jpg";//文件名格式：sid_20XX05XX10XX00.jpg
			pModel.setImagepath(path);
		}
		pModel.setProductdate(date);
		pModel.setProductname(productName);
		pModel.setProductorigin(origin);
		pModel.setProductprice(Float.parseFloat(price));
		pModel.setSupplierid(""+sid);
		pModel.setProductlife(life);
		pModel.setStocknum(Integer.parseInt(stockNum));
		pModel.setStoredid(storedid);
		pModel.setProductintroduction(introduction);
		ProductInfoService pService=new ProductInfoService();
		ProductModel result=pService.modifyProduct(pModel);
		if(result==null){
			message="修改信息失败";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/SupplierJsp/supplierChangeProduct.jsp");
		}else{
			session.setAttribute("product", result);
			response.sendRedirect("jsp/SupplierJsp/supplierChangeProduct.jsp");
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
