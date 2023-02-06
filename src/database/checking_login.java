package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class checking_login {
	public static Connection connec = jdbc.getconConnection();
	public static Boolean check(String user, String password) {
		int check = 0;
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select password from account where user = '"+user+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("password").equals(password)) {
					return true;
				}
				else {
					System.out.print("mat khau khong chinh xac");
					return false;
				}
			}
			else {
				System.out.print("khong co ten dang nhap");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
	}
}
