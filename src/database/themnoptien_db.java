package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import model.noptien_model;
import model.quanly_model;
import view.screen_view;

public class themnoptien_db {
	public static Connection connec = jdbc.getconConnection();
	//public static quanly_model quanlyAll;
	public static void themnoptien(String tennguoinop, String mahokhau,String tenkhoanthu,String ngaythu, int sotien) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into noptien (tennguoinop, mahokhau, tenkhoanthu, ngaythu,sotien)"
	                + "values('" + tennguoinop + "','" + mahokhau + "','" + tenkhoanthu + "','" + ngaythu + "','" + sotien + "')";
			//System.out.print("you pass database");
			int check = st.executeUpdate(sql);
			if(check>0) {
				System.out.print("success in database");
			}
			else {
				System.out.print("fail in database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
