package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.hokhau_model;
import model.nhankhau_model;
import view.screen_view;

public class TimkiemNhankhau_withId {
	public static Connection connec = jdbc.getconConnection();
	
	public static void timkiem_nhankhau(String idnhankhau) {
		try {
			nhankhau_model nhankhau = new nhankhau_model();
			nhankhau.hokhau  = new hokhau_model();
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau where id = '"+idnhankhau+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy nhân khẩu phù hợp !");
			}
			else {	
					
					nhankhau.id_nhankhau = rs.getString("id");
					nhankhau.cmnd = rs.getString("Cmnd");
					nhankhau.name_nhankhau = rs.getString("ten");
					nhankhau.age_nhankhau =Integer.parseInt( rs.getString("tuoi"));
					nhankhau.gioitinh = rs.getString("gioitinh");
					nhankhau.sdt = rs.getString("sdt");
					nhankhau.quanheChuho = rs.getString("quanhechuho");
					nhankhau.diachi = rs.getString("diachi");
					nhankhau.dantoc = rs.getString("dantoc");
					nhankhau.hokhau.maho = rs.getString("maho");
					screen_view.delete_table_nhankhau();
					screen_view.showRes_timkiemnhankhau(nhankhau);
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
