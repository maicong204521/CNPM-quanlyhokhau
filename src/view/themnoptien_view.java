package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.themnoptien_db;
import model.hokhau_model;
import model.noptien_model;
import model.quanly_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class themnoptien_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_tenNguoiNop;
	private JTextField textField_tenKhoanThu;
	private JTextField textField_SoTien;
	private JTextField textField_ngayThu;
	public static JComboBox comboBox_mahokhau;
	public noptien_model noptien;
	public themnoptien_view() {
		
		try {
			setDefaultCloseOperation(1);
			setBounds(100, 100, 694, 564);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 250, 240));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.setLocationRelativeTo(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("QUẢN LÝ ĐÓNG PHÍ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setBounds(192, 10, 329, 59);
			contentPane.add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel("Mã Hộ Khẩu:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(54, 80, 170, 34);
			contentPane.add(lblNewLabel_1);
		
			comboBox_mahokhau = new JComboBox();
			comboBox_mahokhau.setBounds(234, 79, 209, 35);
			comboBox_mahokhau.addItem("");
			System.out.print("----------------------------");
			for(String i : quanly_model.dsMaHo) {
			comboBox_mahokhau.addItem(i);
			}
			contentPane.add(comboBox_mahokhau);
			
			JLabel lblNewLabel_1_1 = new JLabel("Tên Người Nộp:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(54, 156, 170, 34);
			contentPane.add(lblNewLabel_1_1);
			
			textField_tenNguoiNop = new JTextField();
			textField_tenNguoiNop.setBounds(234, 156, 209, 34);
			contentPane.add(textField_tenNguoiNop);
			textField_tenNguoiNop.setColumns(10);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Tên Khoản Thu");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(54, 230, 170, 34);
			contentPane.add(lblNewLabel_1_1_1);
			
			textField_tenKhoanThu = new JTextField();
			textField_tenKhoanThu.setColumns(10);
			textField_tenKhoanThu.setBounds(234, 230, 209, 34);
			contentPane.add(textField_tenKhoanThu);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Số Tiền:");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_1_1_1.setBounds(54, 309, 170, 34);
			contentPane.add(lblNewLabel_1_1_1_1);
			
			textField_SoTien = new JTextField();
			textField_SoTien.setColumns(10);
			textField_SoTien.setBounds(234, 309, 209, 34);
			contentPane.add(textField_SoTien);
			
			JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày Thu:");
			lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_1_1_1_1.setBounds(54, 390, 170, 34);
			contentPane.add(lblNewLabel_1_1_1_1_1);
			
			textField_ngayThu = new JTextField();
			textField_ngayThu.setColumns(10);
			textField_ngayThu.setBounds(234, 390, 209, 34);
			contentPane.add(textField_ngayThu);
			
			JButton btn_Save = new JButton("SAVE");
			btn_Save.setBackground(new Color(152, 251, 152));
			btn_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Save.setBounds(358, 461, 110, 40);
			btn_Save.addActionListener(this);
			contentPane.add(btn_Save);
			
			JButton btn_reset = new JButton("RESET");
			btn_reset.setBackground(new Color(152, 251, 152));
			btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_reset.setBounds(507, 461, 110, 40);
			contentPane.add(btn_reset);
			btn_reset.addActionListener(this);
			this.setTitle("Thêm hộ nộp");
			
			this.setVisible(true);
		} 
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "vui long nhap ho khau truoc");			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "RESET") {
			this.setnull();
		}
		if(src == "SAVE") {
			noptien = new noptien_model();
			noptien.MaHoKhau = comboBox_mahokhau.getSelectedItem().toString();
			noptien.SoTien =Integer.parseInt(textField_SoTien.getText()) ;
			noptien.NgayThu = textField_ngayThu.getText();
			noptien.TenKhoanThu = textField_tenKhoanThu.getText();
			noptien.TenNguoiNop = textField_tenNguoiNop.getText();
			screen_view.themNopTien(noptien);
			for(String i : quanly_model.dsMaHo) {
				comboBox_mahokhau.addItem(i);
				}
			themnoptien_db.themnoptien(noptien.TenNguoiNop, noptien.MaHoKhau, noptien.TenKhoanThu, noptien.NgayThu, noptien.SoTien);
			JOptionPane.showMessageDialog(null, "Insert success!");
		}
	}
	public void setnull() {
		textField_ngayThu.setText("");
		textField_SoTien.setText("");
		textField_tenKhoanThu.setText("");
		textField_tenNguoiNop.setText("");
		comboBox_mahokhau.setSelectedIndex(0);
	}
	
}
