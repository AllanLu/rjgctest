package service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import dao.*;
public class SupplierService {
	/**
	 * 渚涘簲鍟嗘敞鍐岀殑鏁版嵁搴撴搷浣�
	 * @param sModel
	 * @return
	 */
	public int SupplierRegister(SupplierModel sModel){
		java.sql.Connection conn =null;
		//鑾峰緱鏁版嵁搴撹繛鎺�
		conn=GetConnection.getConnection();
		//鑾峰緱娉ㄥ唽淇℃伅
		String sName=sModel.getSuppliername();
		String password=sModel.getSupplierPassword();
		//鏌ユ壘鏄惁瀛樺湪閲嶅鐢ㄦ埛鍚�
		String sql="select Supplierid from Supplier where Suppliername=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,sName);
			ResultSet rst=ps.executeQuery();
			//鍒ゆ柇鍚勭鎯呭喌
			if(rst.next()){
				return -1;
			}else{
				//涓嶉噸澶嶇殑璇濆悜琛ㄤ腑鎻掑叆鐢ㄦ埛淇℃伅
				sql="insert into Supplier(Suppliername,Supplierpassword)values(?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sName);
				ps.setString(2, password);
				ps.executeUpdate();
				sql="select Supplierid from Supplier where Suppliername=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, sName);
				rst=ps.executeQuery();
				//鑾峰緱sid骞惰繑鍥�
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
	 * 淇敼鍟嗘埛淇℃伅
	 * @param sModel
	 * @return
	 */
	public SupplierModel SupplierModify(SupplierModel sModel){
		java.sql.Connection conn =null;
		//鑾峰緱鏁版嵁搴撹繛鎺�
		conn=GetConnection.getConnection();
		//鎻愬彇sid
		int sid=sModel.getSupplierid();
		String sname=null;
		String stel=null;
		String sintro=null;
		String spw=null;
		String saddr=null;
		//鍏堝彇鍑哄師鏈変俊鎭�
		String sql="select * from Supplier where Supplierid=?";
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
			//鍒ゆ柇淇敼淇℃伅鏄惁涓簄ull锛屽瘑鐮佹槸鍚︿负绌猴紝涓虹┖鏃朵笉淇敼
			if(sModel.getSupplieraddress()!=null){
				saddr=sModel.getSupplieraddress();
			}
			if(sModel.getSupplierintroduction()!=null&&sModel.getSupplierintroduction()!=""){
				sintro=sModel.getSupplierintroduction();
			}
			if(sModel.getSuppliertel()!=null){
				stel=sModel.getSuppliertel();
			}
			if(sModel.getSupplierPassword()!=null&&sModel.getSupplierPassword()!=""){
				spw=sModel.getSupplierPassword();
			}
			if(sModel.getSuppliername()!=null&&sModel.getSuppliername()!=""&&sModel.getSuppliername()!=sname){
				sname=sModel.getSuppliername();
				sql="select Supplierid from Supplier where Suppliername=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1,sname);
				rst=ps.executeQuery();
				//鏄惁閲嶅悕
				if(rst.next()){
					sModel.setSupplierid(-1);
					return sModel;
				}
				
			}
			//鏇存柊鏁版嵁搴�
			sql="update Supplier set Suppliername=?,Suppliertel=?,Supplieraddress=?,Supplierintroduction=?,SupplierPassword=? where Supplierid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, stel);
			ps.setString(3, saddr);
			ps.setString(4, sintro);
			ps.setString(5, spw);
			ps.setInt(6, sid);
			//灏嗕慨鏀瑰悗鐨勬暟鎹繑鍥�
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
	//锟斤拷锟斤拷
			public boolean SLoginInfoCheck(String Suppliername,String SupplierPassword) throws SQLException {
				boolean i = false;
				SupplierModel supplier=new SupplierModel();
				SupplierDao sd=new SupplierDao();
				supplier.setSuppliername(Suppliername);
				supplier.setSupplierPassword(SupplierPassword);
				i=sd.SLoginCheck(supplier);
				//锟斤拷锟斤拷SupplierDao锟叫碉拷SLoginCheck锟斤拷锟斤拷锟斤拷锟斤拷证supplier锟斤拷锟斤拷锟角凤拷锟斤拷锟斤拷锟斤拷锟斤拷碳锟�
				return i;
			}
			
			public SupplierModel getSupplierByName(String Suppliername) throws SQLException {
				SupplierModel supplier=new SupplierModel();
				//锟斤拷Suppliername锟斤拷锟斤拷supplier锟斤拷锟斤拷锟斤拷
				//锟斤拷锟斤拷SupplierDao锟斤拷getSupplier(SupplierModel supplier)锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷锟教家讹拷锟斤拷
				return supplier;
			}
	
}
