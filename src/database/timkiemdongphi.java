package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.noptien_model;
import view.screen_view;

public class timkiemdongphi {
	public static Connection connec = jdbc.getconConnection();
	
	
	public static void timkiem_withMahoNop(String maho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from noptien where mahokhau = '"+maho+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_dongphi();
			int check = 0;
			while(rs.next()) {
				noptien_model noptien = new noptien_model();
				noptien.MaHoKhau = rs.getString("mahokhau");
				noptien.TenNguoiNop = rs.getString("tennguoinop");
				noptien.TenKhoanThu = rs.getString("tenkhoanthu");
				noptien.SoTien = Integer.parseInt(rs.getString("Sotien"));
				noptien.NgayThu = rs.getString("ngaythu");
				check = check +1;
				screen_view.showRes_timkiemNoptien(noptien);
			}
			if(check ==0) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy thông tin đóng phí!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void timkiem_withTenkhoanthu(String tenkhoanthu) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from noptien where tenkhoanthu = '"+tenkhoanthu+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_dongphi();
			int check = 0;
			while(rs.next()) {
				noptien_model noptien = new noptien_model();
				noptien.MaHoKhau = rs.getString("mahokhau");
				noptien.TenNguoiNop = rs.getString("tennguoinop");
				noptien.TenKhoanThu = rs.getString("tenkhoanthu");
				noptien.SoTien = Integer.parseInt(rs.getString("Sotien"));
				noptien.NgayThu = rs.getString("ngaythu");
				check = check +1;
				screen_view.showRes_timkiemNoptien(noptien);
			}
			if(check ==0) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy thông tin đóng phí!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void timkiem_withNguoinop(String tenNguoinop) {
		try {
			
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from noptien where tennguoinop = '"+tenNguoinop+"'";
			ResultSet rs = st.executeQuery(sql);
			screen_view.delete_table_dongphi();
			int check = 0;
			while(rs.next()) {
				noptien_model noptien = new noptien_model();
				noptien.MaHoKhau = rs.getString("mahokhau");
				noptien.TenNguoiNop = rs.getString("tennguoinop");
				noptien.TenKhoanThu = rs.getString("tenkhoanthu");
				noptien.SoTien = Integer.parseInt(rs.getString("Sotien"));
				noptien.NgayThu = rs.getString("ngaythu");
				check = check +1;
				screen_view.showRes_timkiemNoptien(noptien);
			}
			if(check ==0) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy thông tin đóng phí!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
