package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import model.khoanthu_model;
import model.quanly_model;
import view.screen_view;

public class themkhoanthu_db {
	public static Connection connec = jdbc.getconConnection();
	//public static quanly_model quanlyAll;
	public static void themkhoanthu(String makhoanthu, String tenkhoanthu,String loaikhoanthu,int Sotien) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into khoanthu (tenkhoanthu, makhoanthu, loaikhoanthu, Sotien)"
	                + "values('" + makhoanthu + "','" + tenkhoanthu + "','" + loaikhoanthu + "','" + Sotien + "')";
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
	public static void khoanthu_start() {
		try {
			//quanlyAll = new quanly_model();
			java.sql.Statement st = connec.createStatement();
			khoanthu_model khoanthu = new khoanthu_model();
			String sql = "select * from khoanthu";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				khoanthu.tenkhoanthu = rs.getString("tenkhoanthu");
				khoanthu.makhoanthu = rs.getString("makhoanthu");
				khoanthu.loaikhoanthu = rs.getString("loaikhoanthu");
				khoanthu.Sotien = rs.getInt("Sotien");
				quanly_model.dsKhoanThu.add(khoanthu);
				quanly_model.dsMakhoanthu.add(khoanthu.makhoanthu);
				screen_view.themKhoanThu(khoanthu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update_khoanthu(khoanthu_model khoanthu, String makhoanthu) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "update khoanthu "
					+ "set tenkhoanthu = "+"'"+khoanthu.tenkhoanthu+"'"+", makhoanthu = "+"'"+ khoanthu.makhoanthu +"'"+", loaikhoanthu = "+"'"+khoanthu.loaikhoanthu+"'"+", Sotien = "+khoanthu.Sotien
					+" where makhoanthu = "+"'"+makhoanthu+"'";
			int check = st.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void delete_row_khoanthu(String makhoanthu) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "DELETE FROM khoanthu where makhoanthu = '"+makhoanthu +"'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
