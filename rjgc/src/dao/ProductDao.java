package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDao {
	private String driver = "com.mysql.jdbc.Driver";
	private String dburl = "jdbc:mysql://localhost:3306/rjgc?user=root&password=123456&useUnicode=true&characterEncoding=utf8";
	private java.sql.Connection conn =null;
	public java.sql.Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
