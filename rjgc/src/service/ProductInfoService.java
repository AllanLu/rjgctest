package service;
import model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.*;

public class ProductInfoService {
	public int addProductToProduct(ProductModel pModel){
		java.sql.Connection conn =null;
		ProductDao pDao=new ProductDao();
		SupplierModel supplier=new SupplierModel();
		SupplierDao sd=new SupplierDao();
		String productName=pModel.getProductname();
		String origin=pModel.getProductorigin();
		String pdate=pModel.getProductdate();
		String life=pModel.getProductlife();
		float price=pModel.getProductprice();
		String introduction=pModel.getProductintroduction();
		int storedid=Integer.parseInt(pModel.getStoredid());
		int stockNum=pModel.getStocknum();
		int sid=Integer.parseInt(pModel.getSupplierid());
		String image=pModel.getImage();
		String sql="insert into product(Productname,Productorigin,Productdate,Productlife,Productintrodution,Productprice,Supplierid,Stocknum,Storedid,imagepath)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,productName);
			ps.setString(2, origin);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=sdf.parse(pdate);
			java.util.Date lifedate=sdf.parse(life);
			Timestamp tdate=new Timestamp(date.getTime());
			Timestamp tlife=new Timestamp(lifedate.getTime());
			ps.setTimestamp(3, tdate);
			ps.setTimestamp(4, tlife);
			ps.setString(5, introduction);
			ps.setFloat(6, price);
			ps.setInt(7, sid);
			ps.setInt(8, stockNum);
			ps.setString(9,storedid+"");
			ps.setString(10, image);
			ps.execute();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
