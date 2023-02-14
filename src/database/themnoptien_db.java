package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import model.noptien_model;
import model.quanly_model;
import view.screen_view;

public class themnoptien_db {
	public static Connection connec = jdbc.getconConnection();
	//public static quanly_model quanlyAll;
	public static int themnoptien(String tennguoinop, String mahokhau,String tenkhoanthu,String ngaythu, int sotien) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into noptien (tennguoinop, mahokhau, tenkhoanthu, ngaythu,sotien)"
	                + "values('" + tennguoinop + "','" + mahokhau + "','" + tenkhoanthu + "','" + ngaythu + "','" + sotien + "')";
			//System.out.print("you pass database");
			
			try {
				int check = st.executeUpdate(sql);
				return 1;
			} catch (Exception e) {
				// TODO: handle exception
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void noptien_start() {
		try {
			java.sql.Statement st = connec.createStatement();
			noptien_model noptien = new noptien_model();
			String sql = "select * from noptien";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				noptien.TenNguoiNop = rs.getString("tennguoinop");
				noptien.MaHoKhau = rs.getString("mahokhau");
				noptien.TenKhoanThu = rs.getString("tenkhoanthu");
				noptien.NgayThu = rs.getString("ngaythu");
				noptien.SoTien = rs.getInt("sotien");
				quanly_model.dsNopTien.add(noptien);
				screen_view.themNopTien(noptien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update_noptien(noptien_model noptien, String mahokhau, String tenkhoanthu) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "update noptien "
					+ "set tennguoinop = "+"'"+noptien.TenNguoiNop+"'"+", mahokhau = "+"'"+ noptien.MaHoKhau +"'"+", tenkhoanthu = "+"'"+noptien.TenKhoanThu+"'"+", ngaythu = '"+noptien.NgayThu+"'"+", Sotien = "+noptien.SoTien
					+" where mahokhau = "+"'"+mahokhau+"' and tenkhoanthu = '"+tenkhoanthu+"'";
			int check;
			check = st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
