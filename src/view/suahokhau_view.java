package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import database.jdbc;
import database.themhokhau_db;
import model.hokhau_model;
import model.quanly_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class suahokhau_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_diachi;
	private JTextField textField_sothanhvien;
	public JComboBox comboBox_maho ;
	public JComboBox comboBox_chuho;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public suahokhau_view() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 739, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa Thông Tin Hộ Khẩu");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(214, 20, 277, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Hộ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 88, 85, 28);
		contentPane.add(lblNewLabel_1);
		
		comboBox_maho = new JComboBox();
		comboBox_maho.setBounds(172, 88, 170, 29);
		comboBox_maho.addItem("");
		for(String i: quanly_model.dsMaHo) {
			comboBox_maho.addItem(i);
		}
		contentPane.add(comboBox_maho);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timkiem.setBackground(new Color(224, 255, 255));
		btn_timkiem.setBounds(476, 82, 124, 41);
		btn_timkiem.addActionListener(this);
		contentPane.add(btn_timkiem);
		
		JSlider slider = new JSlider();
		slider.setBounds(33, 133, 638, 22);
		contentPane.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("Chủ Hộ: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(54, 193, 110, 28);
		contentPane.add(lblNewLabel_2);
		
		comboBox_chuho = new JComboBox();
		comboBox_chuho.setBounds(196, 193, 222, 29);
		contentPane.add(comboBox_chuho);
		
		JLabel lblNewLabel_2_1 = new JLabel("Địa Chỉ:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(54, 275, 110, 28);
		contentPane.add(lblNewLabel_2_1);
		
		textField_diachi = new JTextField();
		textField_diachi.setBounds(196, 275, 222, 28);
		contentPane.add(textField_diachi);
		textField_diachi.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số thành viên");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(54, 349, 132, 28);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_sothanhvien = new JTextField();
		textField_sothanhvien.setColumns(10);
		textField_sothanhvien.setBounds(196, 349, 222, 28);
		contentPane.add(textField_sothanhvien);
		
		JButton btn_update = new JButton("UPDATE");
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_update.setBounds(382, 446, 137, 41);
		btn_update.addActionListener(this);
		contentPane.add(btn_update);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection connec = jdbc.getconConnection();
		hokhau_model hokhau = new hokhau_model();
		try {
			java.sql.Statement st = connec.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String src = e.getActionCommand();
		if(src == "Tìm Kiếm") {
			try {
				java.sql.Statement st = connec.createStatement();
				String sql = "select * from hokhau where maho = '"+comboBox_maho.getSelectedItem().toString()+"'";
				String sql1 = "select * from nhankhau where maho = '"+comboBox_maho.getSelectedItem().toString()+"'";
				ResultSet rs_nhankhau = st.executeQuery(sql1);
				
				while(rs_nhankhau.next()) {
					comboBox_chuho.addItem(rs_nhankhau.getString("ten"));				
				}
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					comboBox_chuho.setSelectedItem(rs.getString("chuho"));
					textField_diachi.setText(rs.getString("diachi"));
					textField_sothanhvien.setText(rs.getString("sothanhvien"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(src == "UPDATE") {
			
				
				hokhau.maho = comboBox_maho.getSelectedItem().toString();
				hokhau.chuho = comboBox_chuho.getSelectedItem().toString();
				hokhau.diachi = textField_diachi.getText();
				hokhau.Sothanhvien =Integer.parseInt(textField_sothanhvien.getText());
				themhokhau_db.update_hokhau(hokhau, hokhau.maho);
				//screen_view.update_table_hokhau(hokhau, hokhau.maho);
				screen_view.delete_table_hokhau();
				themhokhau_db.hokhau_start();
				JOptionPane.showMessageDialog(null, "UPDATE SUCCESS!");
				this.setNull();
		}
	}
	public void setNull() {
		comboBox_chuho.setSelectedIndex(-1);
		comboBox_maho.setSelectedIndex(-1);
		textField_diachi.setText("");
		textField_sothanhvien.setText("");
		
	}
}
