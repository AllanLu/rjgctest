package service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import dao.*;
public class SupplierService {
	/**
	 * 供应商注册的数据库操作
	 * @param sModel
	 * @return
	 */
	public int SupplierRegister(SupplierModel sModel){
		java.sql.Connection conn =null;
		//获得数据库连接
		ProductDao pDao=new ProductDao();
		conn=pDao.getConnection();
		//获得注册信息
		String sName=sModel.getSuppliername();
		String password=sModel.getSupplierPassword();
		//查找是否存在重复用户名
		String sql="select Supplierid from supplier where Suppliername=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,sName);
			ResultSet rst=ps.executeQuery();
			//判断各种情况
			if(rst.next()){
				return -1;
			}else{
				//不重复的话向表中插入用户信息
				sql="insert into supplier(Suppliername,Supplierpassword)values(?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sName);
				ps.setString(2, password);
				ps.executeUpdate();
				sql="select Supplierid from supplier where Suppliername=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sName);
				rst=ps.executeQuery();
				//获得sid并返回
				if(rst.next()){
					int sid=rst.getInt("Supplierid");
					return sid;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -2;
	}
	/**
	 * 修改商户信息
	 * @param sModel
	 * @return
	 */
	public SupplierModel SupplierModify(SupplierModel sModel){
		java.sql.Connection conn =null;
		//获得数据库连接
		ProductDao pDao=new ProductDao();
		conn=pDao.getConnection();
		//提取sid
		int sid=sModel.getSupplierid();
		String sname=null;
		String stel=null;
		String sintro=null;
		String spw=null;
		String saddr=null;
		//先取出原有信息
		String sql="select * from supplier where Supplierid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ResultSet rst=ps.executeQuery();
			if(!rst.next()){
				return null;
			}else{
				sname=rst.getString(2);
				stel=rst.getString(3);
				saddr=rst.getString(4);
				sintro=rst.getString(5);
				spw=rst.getString(6);
			}
			//判断修改信息是否为null，密码是否为空，为空时不修改
			if(sModel.getSupplieraddress()!=null){
				saddr=sModel.getSupplieraddress();
			}
			if(sModel.getSupplierintroduction()!=null){
				sintro=sModel.getSupplierintroduction();
			}
			if(sModel.getSuppliertel()!=null){
				stel=sModel.getSuppliertel();
			}
			if(sModel.getSupplierPassword()!=null&&sModel.getSupplierPassword()!=""){
				spw=sModel.getSupplierPassword();
			}
			//更新数据库
			sql="update supplier set Suppliername=?,Suppliertel=?,Supplieraddress=?,Supplierintroduction=?,SupplierPassword=? where Supplierid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, stel);
			ps.setString(3, saddr);
			ps.setString(4, sintro);
			ps.setString(5, spw);
			ps.setInt(6, sid);
			//将修改后的数据返回
			if(!ps.execute()){
				sModel.setSuppliername(sname);
				sModel.setSuppliertel(stel);
				sModel.setSupplieraddress(saddr);
				sModel.setSupplierintroduction(sintro);
				sModel.setSupplierPassword(spw);
				return sModel;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
