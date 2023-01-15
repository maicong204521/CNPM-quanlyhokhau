package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.hokhau_model;
import model.quanly_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class themhokhau_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_maho;
	private JTextField textField_tenchuho;
	private JTextField textField_sothanhvien;
	private JTextField textField_diachi;
	public hokhau_model hokhau;
	public quanly_model quanlyAll;
	public themhokhau_view() {
		quanlyAll = new quanly_model();
		setDefaultCloseOperation(1);
		setBounds(100, 100, 793, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		this.setTitle("Thêm hộ khẩu");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ HỘ KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(234, 41, 277, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Hộ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(97, 156, 106, 41);
		contentPane.add(lblNewLabel_1);
		
		textField_maho = new JTextField();
		textField_maho.setBounds(250, 156, 261, 36);
		contentPane.add(textField_maho);
		textField_maho.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chủ hộ:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(97, 250, 143, 41);
		contentPane.add(lblNewLabel_1_1);
		
		textField_tenchuho = new JTextField();
		textField_tenchuho.setColumns(10);
		textField_tenchuho.setBounds(250, 250, 261, 36);
		contentPane.add(textField_tenchuho);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số thành viên: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(97, 335, 143, 41);
		contentPane.add(lblNewLabel_1_2);
		
		textField_sothanhvien = new JTextField();
		textField_sothanhvien.setColumns(10);
		textField_sothanhvien.setBounds(250, 335, 261, 36);
		contentPane.add(textField_sothanhvien);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(97, 431, 143, 41);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(250, 431, 261, 36);
		contentPane.add(textField_diachi);
		
		JButton btn_themhokhau_save = new JButton("SAVE");
		btn_themhokhau_save.setBackground(new Color(204, 255, 255));
		btn_themhokhau_save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themhokhau_save.setBounds(345, 545, 134, 41);
		btn_themhokhau_save.addActionListener(this);
		contentPane.add(btn_themhokhau_save);
		
		JButton btn_themhokhau_reset = new JButton("RESET");
		btn_themhokhau_reset.setBackground(new Color(204, 255, 255));
		btn_themhokhau_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themhokhau_reset.setBounds(538, 545, 134, 41);
		btn_themhokhau_reset.addActionListener(this);
		contentPane.add(btn_themhokhau_reset);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "SAVE") {
			hokhau = new hokhau_model();
			try {
				hokhau.chuho = textField_tenchuho.getText();
				hokhau.diachi = textField_diachi.getText();
				hokhau.maho = textField_maho.getText();
				hokhau.Sothanhvien =Integer.parseInt(textField_sothanhvien.getText()) ;
				screen_view.themHoKhau(hokhau);
				quanly_model.dsHoKhau.add(hokhau);
				JOptionPane.showInternalMessageDialog(null, "Insert success!");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showInternalMessageDialog(null, "Bạn nhập sai, vui lòng nhập lại");
				
			}		
			this.setnull();
			
		}
		else if(src == "RESET") {
			this.setnull();
		}
	}
	public void setnull() {
		textField_maho.setText("");
		textField_diachi.setText("");
		textField_sothanhvien.setText("");
		textField_tenchuho.setText("");
		
	}
}
