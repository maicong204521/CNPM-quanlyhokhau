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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.TimkiemNhankhau_withId;
import database.themhokhau_db;
import database.themkhoanthu_db;
import database.themnhankhau_db;
import database.themnoptien_db;
import database.thongkeNhankhau;
import database.timkiemdongphi;
import database.timkiemhokhau_withChuho;
import database.timkiemhokhau_withDiachi;
import database.timkiemhokhau_withMaho;
import database.timkiemkhoanthu_withMakhoanthu;
import database.timkiemkhoanthu_withTenkhoanthu;
import database.timkiemnhankhau_withCmnd;
import database.timkiemnhankhau_withHoten;
import database.timkiemnhankhau_withmaho;
import model.hokhau_model;
import model.khoanthu_model;
import model.nhankhau_model;
import model.noptien_model;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JEditorPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JCheckBox;

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
	JScrollPane scrollPane_thongkeNhankhau;
	JScrollPane scrollPane_thongkeAge;
	public static JTable table_nhankhau;
	public static JTable table_hokhau;
	public static JTable table_dongphi;
	public static JTable table_khoanthu;
	public static JTable table_thongkeAge;
	public JRadioButton check_nam, check_nu;
	public 	JPanel panel_thongkeGioitinh ;
	public JPanel panel_thongkedotuoi ;
	public ButtonGroup grp_check ;
	//public static JTable table_thongkenhankhau;
	public int key = 1;
	
	private JTextField textField_idnhankhau;
	public JTextField textField_mahokhau;
	
	private JTextField textField_hotennhankhau;
	private JTextField textField_maho;
	private JTextField textField_cmnd;
	public JTextField textField_makhoanthu;
	public JTextField textField_tenkhoanthu;
	public JTextField textField_mahoNop;
	public JTextField textField_namekhoanthu;
	public JTextField textField_tennguoidong;
	public JTextField textField_diachi;
	public JTextField textField_hotenchuho;
	public JPanel panel_timkiem_nhankhau ;
	public JPanel panel_timkiem_hokhau;
	public JPanel panel_timkiem_khoanthu;
	public JPanel panel_timkiem_noptien;
	public static JTable table_thongkenhankhau;
	private JTextField textField_minAge;
	private JTextField textField_maxAge;
	public screen_view(int a) {
		
	}
	public screen_view() {
		setDefaultCloseOperation(1);
		setBounds(-219, -40, 1201, 779);
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
		panel_chucnang.setBounds(0, 10, 198, 722);
		contentPane.add(panel_chucnang);
		panel_chucnang.setLayout(null);
		
		JPanel panel_trangchu = new JPanel();
		panel_trangchu.setBackground(new Color(0, 255, 0));
		panel_trangchu.setBounds(0, -12, 198, 83);
		panel_chucnang.add(panel_trangchu);
		panel_trangchu.setLayout(null);
		
		JLabel label_trangchu = new JLabel("Trang Chủ");
		label_trangchu.setForeground(new Color(255, 69, 0));
		label_trangchu.setFont(new Font("Arial", Font.BOLD, 28));
		label_trangchu.setBounds(25, 22, 139, 51);
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
		
		JButton btn_suanoptien = new JButton("Sửa tt Nộp Tiền");
		btn_suanoptien.setForeground(new Color(0, 0, 128));
		btn_suanoptien.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_suanoptien.setFocusable(false);
		btn_suanoptien.setBackground(Color.WHITE);
		btn_suanoptien.setBounds(20, 464, 156, 29);
		btn_suanoptien.addActionListener(this);
		panel_chucnang.add(btn_suanoptien);
		
		JLabel lblThngK = new JLabel("5. Thống Kê");
		lblThngK.setFont(new Font("Arial", Font.BOLD, 18));
		lblThngK.setBounds(10, 496, 166, 29);
		panel_chucnang.add(lblThngK);
		
		JButton btn_thongkeDotuoi = new JButton("Theo Độ Tuổi");
		btn_thongkeDotuoi.setForeground(new Color(0, 0, 128));
		btn_thongkeDotuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_thongkeDotuoi.setFocusable(false);
		btn_thongkeDotuoi.setBackground(Color.WHITE);
		btn_thongkeDotuoi.setBounds(20, 524, 156, 29);
		panel_chucnang.add(btn_thongkeDotuoi);
		
		JButton btn_thongkegioitinh = new JButton("Theo Giới Tính");
		btn_thongkegioitinh.setForeground(new Color(0, 0, 128));
		btn_thongkegioitinh.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_thongkegioitinh.setFocusable(false);
		btn_thongkegioitinh.setBackground(Color.WHITE);
		btn_thongkegioitinh.setBounds(20, 563, 156, 29);
		btn_thongkegioitinh.addActionListener(this);
		btn_thongkeDotuoi.addActionListener(this);
		panel_chucnang.add(btn_thongkegioitinh);
		
		panel_timkiem_nhankhau = new JPanel();
		panel_timkiem_nhankhau.setBackground(new Color(204, 255, 204));
		panel_timkiem_nhankhau.setLayout(null);
		panel_timkiem_nhankhau.setBounds(208, 543, 969, 189);
		contentPane.add(panel_timkiem_nhankhau);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nhập ID Nhân Khẩu: ");
		lblNewLabel_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(36, 29, 222, 29);
		panel_timkiem_nhankhau.add(lblNewLabel_1);
		
		textField_idnhankhau = new JTextField();
		textField_idnhankhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_idnhankhau.setBounds(268, 29, 176, 28);
		panel_timkiem_nhankhau.add(textField_idnhankhau);
		textField_idnhankhau.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập Họ Tên: ");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(36, 92, 222, 29);
		lblNewLabel_1_1.setForeground(new Color(0, 102, 255));
		panel_timkiem_nhankhau.add(lblNewLabel_1_1);
		
		textField_hotennhankhau = new JTextField();
		textField_hotennhankhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hotennhankhau.setColumns(10);
		textField_hotennhankhau.setBounds(268, 92, 176, 28);
		panel_timkiem_nhankhau.add(textField_hotennhankhau);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập Mã Hộ Khẩu: ");
		lblNewLabel_1_2.setForeground(new Color(0, 102, 255));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(515, 29, 222, 29);
		panel_timkiem_nhankhau.add(lblNewLabel_1_2);
		
		textField_maho = new JTextField();
		textField_maho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_maho.setColumns(10);
		textField_maho.setBounds(747, 29, 176, 28);
		panel_timkiem_nhankhau.add(textField_maho);
		
		textField_cmnd = new JTextField();
		textField_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_cmnd.setColumns(10);
		textField_cmnd.setBounds(747, 92, 176, 28);
		panel_timkiem_nhankhau.add(textField_cmnd);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nhập Số CMND: ");
		lblNewLabel_1_2_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(515, 92, 222, 29);
		panel_timkiem_nhankhau.add(lblNewLabel_1_2_1);
		
		JButton btn_timkiemnhankhau = new JButton("Tìm Kiếm Nhân Khẩu");
		btn_timkiemnhankhau.setBackground(new Color(255, 255, 204));
		btn_timkiemnhankhau.setForeground(new Color(255, 51, 51));
		btn_timkiemnhankhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timkiemnhankhau.setBounds(380, 143, 222, 36);
		btn_timkiemnhankhau.setFocusable(false);
		btn_timkiemnhankhau.addActionListener(this);
		panel_timkiem_nhankhau.add(btn_timkiemnhankhau);
		
		JButton btn_refresh1 = new JButton("REFRESH");
		btn_refresh1.setForeground(new Color(255, 51, 51));
		btn_refresh1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_refresh1.setFocusable(false);
		btn_refresh1.setBackground(new Color(255, 255, 204));
		btn_refresh1.setBounds(698, 143, 156, 36);
		btn_refresh1.addActionListener(this);
		panel_timkiem_nhankhau.add(btn_refresh1);
		
		
		//**********************panel tim kiem ho khau ******************************//
		panel_timkiem_hokhau = new JPanel();
		panel_timkiem_hokhau.setLayout(null);
		panel_timkiem_hokhau.setBackground(new Color(204, 255, 204));
		panel_timkiem_hokhau.setBounds(208, 543, 969, 189);
		
		
		JLabel label_mahokhau = new JLabel("Nhập Mã Hộ Khẩu: ");
		label_mahokhau.setForeground(new Color(0, 102, 255));
		label_mahokhau.setFont(new Font("Arial", Font.BOLD, 20));
		label_mahokhau.setBounds(36, 29, 222, 29);
		panel_timkiem_hokhau.add(label_mahokhau);
		
		textField_mahokhau = new JTextField();
		textField_mahokhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_mahokhau.setBounds(268, 29, 176, 28);
		panel_timkiem_hokhau.add(textField_mahokhau);
		
		
		JLabel lblNewLabelxx = new JLabel("Nhập Họ Tên Chủ Hộ: ");
		lblNewLabelxx.setForeground(new Color(0, 102, 255));
		lblNewLabelxx.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabelxx.setBounds(36, 92, 222, 29);
		panel_timkiem_hokhau.add(lblNewLabelxx);
		
		textField_hotenchuho = new JTextField();
		textField_hotenchuho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hotenchuho.setColumns(10);
		textField_hotenchuho.setBounds(268, 92, 176, 28);
		panel_timkiem_hokhau.add(textField_hotenchuho);
		
		/////
		JLabel label_diachi = new JLabel("Nhập Địa Chỉ: ");
		label_diachi.setForeground(new Color(0, 102, 255));
		label_diachi.setFont(new Font("Arial", Font.BOLD, 20));
		label_diachi.setBounds(515, 29, 222, 29);
		panel_timkiem_hokhau.add(label_diachi);
		
		textField_diachi = new JTextField();
		textField_diachi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(747, 29, 176, 28);
		panel_timkiem_hokhau.add(textField_diachi);
		////
		
		JButton btn_timkiemhokhau = new JButton("Tìm Kiếm Hộ Khẩu");
		btn_timkiemhokhau.setBackground(new Color(255, 255, 204));
		btn_timkiemhokhau.setForeground(new Color(255, 51, 51));
		btn_timkiemhokhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timkiemhokhau.setBounds(380, 143, 222, 36);
		btn_timkiemhokhau.setFocusable(false);
		btn_timkiemhokhau.addActionListener(this);
		
		JButton btn_refresh2 = new JButton("REFRESH");
		btn_refresh2.setForeground(new Color(255, 51, 51));
		btn_refresh2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_refresh2.setFocusable(false);
		btn_refresh2.setBackground(new Color(255, 255, 204));
		btn_refresh2.setBounds(698, 143, 156, 36);
		btn_refresh2.addActionListener(this);
		panel_timkiem_hokhau.add(btn_refresh2);
		panel_timkiem_hokhau.add(btn_timkiemhokhau);
		
		
		//***************************************************************************//
		//*********************panel tim kiem khoan thu******************************//
		panel_timkiem_khoanthu = new JPanel();
		panel_timkiem_khoanthu.setLayout(null);
		panel_timkiem_khoanthu.setBackground(new Color(204, 255, 204));
		panel_timkiem_khoanthu.setBounds(208, 543, 969, 189);
		
		JLabel label_makhoanthu = new JLabel("Nhập Mã Khoản Thu: ");
		label_makhoanthu.setForeground(new Color(0, 102, 255));
		label_makhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		label_makhoanthu.setBounds(36, 29, 222, 29);
		panel_timkiem_khoanthu.add(label_makhoanthu);
		
		textField_makhoanthu = new JTextField();
		textField_makhoanthu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_makhoanthu.setBounds(268, 29, 176, 28);
		panel_timkiem_khoanthu.add(textField_makhoanthu);
		
		
		JLabel label_tenkhoanthu= new JLabel("Nhập Tên Khoản Thu: ");
		label_tenkhoanthu.setForeground(new Color(0, 102, 255));
		label_tenkhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		label_tenkhoanthu.setBounds(36, 92, 222, 29);
		panel_timkiem_khoanthu.add(label_tenkhoanthu);
		
		textField_tenkhoanthu = new JTextField();
		textField_tenkhoanthu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_tenkhoanthu.setColumns(10);
		textField_tenkhoanthu.setBounds(268, 92, 176, 28);
		panel_timkiem_khoanthu.add(textField_tenkhoanthu);
		//panel_timkiem_khoanthu.add(btn_refresh);
		
		JButton btn_timkiemkhoanthu = new JButton("Tìm Kiếm Khoản Thu");
		btn_timkiemkhoanthu.setBackground(new Color(255, 255, 204));
		btn_timkiemkhoanthu.setForeground(new Color(255, 51, 51));
		btn_timkiemkhoanthu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timkiemkhoanthu.setBounds(380, 143, 222, 36);
		btn_timkiemkhoanthu.setFocusable(false);
		btn_timkiemkhoanthu.addActionListener(this);
		
		JButton btn_refresh3 = new JButton("REFRESH");
		btn_refresh3.setForeground(new Color(255, 51, 51));
		btn_refresh3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_refresh3.setFocusable(false);
		btn_refresh3.setBackground(new Color(255, 255, 204));
		btn_refresh3.setBounds(698, 143, 156, 36);
		btn_refresh3.addActionListener(this);
		panel_timkiem_khoanthu.add(btn_timkiemkhoanthu);
		panel_timkiem_khoanthu.add(btn_refresh3);
		
		//******************************panel tim kiem danh sach nop tien*************************************//
		panel_timkiem_noptien = new JPanel();
		panel_timkiem_noptien.setLayout(null);
		panel_timkiem_noptien.setBackground(new Color(204, 255, 204));
		panel_timkiem_noptien.setBounds(208, 543, 969, 189);
		
		
		JLabel label_mahoNop = new JLabel("Nhập Mã Hộ Khẩu: ");
		label_mahoNop.setForeground(new Color(0, 102, 255));
		label_mahoNop.setFont(new Font("Arial", Font.BOLD, 20));
		label_mahoNop.setBounds(36, 29, 222, 29);
		panel_timkiem_noptien.add(label_mahoNop);
		
		textField_mahoNop = new JTextField();
		textField_mahoNop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_mahoNop.setBounds(268, 29, 176, 28);
		panel_timkiem_noptien.add(textField_mahoNop);
		
		
		JLabel label_namekhoanthu= new JLabel("Nhập Tên Khoản Thu: ");
		label_namekhoanthu.setForeground(new Color(0, 102, 255));
		label_namekhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		label_namekhoanthu.setBounds(36, 92, 222, 29);
		panel_timkiem_noptien.add(label_namekhoanthu);
		
		textField_namekhoanthu = new JTextField();
		textField_namekhoanthu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_namekhoanthu.setColumns(10);
		textField_namekhoanthu.setBounds(268, 92, 176, 28);
		panel_timkiem_noptien.add(textField_namekhoanthu);
		
		JLabel label_tenguoidong = new JLabel("Nhập Tên Người Đóng: ");
		label_tenguoidong.setForeground(new Color(0, 102, 255));
		label_tenguoidong.setFont(new Font("Arial", Font.BOLD, 20));
		label_tenguoidong.setBounds(515, 29, 222, 29);
		panel_timkiem_noptien.add(label_tenguoidong);
		
		textField_tennguoidong = new JTextField();
		textField_tennguoidong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_tennguoidong.setColumns(10);
		textField_tennguoidong.setBounds(747, 29, 176, 28);
		panel_timkiem_noptien.add(textField_tennguoidong);
		
		JButton btn_timkiemnoptien = new JButton("Tìm Kiếm Nộp Tiền");
		btn_timkiemnoptien.setBackground(new Color(255, 255, 204));
		btn_timkiemnoptien.setForeground(new Color(255, 51, 51));
		btn_timkiemnoptien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timkiemnoptien.setBounds(380, 143, 222, 36);
		btn_timkiemnoptien.setFocusable(false);
		btn_timkiemnoptien.addActionListener(this);
		
		JButton btn_refresh4 = new JButton("REFRESH");
		btn_refresh4.setForeground(new Color(255, 51, 51));
		btn_refresh4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_refresh4.setFocusable(false);
		btn_refresh4.setBackground(new Color(255, 255, 204));
		btn_refresh4.setBounds(698, 143, 156, 36);
		btn_refresh4.addActionListener(this);
		panel_timkiem_noptien.add(btn_refresh4);
		panel_timkiem_noptien.add(btn_timkiemnoptien);
		
		//****************************************************************************************************//
		panel_thongtin = new JPanel();
		
		panel_thongtin.setLayout(null);
		panel_thongtin.setBounds(208, 10, 969, 523);
		
		
		//********************table danh sách nhân khẩu***********************//
		
		table_nhankhau = new JTable();
		table_nhankhau.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		//table_nhankhau.setBackground(new Color(255,250,235));
		//table_nhankhau.setForeground(new Color(100,50,150));
		table_nhankhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID","Họ và Tên", "CMND", "Mã Hộ","Tuổi", "Địa Chỉ","Giới Tính", "SĐT", "Quan hệ với chủ hộ"
			}
		));
		
		table_nhankhau.setFont(new Font("arial", Font.PLAIN, 15));
		table_nhankhau.setRowHeight(25);
		scrollPane_dsNhankhau = new JScrollPane(table_nhankhau);
		scrollPane_dsNhankhau.setBounds(0, 27, 969, 496);
		
		//*******************table danh sách hộ khẩu**********************//
		
		table_hokhau = new JTable();
		table_hokhau.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_hokhau.setFont(new Font("arial", Font.PLAIN, 15));
		table_hokhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Mã hộ", "Chủ hộ", "Số thành viên", "Địa chỉ"
			}
		));
		
		table_hokhau.setRowHeight(25);
		scrollPane_dsHoKhau = new JScrollPane(table_hokhau);
		scrollPane_dsHoKhau.setBounds(0, 27, 969, 496);
		
		//*****************table danh sách đóng phí*************************//
		
		table_dongphi = new JTable();
		table_dongphi.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,18));
		table_dongphi.setFont(new Font("arial", Font.PLAIN, 15));
		table_dongphi.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Mã hộ nộp","Tên người nôp", "Tên khoản thu","Số Tiền", "Ngày thu"
				}
			));	
		table_dongphi.setRowHeight(25);
		scrollPane_dsDongphi = new JScrollPane(table_dongphi);
		scrollPane_dsDongphi.setBounds(0, 27, 969, 496);
		
		//*****************table danh sách khoản thu***********************//
		
		table_khoanthu = new JTable();
		table_khoanthu.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,18));
		table_khoanthu.setFont(new Font("arial", Font.PLAIN, 15));
		table_khoanthu.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Mã khoản thu","Loại khoản thu","Tên khoản thu", "số tiên"
				}
			));
		table_khoanthu.setRowHeight(25);
		scrollPane_dsKhoanThu = new JScrollPane(table_khoanthu);
		scrollPane_dsKhoanThu.setBounds(0, 27, 969, 496);
		
		
		
		
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
		
		
		
		//******************** Thong ke ***************************//
		panel_thongkeGioitinh = new JPanel();
		panel_thongkeGioitinh.setBackground(new Color(255, 250, 250));
		panel_thongkeGioitinh.setBounds(208, 10, 969, 523);
		panel_thongkeGioitinh.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Thống Kê Theo Giới Tính");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_2.setBounds(303, 10, 349, 32);
		panel_thongkeGioitinh.add(lblNewLabel_2);
		
		check_nam = new JRadioButton("Nam");
		check_nam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		check_nam.setBounds(171, 61, 93, 33);
		panel_thongkeGioitinh.add(check_nam);
		
		check_nu = new JRadioButton("Nữ");
		check_nu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		check_nu.setBounds(329, 61, 93, 33);
		panel_thongkeGioitinh.add(check_nu);
		
		grp_check = new ButtonGroup();
		grp_check.add(check_nam);
		grp_check.add(check_nu);
		check_nam.setFocusable(false);
		check_nu.setFocusable(false);
		JButton btn_thongke = new JButton("Thống Kê");
		btn_thongke.setBackground(new Color(0, 102, 255));
		btn_thongke.setForeground(new Color(245, 255, 250));
		btn_thongke.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_thongke.setBounds(485, 61, 135, 33);
		btn_thongke.setFocusable(false);
		btn_thongke.addActionListener(this);
		panel_thongkeGioitinh.add(btn_thongke);
		table_thongkenhankhau = new JTable();
		table_thongkenhankhau.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		//table_nhankhau.setBackground(new Color(255,250,235));
		//table_nhankhau.setForeground(new Color(100,50,150));
		table_thongkenhankhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID","Họ và Tên", "CMND", "Mã Hộ","Tuổi", "Địa Chỉ","Giới Tính", "SĐT", "Quan hệ với chủ hộ"
			}
		));
		
		table_thongkenhankhau.setFont(new Font("arial", Font.PLAIN, 15));
		table_thongkenhankhau.setRowHeight(25);
		scrollPane_thongkeNhankhau = new JScrollPane(table_thongkenhankhau);
		scrollPane_thongkeNhankhau.setBounds(0, 135, 969, 388);
		
		panel_thongkeGioitinh.add(scrollPane_thongkeNhankhau);
		
		
		JButton btn_quaylai = new JButton("Quay Lại");
		btn_quaylai.setForeground(new Color(245, 255, 250));
		btn_quaylai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_quaylai.setFocusable(false);
		btn_quaylai.setBackground(new Color(0, 102, 255));
		btn_quaylai.setBounds(684, 61, 135, 33);
		btn_quaylai.addActionListener(this);
		panel_thongkeGioitinh.add(btn_quaylai);
	
		//*********************************************************//
		
		//*************************Thong ke theo do tuoi**********************************//
		panel_thongkedotuoi = new JPanel();
		panel_thongkedotuoi.setBounds(208, 10, 969, 523);
		contentPane.add(panel_thongtin);
		panel_thongkedotuoi.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Thống Kê Theo Độ Tuổi");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_3.setBounds(327, 10, 356, 33);
		panel_thongkedotuoi.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Từ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(119, 65, 48, 33);
		panel_thongkedotuoi.add(lblNewLabel_4);
		
		textField_minAge = new JTextField();
		textField_minAge.setBounds(181, 65, 110, 33);
		panel_thongkedotuoi.add(textField_minAge);
		textField_minAge.setColumns(10);
		
		textField_maxAge = new JTextField();
		textField_maxAge.setColumns(10);
		textField_maxAge.setBounds(412, 65, 110, 33);
		panel_thongkedotuoi.add(textField_maxAge);
		
		JLabel lblNewLabel_4_1 = new JLabel("Đến:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(341, 65, 57, 33);
		panel_thongkedotuoi.add(lblNewLabel_4_1);
		
		JButton btn_thongkedotuoi = new JButton("Thống kê");
		btn_thongkedotuoi.setBackground(new Color(0, 102, 255));
		btn_thongkedotuoi.setForeground(new Color(255, 255, 255));
		btn_thongkedotuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_thongkedotuoi.setBounds(574, 65, 135, 33);
		btn_thongkedotuoi.addActionListener(this);
		btn_thongkedotuoi.setFocusable(false);
		panel_thongkedotuoi.add(btn_thongkedotuoi);
		
		JButton btn_quaylai_fromdotuoi = new JButton("Quay Lại");
		btn_quaylai_fromdotuoi.setBackground(new Color(0, 102, 255));
		btn_quaylai_fromdotuoi.setForeground(new Color(255, 255, 255));
		btn_quaylai_fromdotuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_quaylai_fromdotuoi.setBounds(735, 65, 135, 31);
		btn_quaylai_fromdotuoi.addActionListener(this);
		btn_quaylai_fromdotuoi.setFocusable(false);
		panel_thongkedotuoi.add(btn_quaylai_fromdotuoi);
		panel_thongkedotuoi.setBackground(new Color(255, 250, 250));
		table_thongkeAge = new JTable();
		table_thongkeAge.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		table_thongkeAge.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID","Họ và Tên", "CMND", "Mã Hộ","Tuổi", "Địa Chỉ","Giới Tính", "SĐT", "Quan hệ với chủ hộ"
			}
		));
		
		table_thongkeAge.setFont(new Font("arial", Font.PLAIN, 15));
		table_thongkeAge.setRowHeight(25);
		scrollPane_thongkeAge = new JScrollPane(table_thongkeAge);
		scrollPane_thongkeAge.setBounds(0, 135, 969, 388);
		
		panel_thongkedotuoi.add(scrollPane_thongkeAge);
		//**********************************************************************************//
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
			if(src.equals("Danh Sách Nhân Khẩu")) {
				if(key == 2) {
					panel_thongtin.remove(scrollPane_dsHoKhau);
					contentPane.remove(panel_timkiem_hokhau);
				}
				else if(key == 3) {
					panel_thongtin.remove(scrollPane_dsDongphi);
					contentPane.remove(panel_timkiem_noptien);
				}
				else if(key == 4) {
					panel_thongtin.remove(scrollPane_dsKhoanThu);
					contentPane.remove(panel_timkiem_khoanthu);
				}
				panel_thongtin.add(scrollPane_dsNhankhau);				
				contentPane.add(panel_timkiem_nhankhau);
				contentPane.repaint();
				contentPane.revalidate();
				key =1;
			}
			else if(src.equals("Danh Sách Hộ Khẩu")) {
				
				if(key ==1) {
					System.out.print("remove tim kiem nhan khau\n");
					panel_thongtin.remove(scrollPane_dsNhankhau);	
					contentPane.remove(panel_timkiem_nhankhau);
				}
				else if(key == 3) {
					panel_thongtin.remove(scrollPane_dsDongphi);
					contentPane.remove(panel_timkiem_noptien);
				}
				else if(key == 4) {
					panel_thongtin.remove(scrollPane_dsKhoanThu);
					contentPane.remove(panel_timkiem_khoanthu);
				}
				panel_thongtin.add(scrollPane_dsHoKhau);
				System.out.print("add panel tim kiem ho khau\n");
				contentPane.add(panel_timkiem_hokhau);
				contentPane.repaint();
				contentPane.revalidate();
				key = 2;
			}
			else if(src.equals("Danh Sách Đóng Phí")) {
				
				if(key ==1) {
					panel_thongtin.remove(scrollPane_dsNhankhau);
					contentPane.remove(panel_timkiem_nhankhau);
				}
				if(key == 2) {
					panel_thongtin.remove(scrollPane_dsHoKhau);
					contentPane.remove(panel_timkiem_hokhau);
				}
				else if(key == 4) {
					panel_thongtin.remove(scrollPane_dsKhoanThu);
					contentPane.remove(panel_timkiem_khoanthu);
				}
				panel_thongtin.add(scrollPane_dsDongphi);
				contentPane.add(panel_timkiem_noptien);
				contentPane.repaint();
				contentPane.revalidate();
				key = 3;
			}
			else if(src.equals("Danh Sách Khoản Thu")) {
				
				if(key ==1) {
					panel_thongtin.remove(scrollPane_dsNhankhau);
					contentPane.remove(panel_timkiem_nhankhau);
					
				}
				else if(key == 2) {
					panel_thongtin.remove(scrollPane_dsHoKhau);
					contentPane.remove(panel_timkiem_hokhau);
				}
				else if(key == 3) {
					panel_thongtin.remove(scrollPane_dsDongphi);
					contentPane.remove(panel_timkiem_noptien);
				}
				panel_thongtin.add(scrollPane_dsKhoanThu);
				contentPane.add(panel_timkiem_khoanthu);
				contentPane.repaint();
				contentPane.revalidate();
				key = 4;
			}
			else if(src.equals("Thêm Nhân Khẩu")) {
				new themnhankhau_view();
			}
			else if(src.equals("Sửa Nhân Khẩu")) {
				
				new suanhankhau_view();
			}
			else if(src.equals("Thêm Hộ Khẩu")) {
				System.out.print("them ho khau");
				new themhokhau_view();
			}
			else if(src.equals("Sửa Hộ Khẩu")) {
				new suahokhau_view();
			}
			else if(src.equals("Thêm Khoản Thu")) {
				new themkhoanthu_view();
			}
			else if(src.equals("Sửa Khoản Thu")) {
				new suakhoanthu();
			}
			else if(src.equals("Thêm Nộp Tiền")) {
				
				new themnoptien_view();
			}
			else if(src.equals("Sửa tt Nộp Tiền")) {
				new suaNopTien();
			}
			else if(src.equals("Theo Giới Tính")) {
				contentPane.remove(panel_thongkedotuoi);
				contentPane.remove(panel_thongtin);				
				contentPane.add(panel_thongkeGioitinh);
				contentPane.repaint();
				contentPane.revalidate();
			}
			else if(src.equals("Theo Độ Tuổi")) {
				contentPane.remove(panel_thongkeGioitinh);
				contentPane.remove(panel_thongtin);
				contentPane.add(panel_thongkedotuoi);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
			else if(src.equals("Quay Lại")) {			
				delete_table_thongkenhankhau();
				delete_table_thongkeAge();
				textField_maxAge.setText("");
				textField_minAge.setText("");
				grp_check.clearSelection();
				
				contentPane.remove(panel_thongkeGioitinh);
				contentPane.remove(panel_thongkedotuoi);
				contentPane.add(panel_thongtin);
				contentPane.repaint();
				contentPane.revalidate();
			}
			else if(src.equals("Tìm Kiếm Nhân Khẩu")) {
				if(!textField_idnhankhau.getText().equals("")){
					String idNhankhau = textField_idnhankhau.getText();
					textField_idnhankhau.setText("");
					TimkiemNhankhau_withId.timkiem_nhankhau(idNhankhau);
				}
				else if(!textField_hotennhankhau.getText().equals("")) {
					String hoten = textField_hotennhankhau.getText();
					
					textField_hotennhankhau.setText("");
					timkiemnhankhau_withHoten.timkiem_nhankhau(hoten);					
				}
				else if(!textField_maho.getText().equals("")){
					String maho = textField_maho.getText();
					textField_maho.setText("");
					timkiemnhankhau_withmaho.timkiemnhankhau(maho);
				}
				else if(!textField_cmnd.getText().equals("")) {
					String cmnd = textField_cmnd.getText();
					textField_cmnd.setText("");
					timkiemnhankhau_withCmnd.timkiemnhankhau(cmnd);
				}
				else {
					JOptionPane.showMessageDialog(null,"Vui lòng nhập thông tin");
				}
			}
			else if(src.equals("Tìm Kiếm Hộ Khẩu")) {
				if(!textField_mahokhau.getText().equals("")) {
					String mahokhau = textField_mahokhau.getText();
					textField_mahokhau.setText("");
					timkiemhokhau_withMaho.timkiemhokhau(mahokhau);
				}
				else if(!textField_hotenchuho.getText().equals("")) {
					String tenchuho = textField_hotenchuho.getText();
					textField_hotenchuho.setText("");
					timkiemhokhau_withChuho.timkiemhokhau(tenchuho);
				}
				else if(!textField_diachi.getText().equals("")) {
					String diachi = textField_diachi.getText();
					textField_diachi.setText("");
					timkiemhokhau_withDiachi.timkiemhokhau(diachi);
				}
			}
			else if(src.equals("Tìm Kiếm Khoản Thu")) {
				if(!textField_makhoanthu.getText().equals("")) {
					String makhoanthu = textField_makhoanthu.getText();
					textField_makhoanthu.setText("");
					timkiemkhoanthu_withMakhoanthu.timkiemkhoanthu(makhoanthu);
				}
				else if(!textField_tenkhoanthu.getText().equals("")) {
					String tenkhoanthu = textField_tenkhoanthu.getText();
					textField_tenkhoanthu.setText("");
					timkiemkhoanthu_withTenkhoanthu.timkiemkhoanthu(tenkhoanthu);
				}
			}
			else if(src.equals("Tìm Kiếm Nộp Tiền")) {
				if(!textField_mahoNop.getText().equals("")) {
					String mahonop = textField_mahoNop.getText();
					textField_mahoNop.setText("");
					timkiemdongphi.timkiem_withMahoNop(mahonop);
				}
				else if(!textField_namekhoanthu.getText().equals("")) {
					String tenkhoanthu = textField_namekhoanthu.getText();
					textField_namekhoanthu.setText("");
					timkiemdongphi.timkiem_withTenkhoanthu(tenkhoanthu);
				}
				else if(!textField_tennguoidong.getText().equals("")) {
					String tenNguoidong = textField_tennguoidong.getText();
					textField_tennguoidong.setText("");
					timkiemdongphi.timkiem_withNguoinop(tenNguoidong);
				}
			}
			else if(src.equals("REFRESH")) {
				DefaultTableModel model_table_nhankhau = (DefaultTableModel) table_nhankhau.getModel();
				model_table_nhankhau.setRowCount(0);
				themnhankhau_db.nhankhau_start();
				DefaultTableModel model_table_hokhau = (DefaultTableModel) table_hokhau.getModel();
				model_table_hokhau.setRowCount(0);
				themhokhau_db.hokhau_start();
				DefaultTableModel model_table_khoanthu = (DefaultTableModel) table_khoanthu.getModel();
				model_table_khoanthu.setRowCount(0);
				themkhoanthu_db.khoanthu_start();
				DefaultTableModel model_table_dongphi = (DefaultTableModel) table_dongphi.getModel();
				model_table_dongphi.setRowCount(0);
				themnoptien_db.noptien_start();;
			}
			else if(src.equals("Thống Kê")) {
				if(panel_thongkeGioitinh.isFocusable()) {
					String gioitinh = "";
					if(check_nam.isSelected()) {
					gioitinh = "Nam";
					
					}
					else if(check_nu.isSelected()) {
						gioitinh = "Nu";
					}
					delete_table_thongkenhankhau();
					thongkeNhankhau.Thongke_gioitinh(gioitinh);
				}
				
				
			}
			else if(src.equals("Thống kê")) {
					System.out.print("thong ke theo tuoi");
					int age_min =Integer.parseInt(textField_minAge.getText()) ;
					int age_max = Integer.parseInt(textField_maxAge.getText());
					delete_table_thongkeAge();
					thongkeNhankhau.Thongke_theoAge(age_min, age_max);
				}
			}
		
		public static void themNhanKhau(nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_nhankhau.getModel();
			
			//model_table.addRow(new Object[] {ts.mssv + "",ts.name+"",ts.queQuan.tentinh,ts.ngaysinh,ts.gioitinh,ts.diemmon1 + "",ts.diemmon2 + "",ts.diemmon3+ ""});
			model_table.addRow(new Object[] {nhankhau.id_nhankhau,nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
		}
		public static void themNhanKhau_thongke(nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_thongkenhankhau.getModel();
			
			//model_table.addRow(new Object[] {ts.mssv + "",ts.name+"",ts.queQuan.tentinh,ts.ngaysinh,ts.gioitinh,ts.diemmon1 + "",ts.diemmon2 + "",ts.diemmon3+ ""});
			model_table.addRow(new Object[] {nhankhau.id_nhankhau,nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
		}
		public static void themNhankhau_thongkeAge(nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_thongkeAge.getModel();
			
			//model_table.addRow(new Object[] {ts.mssv + "",ts.name+"",ts.queQuan.tentinh,ts.ngaysinh,ts.gioitinh,ts.diemmon1 + "",ts.diemmon2 + "",ts.diemmon3+ ""});
			model_table.addRow(new Object[] {nhankhau.id_nhankhau,nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
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
		public static void update_table_nhankhau(String idNhankhau, nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_nhankhau.getModel();
			for(int i=0;i<model_table.getRowCount();i++) {
				if(model_table.getValueAt(i, 0)==idNhankhau) {
					model_table.removeRow(i);
					model_table.addRow(new Object[] {nhankhau.id_nhankhau,nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
				}
			}
		}
		public static void update_table_khoanthu(khoanthu_model khoanthu, String idkhoanthu) {
			DefaultTableModel model_table = (DefaultTableModel) table_khoanthu.getModel();
			for(int i=0;i<model_table.getRowCount();i++) {
				
				if(model_table.getValueAt(i, 0)==idkhoanthu) {
					model_table.removeRow(i);
					model_table.addRow(new Object[] {khoanthu.makhoanthu,khoanthu.loaikhoanthu,khoanthu.tenkhoanthu,khoanthu.Sotien+""});
				}
			}
		}
		
		public static void delete_row_khoanthu(String idkhoanthu) {
			DefaultTableModel model_table = (DefaultTableModel)table_khoanthu.getModel();
			for(int i=0;i<model_table.getRowCount();i++) {
				if(model_table.getValueAt(i, 0)==idkhoanthu) {
					model_table.removeRow(i);
					break;
				}
			}
		}
		public static void update_table_hokhau(hokhau_model hokhau, String idHokhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_hokhau.getModel();
			for(int i=0;i<model_table.getRowCount();i++) {
				if(model_table.getValueAt(i, 0)==idHokhau) {
					model_table.removeRow(i);
					model_table.addRow(new Object[] {hokhau.maho,hokhau.chuho,hokhau.Sothanhvien+"",hokhau.diachi});
					
				}
			}
		}
		public static void update_table_noptien(noptien_model noptien, String mahokhau, String tenkhoanthu) {
			DefaultTableModel model_table = (DefaultTableModel) table_dongphi.getModel();
			System.out.print("Mai dinh cong");
			for(int i=0;i<model_table.getRowCount();i++) {
				System.out.print(model_table.getValueAt(i, 2));
				if(model_table.getValueAt(i, 0)== mahokhau && model_table.getValueAt(i, 2)== tenkhoanthu) {
					model_table.removeRow(i);
					
					model_table.addRow(new Object[] {noptien.MaHoKhau,noptien.TenNguoiNop,noptien.TenKhoanThu,noptien.SoTien+"",noptien.NgayThu});
					
				}
			}
		}
		public static void delete_table_nhankhau() {
			DefaultTableModel model_table = (DefaultTableModel) table_nhankhau.getModel();
			model_table.setRowCount(0);
		}
		public static void delete_table_thongkenhankhau() {
			DefaultTableModel model_table = (DefaultTableModel) table_thongkenhankhau.getModel();
			model_table.setRowCount(0);
		}
		public static void delete_table_thongkeAge() {
			DefaultTableModel model_table = (DefaultTableModel) table_thongkeAge.getModel();
			model_table.setRowCount(0);
		}
		public static void showRes_timkiemnhankhau(nhankhau_model nhankhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_nhankhau.getModel();
			//model_table.setRowCount(0);
			model_table.addRow(new Object[] {nhankhau.id_nhankhau,nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
			table_nhankhau.repaint();
			table_nhankhau.revalidate();
			
		}
		public static void delete_table_hokhau() {
			DefaultTableModel model_table = (DefaultTableModel) table_hokhau.getModel();
			model_table.setRowCount(0);
		}
		public static void showRes_timkiemhokhau(hokhau_model hokhau) {
			DefaultTableModel model_table = (DefaultTableModel) table_hokhau.getModel();
			model_table.addRow(new Object[] {hokhau.maho,hokhau.chuho,hokhau.Sothanhvien+"",hokhau.diachi});
			table_hokhau.repaint();
			table_hokhau.revalidate();
		}
		public static void delete_table_khoanthu() {
			DefaultTableModel model_table = (DefaultTableModel) table_khoanthu.getModel();
			model_table.setRowCount(0);
		}
		public static void showRes_timkiemkhoanthu(khoanthu_model khoanthu) {
			DefaultTableModel model_table = (DefaultTableModel) table_khoanthu.getModel();
			model_table.addRow(new Object[] {khoanthu.makhoanthu,khoanthu.loaikhoanthu,khoanthu.tenkhoanthu,khoanthu.Sotien+""});
			table_khoanthu.repaint();
			table_khoanthu.revalidate();
		}
		public static void delete_table_dongphi() {
			DefaultTableModel model_table = (DefaultTableModel) table_dongphi.getModel();
			model_table.setRowCount(0);
		}
		public static void showRes_timkiemNoptien(noptien_model noptien) {
			DefaultTableModel model_table = (DefaultTableModel) table_dongphi.getModel();
			model_table.addRow(new Object[] {noptien.MaHoKhau,noptien.TenNguoiNop,noptien.TenKhoanThu,noptien.SoTien+"",noptien.NgayThu});
			table_dongphi.repaint();
			table_dongphi.revalidate();
		}
}
