package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import model.ProductModel;

public class ProductDao {
	String sql="";
	private Connection conn;
	/*获取完整产品对象*/
	public ProductModel getProductByProductid(ProductModel product) throws SQLException {
		try {
			sql = "select * from Product where Productid='"+product.getProductid()+"'";
			//Context ctx=new InitialContext();//连接数据库的方法，数据库连接池，配置文件在tomcat\conf\Catalina\localhost\rjgc。xml
			//DataSource ds=(DataSource)ctx.lookup("java:/comp/envbc/rjgc");
			//Connection conn=ds.getConnection();
			conn=GetConnection.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) {
				ProductModel productinfo = new ProductModel();
				productinfo.setProductid(rs.getInt("Productid"));
				productinfo.setProductname(rs.getString("Productname"));
				productinfo.setProductorigin(rs.getString("Productorigin"));
				productinfo.setProductdate(rs.getString("Productdate"));
				productinfo.setProductlife(rs.getString("Productlife"));
				productinfo.setProductintroduction(rs.getString("Productintroduction"));
				productinfo.setProductprice(rs.getFloat("Productprice"));
				productinfo.setSupplierid(rs.getString("Supplierid"));
				productinfo.setStocknum(rs.getInt("Stocknum"));
				productinfo.setStoredid(rs.getString("Storedid"));
				
				//user.setRegion(rs.getString("Buyerregion"));
				rs.close();
				stmt.close();
				conn.close();
				return product;
			} else {
				rs.close();
				stmt.close();
				conn.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ProductModel> getProductBySupplierid(int Supplierid){
		List<ProductModel> productList =new ArrayList<ProductModel>();
		//调用getProductByProductid(ProductModel product)方法获取完整产品信息
		return productList;
	}
	
	public boolean addProductToProduct(ProductModel product){
		boolean i=false;
		//将product中的数据加入Product表中
		return i;
	}
	
	public ArrayList<ProductModel> Getall(){
		conn=GetConnection.getConnection();
		ArrayList<ProductModel> productList=null;
		productList=new ArrayList<ProductModel>();
		try{
			sql="select * from Product";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ProductModel product=new ProductModel();
				product.setProductid(rs.getInt("Productid"));
				product.setProductname(rs.getString("Productname"));
				product.setProductorigin(rs.getString("Productorigin"));
				product.setProductdate(rs.getString("Productdate".toString()));
				product.setProductintroduction(rs.getString("Productintroduction"));
				product.setProductprice(rs.getFloat("Productprice"));
				product.setSupplierid(rs.getString("Supplierid"));
				product.setStocknum(rs.getInt("Stocknum"));
				productList.add(product);
			}
			if(!productList.isEmpty()){
				return productList;
				//request.getSession().setAttribute("productList",productList);
				//response.sendRedirect("/rjgc/jsp/index.jsp");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
		}
}
