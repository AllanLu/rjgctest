package dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import model.UserModel;

public class UserDao {
	String sql = "";
	
	/*用户登录用户和密码判断*/
	
	private Connection conn;
	
	
	public boolean LoginCheck(UserModel loginuser) throws SQLException {
		boolean i = false;
		conn=GetConnection.getConnection();
		try {
			sql = "select * from Buyer where Buyername=? and BuyerPassword=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//Context ctx=new InitialContext();//连接数据库的方法，数据库连接池，配置文件在tomcat\conf\Catalina\localhost\rjgc。xml
			//DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/rjgc");
			//Connection conn=ds.getConnection();
			pstmt.setString(1, loginuser.getName());
			pstmt.setString(2, loginuser.getPassword());
			//Statement stmt=conn.createStatement();
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
	}
	
	public boolean RegCheck(UserModel reguser) throws SQLException{
		boolean i=false;
		conn=GetConnection.getConnection();
		try{
			sql="select * from Buyer where Buyername=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,reguser.getName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				i=true;
			}else{
				i=false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	
	public void insertnewuser(UserModel newuser) throws SQLException{
		conn=GetConnection.getConnection();
		String sql="insert into Buyer(Buyername,Buyertel,Buyeraddress,BuyerPassword) values(?,?,?,?)";
		try{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,newuser.getName());
			pstmt.setString(2,newuser.getTel());
			pstmt.setString(3,newuser.getAddress());
			pstmt.setString(4,newuser.getPassword());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*获取完整用户对象*/
	public UserModel getUserByUsername(UserModel loginuser) throws SQLException {
		try {
			sql = "select * from Buyer where Buyername='"+loginuser.getName()+"'";
			//Context ctx=new InitialContext();//连接数据库的方法，数据库连接池，配置文件在tomcat\conf\Catalina\localhost\rjgc。xml
			//DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/rjgc");
			//Connection conn=ds.getConnection();
			conn=GetConnection.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) {
				UserModel user = new UserModel();
				//user.setId(rs.getInt("Buyerid"));
				user.setName(rs.getString("Buyername"));
				user.setTel(rs.getString("Buyertel"));
				user.setAddress(rs.getString("Buyeraddress"));
				user.setRealName(rs.getString("Realname"));
				//user.setRegion(rs.getString("Buyerregion"));
				rs.close();
				stmt.close();
				conn.close();
				return user;
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
}