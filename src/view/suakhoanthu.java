package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import database.jdbc;
import database.themkhoanthu_db;
import model.khoanthu_model;
import model.quanly_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class suakhoanthu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_tenkhoanthu;
	private JTextField textField_sotien;
	public Connection connec = jdbc.getconConnection();
	public JComboBox comboBox_loaikhoanthu ;
	JComboBox comboBox_makhoanthu;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public suakhoanthu() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 717, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa thông tin khoản thu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(195, 10, 275, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khoản thu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 85, 128, 25);
		contentPane.add(lblNewLabel_1);
		
		comboBox_makhoanthu = new JComboBox();
		comboBox_makhoanthu.setBounds(232, 82, 173, 30);
		comboBox_makhoanthu.addItem("");
		for(String i: quanly_model.dsMakhoanthu) {
			comboBox_makhoanthu.addItem(i);
		}
		contentPane.add(comboBox_makhoanthu);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.setBackground(new Color(224, 255, 255));
		
		btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_timkiem.setBounds(485, 83, 112, 30);
		btn_timkiem.addActionListener(this);
		btn_timkiem.setFocusable(false);
		contentPane.add(btn_timkiem);
		
		JSlider slider = new JSlider();
		slider.setBounds(57, 146, 540, 22);
		contentPane.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khoản thu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(57, 212, 141, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_tenkhoanthu = new JTextField();
		textField_tenkhoanthu.setBounds(253, 212, 152, 28);
		contentPane.add(textField_tenkhoanthu);
		textField_tenkhoanthu.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Khoản Thu:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(57, 295, 141, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số Tiền:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(57, 374, 141, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_sotien = new JTextField();
		textField_sotien.setColumns(10);
		textField_sotien.setBounds(253, 374, 152, 28);
		contentPane.add(textField_sotien);
		
		JButton btn_delete = new JButton("DELETE");
		btn_delete.setBackground(new Color(250, 250, 210));
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_delete.setBounds(318, 458, 141, 30);
		btn_delete.addActionListener(this);
		btn_delete.setFocusable(false);
		contentPane.add(btn_delete);
		
		JButton btn_update = new JButton("UPDATE");
		btn_update.setBackground(new Color(250, 250, 210));
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_update.setBounds(501, 458, 141, 30);
		btn_update.addActionListener(this);
		contentPane.add(btn_update);
		btn_update.setFocusable(false);
		
		comboBox_loaikhoanthu = new JComboBox();
		comboBox_loaikhoanthu.setBounds(253, 295, 152, 29);
		comboBox_loaikhoanthu.addItem("");
		comboBox_loaikhoanthu.addItem("Tự nguyện");
		comboBox_loaikhoanthu.addItem("Bắt buộc");
		contentPane.add(comboBox_loaikhoanthu);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		java.sql.Statement st = null;
		try {
			st = connec.createStatement();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String src = e.getActionCommand();
		if(src == "Tìm Kiếm") {
			String sql = "select * from khoanthu where makhoanthu = '"+comboBox_makhoanthu.getSelectedItem().toString()+"'";
			try {
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					comboBox_loaikhoanthu.setSelectedItem(rs.getString("loaikhoanthu"));
					textField_sotien.setText(String.valueOf(rs.getInt("Sotien")));
					textField_tenkhoanthu.setText(rs.getString("tenkhoanthu"));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(src == "UPDATE") {
			khoanthu_model khoanthu_ = new khoanthu_model();
			khoanthu_.makhoanthu = comboBox_makhoanthu.getSelectedItem().toString();
			khoanthu_.loaikhoanthu = comboBox_loaikhoanthu.getSelectedItem().toString();
			khoanthu_.Sotien =Integer.parseInt(textField_sotien.getText());
			khoanthu_.tenkhoanthu = textField_tenkhoanthu.getText();
			themkhoanthu_db.update_khoanthu(khoanthu_, khoanthu_.makhoanthu);
			//screen_view.update_table_khoanthu(khoanthu_, khoanthu_.makhoanthu);
			screen_view.delete_table_khoanthu();
			themkhoanthu_db.khoanthu_start();
			JOptionPane.showMessageDialog(null, "Update Success!");
			this.setNull();
		}
		if(src == "DELETE") {
			//screen_view.delete_row_khoanthu(comboBox_makhoanthu.getSelectedItem().toString());
			themkhoanthu_db.delete_row_khoanthu(comboBox_makhoanthu.getSelectedItem().toString());
			screen_view.delete_table_khoanthu();
			themkhoanthu_db.khoanthu_start();
			JOptionPane.showMessageDialog(null, "Delete Success!");
			this.setNull();
		}
	}
	public void setNull() {
		textField_sotien.setText("");
		textField_tenkhoanthu.setText("");
		comboBox_loaikhoanthu.setSelectedIndex(-1);
		comboBox_makhoanthu.setSelectedIndex(-1);
		
	}
}
