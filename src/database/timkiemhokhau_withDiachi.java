package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.hokhau_model;
import view.screen_view;

public class timkiemhokhau_withDiachi {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemhokhau(String diachi) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from hokhau where diachi = '"+diachi+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_hokhau();
			int check = 0;
			while(rs.next()) {
				hokhau_model hokhau = new hokhau_model();
				hokhau.chuho = rs.getString("chuho");
				hokhau.maho = rs.getString("maho");
				hokhau.diachi = rs.getString("diachi");
				hokhau.Sothanhvien =Integer.parseInt(rs.getString("sothanhvien"));
				check = check +1;
				screen_view.showRes_timkiemhokhau(hokhau);
				
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
