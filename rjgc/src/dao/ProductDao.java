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
import model.ShoppingcartModel;
import model.UserModel;

public class ProductDao {
	String sql="";
	private Connection conn;
	/*��ȡ������Ʒ����*/
	public ProductModel getProductByProductid(int productid) throws SQLException {
		try {
			sql = "select * from Product where Productid=?";
			conn=GetConnection.getConnection();			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, productid);									
			ResultSet rs=pstmt.executeQuery();//error
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
				productinfo.setImagepath(rs.getString("Imagepath"));
				if (productid==0) System.out.println("error22");else System.out.println("ok22");

				rs.close();
				pstmt.close();
				conn.close();
				return productinfo;
			} else {
				rs.close();
				pstmt.close();
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
		//����getProductByProductid(ProductModel product)������ȡ������Ʒ��Ϣ
		conn=GetConnection.getConnection();
		try{
			sql="select * from Product where Supplierid=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Supplierid);
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
				product.setStoredid(rs.getString("Storedid"));
				product.setImagepath(rs.getString("Imagepath"));
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
	public boolean addProductToProduct(ProductModel product){
		boolean i=false;
		//��product�е����ݼ���Product����
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
				product.setImagepath(rs.getString("Imagepath"));
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
	
	public void insertnewshoppingcart(ShoppingcartModel newshoppingcart) throws SQLException{
		conn=GetConnection.getConnection();
		String sql="insert into Shoppingcart(Productid,Productnum,Productprice,Buyername) values(?,?,?,?)";
		try{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,newshoppingcart.getProductid());
			pstmt.setInt(2,newshoppingcart.getProductnum());
			pstmt.setFloat(3,newshoppingcart.getProductprice());
			pstmt.setString(4,newshoppingcart.getBuyername());
			//pstmt.setInt(5, newshoppingcart.getShoppingcartid());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
