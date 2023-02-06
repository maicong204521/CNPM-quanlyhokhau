package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.khoanthu_model;
import view.screen_view;

public class timkiemkhoanthu_withMakhoanthu {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemkhoanthu(String makhoanthu) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from khoanthu where makhoanthu = '"+ makhoanthu+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_khoanthu();
			int check = 0;
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khoản thu phù hợp!");
			}
			else {
				khoanthu_model khoanthu = new khoanthu_model();
				khoanthu.makhoanthu = rs.getString("makhoanthu");
				khoanthu.tenkhoanthu = rs.getString("tenkhoanthu");
				khoanthu.Sotien =Integer.parseInt(rs.getString("sotien")) ;
				khoanthu.loaikhoanthu = rs.getString("loaikhoanthu");check = check +1;
				screen_view.showRes_timkiemkhoanthu(khoanthu);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
