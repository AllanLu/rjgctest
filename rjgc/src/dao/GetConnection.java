package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://czyang.cn:3306/rjgc";
		String name = "root";
		String password = "123456";
		Connection con = null;
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(url, name, password);
				System.out.println("已获得数据库的连接");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}

	/*public static void main(String args[]) {
		getConnection();
	}*/

}
