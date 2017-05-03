package service;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import dao.*;

public class ProductInfoService {
	private Connection conn0;
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

	public ProductModel getProduct(int Productid) throws SQLException{
		ProductModel product = new ProductModel();	
		ProductDao pd=new ProductDao();
		product.setProductid(Productid);
		product=pd.getProductByProductid(Productid);
		//将Productid写到product中，并调用getProductByProductid(ProductModel product)方法获取完整产品信息
		return product;
	}
	//根据userid 查询购物车
	public List<ShoppingcartModel> getProductList(int Userid){
		String sql="";
		List<ShoppingcartModel> shoppingcartlist = new ArrayList<ShoppingcartModel>();
		conn0=GetConnection.getConnection();
		try{
			sql="select * from Shoppingcart where userid=?";
			PreparedStatement pstmt=conn0.prepareStatement(sql);
			pstmt.setInt(1, Userid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ShoppingcartModel shopping=new ShoppingcartModel();
				shopping.setBuyerid(rs.getInt("Buyerid"));
				shopping.setProductid(rs.getInt("Productid"));
				shopping.setProductnum(rs.getInt("Productnum"));
				shopping.setProductprice(rs.getFloat("Productdate"));
				shoppingcartlist.add(shopping);
			}
			if(!shoppingcartlist.isEmpty()){
				return shoppingcartlist;
				//request.getSession().setAttribute("productList",productList);
				//response.sendRedirect("/rjgc/jsp/index.jsp");
			}
			rs.close();
			pstmt.close();
			conn0.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
		}
	
	public ArrayList<ShoppingcartModel> Getall(){
		String sql="";
		conn0=GetConnection.getConnection();
		ArrayList<ShoppingcartModel> shoppingcartList=null;
		shoppingcartList=new ArrayList<ShoppingcartModel>();
		try{
			sql="select * from Shoppingcart";
			PreparedStatement pstmt=conn0.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ShoppingcartModel shopping=new ShoppingcartModel();
				shopping.setBuyerid(rs.getInt("Buyerid"));
				shopping.setProductid(rs.getInt("Productid"));
				shopping.setProductnum(rs.getInt("Productnum"));
				shopping.setProductprice(rs.getFloat("Productdate"));
				shoppingcartList.add(shopping);
			}
			if(!shoppingcartList.isEmpty()){
				return shoppingcartList;
				//request.getSession().setAttribute("productList",productList);
				//response.sendRedirect("/rjgc/jsp/index.jsp");
			}
			rs.close();
			pstmt.close();
			conn0.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
		}
		//获取购物车列表
		
}
