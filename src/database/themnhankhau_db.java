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
	public static int themnhankhau(String id,String cmnd,String name_nhankhau,int age_nhankhau,String gioitinh,String sdt,String quanheChuho, String diachi,String dantoc,String maho) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "insert into nhankhau (id,Cmnd, ten, tuoi, gioitinh,sdt,quanhechuho,diachi,dantoc,maho)"
	                + "values('"+ id +"','" + cmnd + "','" + name_nhankhau + "','" + age_nhankhau + "','" + gioitinh + "','"+sdt+"','"+quanheChuho+"','"+diachi+"','"+dantoc+"','"+ maho + "')";
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
		return 1;
	}
	public static void nhankhau_start() {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "select * from nhankhau";
			ResultSet rs= st.executeQuery(sql);
			nhankhau_model nhankhau = new nhankhau_model();
			//quanlyAll = new quanly_model();
			
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
				quanly_model.dsNhankhau.add(nhankhau);
				quanly_model.dsIdNhankhau.add(nhankhau.id_nhankhau);
				screen_view.themNhanKhau(nhankhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int update_nhankhau(nhankhau_model nhankhau,String idnhankhau) {
		try {
			java.sql.Statement st = connec.createStatement();
			String sql = "update nhankhau "
					+ "set id = "+"'"+nhankhau.id_nhankhau+"'"+", Cmnd = "+"'"+ nhankhau.cmnd +"'"+", ten = "+"'"+nhankhau.name_nhankhau+"'"+", tuoi = "+nhankhau.age_nhankhau+", gioitinh = "+"'"+nhankhau.gioitinh+"'"+", sdt = "+"'"+nhankhau.sdt+"'"+", quanhechuho = "+"'"+nhankhau.quanheChuho+"'"+", diachi = "+"'"+nhankhau.diachi+"'"+", dantoc = "+"'"+nhankhau.dantoc+"'"+", maho = "+"'"+nhankhau.hokhau.maho
					+"'"+" where id = "+"'"+idnhankhau+"'";
			try {
				st.executeUpdate(sql);
				return 1;
			} catch (Exception e) {
				// TODO: handle exception
				return 0;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
