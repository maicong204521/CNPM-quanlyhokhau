package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import database.jdbc;
import database.themnoptien_db;
import model.noptien_model;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;

public class suaNopTien extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_maho;
	private JTextField textField_khoanthu;
	private JTextField textField_tennguoidong;
	private JTextField textField_sotien;
	private JTextField textField_ngaydong;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public suaNopTien() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 710, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa thông tin nộp tiền");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(210, 25, 293, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hộ:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 89, 87, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_maho = new JTextField();
		textField_maho.setBounds(149, 89, 172, 26);
		contentPane.add(textField_maho);
		textField_maho.setColumns(10);
		
		textField_khoanthu = new JTextField();
		textField_khoanthu.setColumns(10);
		textField_khoanthu.setBounds(481, 89, 172, 26);
		contentPane.add(textField_khoanthu);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khoản thu:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(354, 89, 98, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.setForeground(new Color(255, 255, 255));
		btn_timkiem.setBackground(new Color(0, 102, 255));
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_timkiem.setBounds(271, 144, 141, 39);
		btn_timkiem.addActionListener(this);
		contentPane.add(btn_timkiem);
		
		JSlider slider = new JSlider();
		slider.setBounds(33, 193, 620, 22);
		contentPane.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("Tên người đóng:");
		lblNewLabel_2.setForeground(new Color(102, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 269, 149, 26);
		contentPane.add(lblNewLabel_2);
		
		textField_tennguoidong = new JTextField();
		textField_tennguoidong.setBounds(225, 263, 203, 39);
		contentPane.add(textField_tennguoidong);
		textField_tennguoidong.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số Tiền:");
		lblNewLabel_2_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(33, 338, 149, 26);
		contentPane.add(lblNewLabel_2_1);
		
		textField_sotien = new JTextField();
		textField_sotien.setColumns(10);
		textField_sotien.setBounds(225, 332, 203, 39);
		contentPane.add(textField_sotien);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày đóng: ");
		lblNewLabel_2_2.setForeground(new Color(102, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(33, 408, 149, 26);
		contentPane.add(lblNewLabel_2_2);
		
		textField_ngaydong = new JTextField();
		textField_ngaydong.setColumns(10);
		textField_ngaydong.setBounds(225, 402, 203, 39);
		contentPane.add(textField_ngaydong);
		
		JButton btn_update = new JButton("UPDATE");
		btn_update.setBackground(new Color(0, 102, 255));
		btn_update.setForeground(new Color(255, 255, 255));
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_update.setBounds(498, 477, 127, 33);
		btn_update.addActionListener(this);
		btn_timkiem.setFocusable(false);
		btn_update.setFocusable(false);
		contentPane.add(btn_update);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		Connection connec = jdbc.getconConnection();
		noptien_model noptien = new noptien_model();
		if(src == "Tìm Kiếm") {
			try {
				java.sql.Statement st = connec.createStatement();
				String sql = "select * from noptien where mahokhau = '"+ textField_maho.getText()+"' and tenkhoanthu = '"+textField_khoanthu.getText()+"'";
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()== false) {
					JOptionPane.showMessageDialog(null,"Không tìm thấy thông tin phù hợp");
					textField_maho.setText("");
					textField_khoanthu.setText("");
				}
				else {
					textField_tennguoidong.setText(rs.getString("tennguoinop"));
					textField_ngaydong.setText(rs.getString("ngaythu"));
					textField_sotien.setText(rs.getString("Sotien"));
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(src == "UPDATE") {
			noptien.MaHoKhau = textField_maho.getText();
			noptien.TenKhoanThu = textField_khoanthu.getText();
			noptien.TenNguoiNop = textField_tennguoidong.getText();
			noptien.NgayThu = textField_ngaydong.getText();
			noptien.SoTien = Integer.parseInt(textField_sotien.getText());
			themnoptien_db.update_noptien(noptien, noptien.MaHoKhau, noptien.TenKhoanThu);
			screen_view.delete_table_dongphi();
			themnoptien_db.noptien_start();
			JOptionPane.showMessageDialog(null,"UPDATE SUCCESS!");
			textField_maho.setText("");
			textField_tennguoidong.setText("");
			textField_khoanthu.setText("");
			textField_ngaydong.setText("");
			textField_sotien.setText("");
		}
	}
}
