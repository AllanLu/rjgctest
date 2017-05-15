package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ProductModel;
import model.SupplierModel;

public class SupplierDao{
	String sql = "";
	private Connection conn;
	/*商家登录用户和密码判断*/
	public boolean SLoginCheck(SupplierModel supplier) throws SQLException {
		boolean i = false;
		conn=GetConnection.getConnection();
		try {
			sql = "select * from Supplier where Suppliername=? and SupplierPassword=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, supplier.getSuppliername());
			pstmt.setString(2, supplier.getSupplierPassword());
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				i = true;
			} else {
				i = false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		//验证supplier表中是否有输入的商家
	}
	
	/*获取完整商家对象*/
	public SupplierModel getSupplier(SupplierModel supplier) throws SQLException {
		//根据用户名从supplier表中获取完整商家对象
		conn=GetConnection.getConnection();
		try{
			sql="select * from Supplier where Suppliername=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, supplier.getSuppliername());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				supplier.setSupplierid(rs.getInt("Supplierid"));
				supplier.setSupplieraddress(rs.getString("Supplieraddress"));
				supplier.setSupplierintroduction(rs.getString("Supplierintroduction"));
				supplier.setSuppliertel(rs.getString("Suppliertel"));
			}
		rs.close();
		pstmt.close();
		conn.close();
		return supplier;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
	}
	
	public SupplierModel getSupplierbyid(SupplierModel supplier) throws SQLException {
		//根据用户名从supplier表中获取完整商家对象
		conn=GetConnection.getConnection();
		try{
			sql="select * from Supplier where Supplierid=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, supplier.getSupplierid());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				supplier.setSuppliername(rs.getString("Suppliername"));
				supplier.setSupplieraddress(rs.getString("Supplieraddress"));
				supplier.setSupplierintroduction(rs.getString("Supplierintroduction"));
				supplier.setSuppliertel(rs.getString("Suppliertel"));
			}
		rs.close();
		pstmt.close();
		conn.close();
		return supplier;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;	
	}
}
