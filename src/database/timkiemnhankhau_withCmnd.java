package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import model.hokhau_model;
import model.nhankhau_model;
import view.screen_view;

public class timkiemnhankhau_withCmnd {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemnhankhau(String cmnd) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau where Cmnd = '"+ cmnd+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_nhankhau();
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "Khong tim thay nhan khau phu hop");
				
			}
			else {
				nhankhau_model nhankhau = new nhankhau_model();
				nhankhau.hokhau = new hokhau_model();
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
				screen_view.showRes_timkiemnhankhau(nhankhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
