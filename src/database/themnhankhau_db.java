package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import model.hokhau_model;
import model.nhankhau_model;
import model.quanly_model;
import view.screen_view;

public class themnhankhau_db {
	public static Connection connec = jdbc.getconConnection();
	//public static quanly_model quanlyAll;
	public static void themnhankhau(String cmnd,String name_nhankhau,int age_nhankhau,String gioitinh,String sdt,String quanheChuho, String diachi,String dantoc,String maho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into nhankhau (cmnd, ten, tuoi, gioitinh,sdt,quanhechuho,diachi,dantoc,maho)"
	                + "values('" + cmnd + "','" + name_nhankhau + "','" + age_nhankhau + "','" + gioitinh + "','"+sdt+"','"+quanheChuho+"','"+diachi+"','"+dantoc+"','"+ maho + "')";
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
	public static void nhankhau_start() {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau";
			ResultSet rs= st.executeQuery(sql);
			nhankhau_model nhankhau = new nhankhau_model();
			//quanlyAll = new quanly_model();
			while(rs.next()) {
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
				quanly_model.dsNhankhau.add(nhankhau);
				screen_view.themNhanKhau(nhankhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
