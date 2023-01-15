package model;

import java.util.ArrayList;

public class quanly_model {
	public static ArrayList<nhankhau_model> dsNhankhau;
	public static ArrayList<hokhau_model> dsHoKhau;
	public static ArrayList<khoanthu_model> dsKhoanThu;
	public quanly_model() {
		dsNhankhau = new ArrayList<nhankhau_model>();
		dsHoKhau = new ArrayList<hokhau_model>();
		dsKhoanThu = new ArrayList<khoanthu_model>();
	}
}
