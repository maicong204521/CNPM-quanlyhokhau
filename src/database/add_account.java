package database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class add_account {
	public static Connection connec = jdbc.getconConnection();
	public static Boolean addAccount(String user, String password) {
		int check;
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into account (user,password)"
					+"value ('"+user+"','"+password+"')";
			check = st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
