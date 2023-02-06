package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import database.jdbc;
import database.themnhankhau_db;
import model.hokhau_model;
import model.nhankhau_model;
import model.quanly_model;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JSlider;

public class suanhankhau_view extends JFrame implements ActionListener{

	public JPanel contentPane;
	public JTextField textField_cmnd;
	public JTextField textField_ten;
	public JTextField textField_diachi;
	public JTextField textField_sdt;
	public JTextField textField_qhchuho;
	public JTextField textField_dantoc;
	public JTextField textField_tuoi;
	public JComboBox comboBox_id ;
	public JRadioButton radio_nam ;
	public JRadioButton radio_nu;
	JComboBox comboBox_mahokhau;
	public ButtonGroup btn_group;
	public static Connection connec = jdbc.getconConnection();
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public suanhankhau_view() {
		
		setDefaultCloseOperation(1);
		setBounds(100, 100, 784, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa Nhân Khẩu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(259, 24, 228, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 75, 95, 30);
		contentPane.add(lblNewLabel_1);
		
		comboBox_id = new JComboBox();
		comboBox_id.setBounds(152, 78, 173, 30);
		comboBox_id.addItem("");
		for(String i : quanly_model.dsIdNhankhau) {
			comboBox_id.addItem(i);
		}
		contentPane.add(comboBox_id);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Hộ Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(20, 169, 113, 30);
		contentPane.add(lblNewLabel_1_1);
		
		comboBox_mahokhau = new JComboBox();
		comboBox_mahokhau.setBounds(151, 172, 173, 30);
		comboBox_mahokhau.addItem("");
		for(String i: quanly_model.dsMaHo) {
			comboBox_mahokhau.addItem(i);
		}
		contentPane.add(comboBox_mahokhau);
		
		JLabel lblNewLabel_2 = new JLabel("CMND:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 493, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_cmnd = new JTextField();
		textField_cmnd.setBounds(151, 497, 173, 30);
		contentPane.add(textField_cmnd);
		textField_cmnd.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ Và Tên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(416, 172, 100, 30);
		contentPane.add(lblNewLabel_2_1);
		
		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(560, 172, 180, 30);
		contentPane.add(textField_ten);
		
		JLabel lblNewLabel_2_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(20, 256, 100, 30);
		contentPane.add(lblNewLabel_2_2);
		
		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(151, 260, 173, 30);
		contentPane.add(textField_diachi);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(416, 256, 113, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(560, 256, 180, 30);
		contentPane.add(textField_sdt);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("quan hệ chủ hộ:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(416, 342, 134, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField_qhchuho = new JTextField();
		textField_qhchuho.setColumns(10);
		textField_qhchuho.setBounds(560, 342, 180, 30);
		contentPane.add(textField_qhchuho);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Dân tộc:");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(416, 427, 100, 30);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		textField_dantoc = new JTextField();
		textField_dantoc.setColumns(10);
		textField_dantoc.setBounds(560, 427, 180, 30);
		contentPane.add(textField_dantoc);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tuổi:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(20, 338, 100, 30);
		contentPane.add(lblNewLabel_2_2_1);
		
		textField_tuoi = new JTextField();
		textField_tuoi.setColumns(10);
		textField_tuoi.setBounds(151, 342, 173, 30);
		contentPane.add(textField_tuoi);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Giới tính:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(20, 427, 100, 30);
		contentPane.add(lblNewLabel_2_1_2);
		
		radio_nam = new JRadioButton("Nam");
		radio_nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_nam.setBounds(126, 433, 72, 21);
		contentPane.add(radio_nam);
		
		radio_nu = new JRadioButton("Nữ");
		radio_nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_nu.setBounds(248, 433, 72, 21);
		btn_group = new ButtonGroup();
		btn_group.add(radio_nu);
		btn_group.add(radio_nam);
		contentPane.add(radio_nu);
		
		JButton btn_update = new JButton("UPDATE");
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_update.setBounds(417, 493, 112, 34);
		contentPane.add(btn_update);
		btn_update.setFocusable(false);
		btn_update.addActionListener(this);
		JButton btn_reset = new JButton("RESET");
		btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_reset.setBounds(598, 493, 105, 34);
		btn_reset.setFocusable(false);
		btn_reset.addActionListener(this);
		contentPane.add(btn_reset);
		
		JButton btn_search = new JButton("Tìm Kiếm");
		btn_search.setBackground(new Color(224, 255, 255));
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_search.setBounds(498, 75, 134, 34);
		btn_search.addActionListener(this);
		btn_search.setFocusable(false);
		this.setLocationRelativeTo(null);
		contentPane.add(btn_search);
		
		JSlider slider = new JSlider();
		slider.setBounds(20, 127, 720, 22);
		contentPane.add(slider);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "Tìm Kiếm") {
			try {
				java.sql.Statement st = connec.createStatement();
				String idNhankhau = comboBox_id.getSelectedItem().toString();
				String sql = "select * from nhankhau where id = "+"'"+idNhankhau+"'";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					textField_ten.setText(rs.getString("ten"));
					textField_cmnd.setText(rs.getString("Cmnd"));
					textField_diachi.setText(rs.getString("diachi"));
					textField_sdt.setText(rs.getString("sdt"));
					textField_qhchuho.setText(rs.getString("quanhechuho"));
					textField_dantoc.setText(rs.getString("dantoc"));
					int age = rs.getInt("tuoi");
					textField_tuoi.setText(String.valueOf(age));
					comboBox_mahokhau.setSelectedItem(rs.getString("maho"));
					if(rs.getString("gioitinh")=="Nam") {
					radio_nam.setSelected(true);
					
					}
					else {
						radio_nu.setSelected(true);
					}
				}				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		else if(src == "UPDATE") {
			nhankhau_model nhankhau = new nhankhau_model();
			nhankhau.hokhau = new hokhau_model();
			nhankhau.name_nhankhau = textField_ten.getText();
			nhankhau.age_nhankhau =Integer.parseInt(textField_tuoi.getText()) ;
			nhankhau.cmnd = textField_cmnd.getText();
			nhankhau.diachi = textField_diachi.getText();
			nhankhau.dantoc = textField_dantoc.getText();
			nhankhau.quanheChuho = textField_qhchuho.getText();
			nhankhau.id_nhankhau = comboBox_id.getSelectedItem().toString();
			nhankhau.hokhau.maho = comboBox_mahokhau.getSelectedItem().toString();
			nhankhau.sdt = textField_sdt.getText();
			if(radio_nam.isSelected()) {
				nhankhau.gioitinh = "Nam";
			}
			else {
				nhankhau.gioitinh = "Nu";
			}
			try {
				themnhankhau_db.update_nhankhau(nhankhau, nhankhau.id_nhankhau);
				screen_view.update_table_nhankhau(nhankhau.id_nhankhau,nhankhau);
				this.setnull();
				JOptionPane.showInternalMessageDialog(null, "UPDATE SUCCESS");
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		}
	}
	public void setnull() {
		textField_ten.setText("");
		textField_cmnd.setText("");
		textField_diachi.setText("");
		textField_sdt.setText("");
		textField_qhchuho.setText("");
		textField_dantoc.setText("");
		comboBox_id.setSelectedIndex(-1);
		textField_tuoi.setText("");
		comboBox_mahokhau.setSelectedItem("");
		btn_group.clearSelection();
		
	}
}
