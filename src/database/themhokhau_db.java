package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import model.hokhau_model;
import model.quanly_model;
import view.screen_view;

public class themhokhau_db {
	public static  Connection connec= jdbc.getconConnection();
	public static hokhau_model hokhau;
	public static quanly_model quanlyAll;
	public static void themhokhau(String chuho, String diachi, String maho,int sothanhvien) {
		
		try {
			
//			if(connec!=null) {
//				System.out.print("link success");
//			}else {
//				System.out.print("link failure");
//			}
			
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into hokhau (chuho, diachi, maho, sothanhvien)"
	                + "values('" + chuho + "','" + diachi + "','" + maho + "','" + sothanhvien + "')";
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
	public static void hokhau_start() {
		try {
			quanlyAll = new quanly_model();
			hokhau = new hokhau_model();
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from hokhau";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				hokhau.chuho = rs.getString("chuho");			
				hokhau.diachi = rs.getString("diachi");
				hokhau.maho = rs.getString("maho");
				hokhau.Sothanhvien = rs.getInt("sothanhvien");				
				quanly_model.dsMaHo.add(hokhau.maho);		
				screen_view.themHoKhau(hokhau);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update_hokhau(hokhau_model hokhau, String idHokhau) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "update hokhau "
					+ "set chuho = "+"'"+hokhau.chuho+"'"+", diachi = "+"'"+ hokhau.diachi +"'"+", maho = "+"'"+hokhau.maho+"'"+", sothanhvien = "+hokhau.Sothanhvien
					+" where maho = "+"'"+idHokhau+"'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
