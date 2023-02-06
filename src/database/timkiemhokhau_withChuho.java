package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import model.hokhau_model;
import view.screen_view;

public class timkiemhokhau_withChuho {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemhokhau(String tenchuho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from hokhau where chuho = '"+tenchuho+"'";
			ResultSet rs = st.executeQuery(sql);
			int check = 0;
			screen_view.delete_table_hokhau();
			while(rs.next()) {
				hokhau_model hokhau = new hokhau_model();
				hokhau.chuho = rs.getString("chuho");
				hokhau.maho = rs.getString("maho");
				hokhau.diachi = rs.getString("diachi");
				hokhau.Sothanhvien =Integer.parseInt(rs.getString("sothanhvien"));
				screen_view.showRes_timkiemhokhau(hokhau);
				check = check +1;
			}
			if(check ==0) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy hộ khẩu phù hợp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
