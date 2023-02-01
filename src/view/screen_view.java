package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.themhokhau_db;
import database.themkhoanthu_db;
import database.themnhankhau_db;
import database.themnoptien_db;
import model.hokhau_model;
import model.khoanthu_model;
import model.nhankhau_model;
import model.noptien_model;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JEditorPane;

public class screen_view extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	
	JButton btn_dsHoKhau;
	JButton btn_dsNhanKhau;
	JButton btn_dskhoanthu;
	JPanel panel_thongtin;
	JScrollPane scrollPane_dsNhankhau;
	JScrollPane scrollPane_dsHoKhau;
	JScrollPane scrollPane_dsDongphi;
	JScrollPane scrollPane_dsKhoanThu;
	public static JTable table_nhankhau;
	public static JTable table_hokhau;
	public static JTable table_dongphi;
	public static JTable table_khoanthu;
	public screen_view(int a) {
		
	}
	public screen_view() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 1201, 779);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setBackground(new Color(173, 255, 47));
		panel_chucnang.setBounds(0, 20, 198, 712);
		contentPane.add(panel_chucnang);
		panel_chucnang.setLayout(null);
		
		JPanel panel_trangchu = new JPanel();
		panel_trangchu.setBackground(new Color(0, 255, 0));
		panel_trangchu.setBounds(0, 0, 198, 71);
		panel_chucnang.add(panel_trangchu);
		panel_trangchu.setLayout(null);
		
		JLabel label_trangchu = new JLabel("Trang Chủ");
		label_trangchu.setForeground(new Color(255, 69, 0));
		label_trangchu.setFont(new Font("Arial", Font.BOLD, 28));
		label_trangchu.setBounds(27, 10, 139, 51);
		panel_trangchu.add(label_trangchu);
		
		JLabel label_nhankhau = new JLabel("1. Nhân Khẩu");
		label_nhankhau.setFont(new Font("Arial", Font.BOLD, 18));
		label_nhankhau.setBounds(10, 81, 166, 29);
		panel_chucnang.add(label_nhankhau);
		
		JButton btn_themnhankhau = new JButton("Thêm Nhân Khẩu");
		btn_themnhankhau.setForeground(new Color(0, 0, 128));
		btn_themnhankhau.setBackground(new Color(255, 255, 255));
		btn_themnhankhau.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_themnhankhau.setBounds(20, 109, 156, 29);
		btn_themnhankhau.setFocusable(false);
		btn_themnhankhau.addActionListener(this);
		panel_chucnang.add(btn_themnhankhau);
		
		JButton btn_suanhankhau = new JButton("Sửa Nhân Khẩu");
		btn_suanhankhau.setForeground(new Color(0, 0, 128));
		btn_suanhankhau.setBackground(new Color(255, 255, 255));
		btn_suanhankhau.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_suanhankhau.setBounds(20, 148, 156, 29);
		btn_suanhankhau.setFocusable(false);
		btn_suanhankhau.addActionListener(this);
		panel_chucnang.add(btn_suanhankhau);
		
		JLabel label_hokhau = new JLabel("2. Hộ Khẩu");
		label_hokhau.setFont(new Font("Arial", Font.BOLD, 18));
		label_hokhau.setBounds(10, 187, 166, 29);
		panel_chucnang.add(label_hokhau);
		
		JButton btn_themhokhau = new JButton("Thêm Hộ Khẩu");
		btn_themhokhau.setForeground(new Color(0, 0, 128));
		btn_themhokhau.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_themhokhau.setFocusable(false);
		btn_themhokhau.setBackground(Color.WHITE);
		btn_themhokhau.setBounds(20, 215, 156, 29);
		btn_themhokhau.addActionListener(this);
		panel_chucnang.add(btn_themhokhau);
		
		JButton btn_suahokhau = new JButton("Sửa Hộ Khẩu");
		btn_suahokhau.setForeground(new Color(0, 0, 128));
		btn_suahokhau.setBackground(new Color(255, 255, 255));
		btn_suahokhau.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_suahokhau.setFocusable(false);
		btn_suahokhau.setBounds(20, 254, 156, 29);
		btn_suahokhau.addActionListener(this);
		panel_chucnang.add(btn_suahokhau);
		
		JLabel label_nhankhau_1 = new JLabel("3. Khoản Thu");
		label_nhankhau_1.setFont(new Font("Arial", Font.BOLD, 18));
		label_nhankhau_1.setBounds(10, 292, 166, 29);
		panel_chucnang.add(label_nhankhau_1);
		
		JButton btn_themkhoanthu = new JButton("Thêm Khoản Thu");
		btn_themkhoanthu.setForeground(new Color(0, 0, 128));
		btn_themkhoanthu.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_themkhoanthu.setFocusable(false);
		btn_themkhoanthu.setBackground(Color.WHITE);
		btn_themkhoanthu.setBounds(20, 320, 156, 29);
		btn_themkhoanthu.addActionListener(this);
		panel_chucnang.add(btn_themkhoanthu);
		
		JButton btn_suakhoanthu = new JButton("Sửa Khoản Thu");
		btn_suakhoanthu.setForeground(new Color(0, 0, 128));
		btn_suakhoanthu.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_suakhoanthu.setFocusable(false);
		btn_suakhoanthu.setBackground(Color.WHITE);
		btn_suakhoanthu.setBounds(20, 359, 156, 29);
		btn_suakhoanthu.addActionListener(this);
		panel_chucnang.add(btn_suakhoanthu);
		
		JLabel label_nhankhau_2 = new JLabel("4. Đóng Phí");
		label_nhankhau_2.setFont(new Font("Arial", Font.BOLD, 18));
		label_nhankhau_2.setBounds(10, 397, 166, 29);
		panel_chucnang.add(label_nhankhau_2);
		
		JButton btn_themnoptien = new JButton("Thêm Nộp Tiền");
		btn_themnoptien.setForeground(new Color(0, 0, 128));
		btn_themnoptien.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_themnoptien.setFocusable(false);
		btn_themnoptien.setBackground(Color.WHITE);
		btn_themnoptien.setBounds(20, 425, 156, 29);
		btn_themnoptien.addActionListener(this);
		panel_chucnang.add(btn_themnoptien);
		
		JButton btn_xoanoptien = new JButton("Xóa Nộp Tiền");
		btn_xoanoptien.setForeground(new Color(0, 0, 128));
		btn_xoanoptien.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_xoanoptien.setFocusable(false);
		btn_xoanoptien.setBackground(Color.WHITE);
		btn_xoanoptien.setBounds(20, 464, 156, 29);
		btn_xoanoptien.addActionListener(this);
		panel_chucnang.add(btn_xoanoptien);
		
		JPanel panel_timkiem = new JPanel();
		panel_timkiem.setBounds(208, 569, 951, 163);
		contentPane.add(panel_timkiem);
		panel_timkiem.setLayout(null);
		
		panel_thongtin = new JPanel();
		panel_thongtin.setLayout(null);
		panel_thongtin.setBounds(208, 20, 951, 539);
		contentPane.add(panel_thongtin);
		
		//********************table danh sách nhân khẩu***********************//
		
		table_nhankhau = new JTable();
		table_nhankhau.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_nhankhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Họ và Tên", "CMND", "Mã Hộ","Tuổi", "Địa Chỉ","Giới Tính", "SĐT", "Quan hệ với chủ hộ"
			}
		));
		
		
		scrollPane_dsNhankhau = new JScrollPane(table_nhankhau);
		scrollPane_dsNhankhau.setBounds(0, 31, 951, 508);
		
		//*******************table danh sách hộ khẩu**********************//
		
		table_hokhau = new JTable();
		table_hokhau.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_hokhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Mã hộ", "Chủ hộ", "Số thành viên", "Địa chỉ"
			}
		));
		
		
		scrollPane_dsHoKhau = new JScrollPane(table_hokhau);
		scrollPane_dsHoKhau.setBounds(0, 31, 951, 508);
		
		//*****************table danh sách đóng phí*************************//
		
		table_dongphi = new JTable();
		table_dongphi.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,14));
		table_dongphi.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Mã hộ nộp","Tên người nôp", "Tên khoản thu","Số Tiền", "Ngày thu"
				}
			));		
		scrollPane_dsDongphi = new JScrollPane(table_dongphi);
		scrollPane_dsDongphi.setBounds(0, 31, 951, 508);
		
		//*****************table danh sách khoản thu***********************//
		
		table_khoanthu = new JTable();
		table_khoanthu.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,14));
		table_khoanthu.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Mã khoản thu","Loại khoản thu","Tên khoản thu", "số tiên"
				}
			));
		scrollPane_dsKhoanThu = new JScrollPane(table_khoanthu);
		scrollPane_dsKhoanThu.setBounds(0, 31, 951, 508);
		
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 570, 26);
		panel_thongtin.add(toolBar);
		
		btn_dsNhanKhau = new JButton("Danh Sách Nhân Khẩu");
		toolBar.add(btn_dsNhanKhau);
		btn_dsNhanKhau.setBackground(new Color(255, 255, 240));
		btn_dsNhanKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btn_dsNhanKhau.setFocusable(false);
		
		btn_dsHoKhau = new JButton("Danh Sách Hộ Khẩu");
		toolBar.add(btn_dsHoKhau);
		btn_dsHoKhau.setBackground(new Color(255, 255, 240));
		btn_dsHoKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_dsHoKhau.setFocusable(false);
		btn_dskhoanthu = new JButton("Danh Sách Khoản Thu");
		toolBar.add(btn_dskhoanthu);
		btn_dskhoanthu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_dskhoanthu.setFocusable(false);
		btn_dskhoanthu.setBackground(new Color(255, 255, 240));
		
		JButton btn_dsDongPhi = new JButton("Danh Sách Đóng Phí");
		toolBar.add(btn_dsDongPhi);
		btn_dsDongPhi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_dsDongPhi.setFocusable(false);
		btn_dsDongPhi.setBackground(new Color(255, 255, 240));
		btn_dskhoanthu.addActionListener(this);
		btn_dsHoKhau.addActionListener(this);
		btn_dsNhanKhau.addActionListener(this);
		btn_dsDongPhi.addActionListener(this);		
		JLabel lblNewLabel = new JLabel("Trang chủ");
		contentPane.add(lblNewLabel);
		lblNewLabel.setBounds(0, 20, 198, 71);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		themhokhau_db.hokhau_start();
		themkhoanthu_db.khoanthu_start();
		themnoptien_db.noptien_start();
		themnhankhau_db.nhankhau_start();
		panel_thongtin.add(scrollPane_dsNhankhau);
		this.setTitle("Phần mềm quản lý hộ khẩu, nhân khẩu");		
		this.setVisible(true);
		
	}
	public void setView() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		System.out.print(src);
			if(src.equals("Danh Sách Nhân Khẩu")) {
				panel_thongtin.add(scrollPane_dsNhankhau);
			}
			else if(src.equals("Danh Sách Hộ Khẩu")) {
				panel_thongtin.add(scrollPane_dsHoKhau);
				
			}
			else if(src.equals("Danh Sách Đóng Phí")) {
				panel_thongtin.add(scrollPane_dsDongphi);
			}
			else if(src.equals("Danh Sách Khoản Thu")) {
				panel_thongtin.add(scrollPane_dsKhoanThu);
			}
			else if(src.equals("Thêm Nhân Khẩu")) {
				new themnhankhau_view();
			}
			else if(src.equals("Sửa Nhân Khẩu")) {
				
			}
			else if(src.equals("Thêm Hộ Khẩu")) {
				new themhokhau_view();
			}
			else if(src.equals("Sửa Hộ Khẩu")) {
				
			}
			else if(src.equals("Thêm Khoản Thu")) {
				new themkhoanthu_view();
			}
			else if(src.equals("Sửa Khoản Thu")) {
				
			}
			else if(src.equals("Thêm Nộp Tiền")) {
				
				new themnoptien_view();
			}
			else if(src.equals("Xóa Nộp Tiền")) {
				
			}
	}
		
		public static void themNhanKhau(nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_nhankhau.getModel();
			
			//model_table.addRow(new Object[] {ts.mssv + "",ts.name+"",ts.queQuan.tentinh,ts.ngaysinh,ts.gioitinh,ts.diemmon1 + "",ts.diemmon2 + "",ts.diemmon3+ ""});
			model_table.addRow(new Object[] {nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
		}
		public static void themHoKhau(hokhau_model hokhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_hokhau.getModel();
			model_table.addRow(new Object[] {hokhau.maho,hokhau.chuho,hokhau.Sothanhvien+"",hokhau.diachi});
		}
		public static void themKhoanThu(khoanthu_model khoanthu) {
			DefaultTableModel model_table = (DefaultTableModel) table_khoanthu.getModel();
			model_table.addRow(new Object[] {khoanthu.makhoanthu,khoanthu.loaikhoanthu,khoanthu.tenkhoanthu,khoanthu.Sotien+""});
		}
		public static void themNopTien(noptien_model noptien) {
			DefaultTableModel model_table = (DefaultTableModel) table_dongphi.getModel();
			model_table.addRow(new Object[] {noptien.MaHoKhau,noptien.TenNguoiNop,noptien.TenKhoanThu,noptien.SoTien+"",noptien.NgayThu});
		}
}
