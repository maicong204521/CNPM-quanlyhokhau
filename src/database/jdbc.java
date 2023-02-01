package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
	public static Connection getconConnection() {
		Connection c= null;
		java.sql.Driver driver;
		try {
			
			String url = "jdbc:mysql://localhost:3306/ontap1";
			String user = "root";
			String password = "";
			c = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	public static void closeConnection (Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
