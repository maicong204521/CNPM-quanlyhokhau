package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.hokhau_model;
import model.nhankhau_model;
import model.quanly_model;
import view.screen_view;

public class thongkeNhankhau {
	public static Connection connec = jdbc.getconConnection();
	public static void Thongke_gioitinh(String gioitinh) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau where gioitinh = '"+ gioitinh +"'";
			ResultSet rs = st.executeQuery(sql);
			nhankhau_model nhankhau = new nhankhau_model();
			
			while(rs.next()) {
				nhankhau.id_nhankhau = rs.getString("id");
				nhankhau.cmnd = rs.getString("cmnd");
				nhankhau.name_nhankhau = rs.getString("ten");
				nhankhau.age_nhankhau = rs.getInt("tuoi");
				nhankhau.gioitinh = rs.getString("gioitinh");
				nhankhau.sdt = rs.getString("sdt");
				nhankhau.diachi = rs.getString("diachi");
				nhankhau.quanheChuho = rs.getString("quanhechuho");
				nhankhau.dantoc = rs.getString("dantoc");
				nhankhau.hokhau = new hokhau_model();
				nhankhau.hokhau.maho = rs.getString("maho");
				screen_view.themNhanKhau_thongke(nhankhau);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void Thongke_theoAge(int age_min, int age_max) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau where tuoi >"+ age_min +" and tuoi < "+age_max;
			ResultSet rs = st.executeQuery(sql);
			nhankhau_model nhankhau =new nhankhau_model();
			while(rs.next()) {
				nhankhau.id_nhankhau = rs.getString("id");
				nhankhau.cmnd = rs.getString("cmnd");
				nhankhau.name_nhankhau = rs.getString("ten");
				nhankhau.age_nhankhau = rs.getInt("tuoi");
				nhankhau.gioitinh = rs.getString("gioitinh");
				nhankhau.sdt = rs.getString("sdt");
				nhankhau.diachi = rs.getString("diachi");
				nhankhau.quanheChuho = rs.getString("quanhechuho");
				nhankhau.dantoc = rs.getString("dantoc");
				nhankhau.hokhau = new hokhau_model();
				nhankhau.hokhau.maho = rs.getString("maho");
				screen_view.themNhankhau_thongkeAge(nhankhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
