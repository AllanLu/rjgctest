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
	 * �޸���Ʒ��Ϣ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ProductModel pModel=(ProductModel)session.getAttribute("product");//��ȡpid
		String path="../images/";//����·��
	    String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";//�洢·��
		Part image=request.getPart("image");//���ͼƬ�ļ�
		String message="";
		//�����Ʒ����Ϣ
		String productName=request.getParameter("productName");
		String origin=request.getParameter("origin");
		String date=request.getParameter("date");
		String life=request.getParameter("life");
		String price=request.getParameter("price");
		String introduction=request.getParameter("introduction");
		String storedid=request.getParameter("storedid");
		String stockNum=request.getParameter("stockNum");
		String pType=request.getParameter("type");
		SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");
		int sid=sModel.getSupplierid();
		if(image==null){
			pModel.setImagepath(null);
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//��ȡ��ǰʱ��
			//SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=df.format(new Date());
			path=path+sid+"_"+time+".jpg";
			imagePath=imagePath+sid+"_"+time+".jpg";//�ļ�����ʽ��sid_20XX05XX10XX00.jpg
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
		pModel.setProductsort(pType);
		ProductInfoService pService=new ProductInfoService();
		ProductModel result=pService.modifyProduct(pModel);
		if(result==null){
			message="�޸���Ϣʧ��";
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
