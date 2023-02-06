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

public class timkiemnhankhau_withmaho {
	public static Connection connec = jdbc.getconConnection();
	public static void timkiemnhankhau(String maho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau where maho = '"+ maho +"'";
			ResultSet rs = st.executeQuery(sql);
			int check = 0;
			nhankhau_model nhankhau = new nhankhau_model();
			nhankhau.hokhau = new hokhau_model();
			screen_view.delete_table_nhankhau();
			while(rs.next()) {
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
				check = check +1;
			}
			if(check == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin nhân khẩu phù hợp!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
