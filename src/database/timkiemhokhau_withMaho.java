package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import model.hokhau_model;
import view.screen_view;

public class timkiemhokhau_withMaho {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemhokhau(String maho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from hokhau where maho = '"+ maho +"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_hokhau();
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy hộ khẩu phù hợp!");
				
			}
			else {
				hokhau_model hokhau = new hokhau_model();
				hokhau.chuho = rs.getString("chuho");
				hokhau.maho = rs.getString("maho");
				hokhau.diachi = rs.getString("diachi");
				hokhau.Sothanhvien =Integer.parseInt(rs.getString("sothanhvien"));
				screen_view.showRes_timkiemhokhau(hokhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
