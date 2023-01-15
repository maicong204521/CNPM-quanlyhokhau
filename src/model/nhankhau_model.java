package model;

public class nhankhau_model {
	public String cmnd;
	public String name_nhankhau;
	public int age_nhankhau;
	public String gioitinh;
	public String sdt;
	public hokhau_model hokhau;
	public String quanheChuho;
	public String diachi;
	public String dantoc;
	public nhankhau_model(String cmnd, String name_nhankhau, int age_nhankhau, String gioitinh, String sdt,
			hokhau_model hokhau, String quanheChuho, String dantoc,String diachi) {
		super();
		this.cmnd = cmnd;
		this.name_nhankhau = name_nhankhau;
		this.age_nhankhau = age_nhankhau;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.hokhau = hokhau;
		this.quanheChuho = quanheChuho;
		this.dantoc = dantoc;
		this.diachi = diachi;
	}
	public nhankhau_model() {
		
	}
}
