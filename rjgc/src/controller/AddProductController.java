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
 * �̼��¼���Ʒ
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
		//����jspҳ�洫�͵�����
		String path="../images/";//����·��
	    String imagePath =request.getSession().getServletContext().getRealPath("")+"/images/";//�洢·��
		HttpSession session=request.getSession();
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
		//ȡ��sid
		SupplierModel sModel=(SupplierModel)session.getAttribute("supplier");
		int sid=sModel.getSupplierid();
		
		if(image==null){//�ж�ͼƬ�Ƿ����
			message="ȱ��ͼƬ�ļ�";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/supplierAddProduct.jsp");
		}else if(image.getSize()>3*1024*1024) {//�жϴ�С�Ƿ񳬱�
			image.delete();
			message="ͼƬ�ļ�̫��������ѡ��";
			session.setAttribute("message", message);
			session.setAttribute("flag", true);
			response.sendRedirect("jsp/supplierAddProduct.jsp");
		//�������ݿ���ô洢���̣������ͼƬ
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//��ȡ��ǰʱ��
			//SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=df.format(new Date());
			path=path+sid+"_"+time+".jpg";
			imagePath=imagePath+sid+"_"+time+".jpg";//�ļ�����ʽ��sid_20XX05XX10XX00.jpg
			//��װ
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
			pModel.setProductsort(pType);
			//���������Ʒ�ķ����෽��
			ProductInfoService pService=new ProductInfoService();
			int stat=pService.addProductToProduct(pModel);
			//�жϷ���ֵ
			if(stat==0){
				File file=new File(imagePath);
				file.createNewFile();
				image.write(imagePath);
				message="�ɹ���";
				session.setAttribute("message", message);
				session.setAttribute("flag", true);
				response.sendRedirect("jsp/SupplierJsp/supplierindex.jsp");
			}else{
				message="���ʧ��";
				session.setAttribute("message", message);
				session.setAttribute("flag", true);
				response.sendRedirect("jsp/SupplierJsp/supplierAddProduct.jsp");
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

