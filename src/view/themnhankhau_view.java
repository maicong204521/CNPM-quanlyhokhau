package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.hokhau_model;
import model.nhankhau_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class themnhankhau_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_hoten;
	private JTextField textField_cmnd;
	private JTextField textField_dantoc;
	private JTextField textField_age;
	private JTextField textField_sdt;
	private JTextField textField_diachi;
	private JTextField textField_qhchuho;
	ButtonGroup btn_nam_nu;
	private JTextField textField_mahokhau;
	JRadioButton radioBtn_nam, radioBtn_nu;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public themnhankhau_view() {
		setDefaultCloseOperation(1);
		setBounds(0, -51, 876, 724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN KHẨU");
		lblNewLabel.setBounds(264, 43, 331, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Và Tên: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(41, 136, 128, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_hoten = new JTextField();
		textField_hoten.setToolTipText("");
		textField_hoten.setBackground(new Color(255, 255, 240));
		textField_hoten.setBounds(163, 131, 215, 42);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CMND:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(458, 136, 128, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField_cmnd = new JTextField();
		textField_cmnd.setToolTipText("");
		textField_cmnd.setColumns(10);
		textField_cmnd.setBackground(new Color(255, 255, 240));
		textField_cmnd.setBounds(580, 131, 215, 42);
		contentPane.add(textField_cmnd);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Hộ Khẩu:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(41, 251, 128, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Dân Tộc:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(458, 245, 128, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textField_dantoc = new JTextField();
		textField_dantoc.setToolTipText("");
		textField_dantoc.setColumns(10);
		textField_dantoc.setBackground(new Color(255, 255, 240));
		textField_dantoc.setBounds(580, 240, 215, 42);
		contentPane.add(textField_dantoc);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tuổi:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(41, 358, 128, 26);
		contentPane.add(lblNewLabel_1_4);
		
		textField_age = new JTextField();
		textField_age.setToolTipText("");
		textField_age.setColumns(10);
		textField_age.setBackground(new Color(255, 255, 240));
		textField_age.setBounds(163, 353, 215, 42);
		contentPane.add(textField_age);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("SĐT:");
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4_1.setBounds(458, 358, 128, 26);
		contentPane.add(lblNewLabel_1_4_1);
		
		textField_sdt = new JTextField();
		textField_sdt.setToolTipText("");
		textField_sdt.setColumns(10);
		textField_sdt.setBackground(new Color(255, 255, 240));
		textField_sdt.setBounds(580, 353, 215, 42);
		contentPane.add(textField_sdt);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_4_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4_2.setBounds(41, 464, 128, 26);
		contentPane.add(lblNewLabel_1_4_2);
		
		textField_diachi = new JTextField();
		textField_diachi.setToolTipText("");
		textField_diachi.setColumns(10);
		textField_diachi.setBackground(new Color(255, 255, 240));
		textField_diachi.setBounds(163, 459, 215, 42);
		contentPane.add(textField_diachi);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Qh Chủ hộ:");
		lblNewLabel_1_4_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4_2_1.setBounds(458, 464, 128, 26);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		textField_qhchuho = new JTextField();
		textField_qhchuho.setToolTipText("");
		textField_qhchuho.setColumns(10);
		textField_qhchuho.setBackground(new Color(255, 255, 240));
		textField_qhchuho.setBounds(580, 459, 215, 42);
		contentPane.add(textField_qhchuho);
		
		JLabel lblNewLabel_1_4_2_2 = new JLabel("Giới Tính: ");
		lblNewLabel_1_4_2_2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_4_2_2.setBounds(209, 560, 128, 26);
		contentPane.add(lblNewLabel_1_4_2_2);
		
		btn_nam_nu = new ButtonGroup();
		
		
		radioBtn_nam = new JRadioButton("Nam");
		radioBtn_nam.setFont(new Font("Arial", Font.PLAIN, 25));
		radioBtn_nam.setBounds(373, 563, 103, 21);
		contentPane.add(radioBtn_nam);
		
		radioBtn_nu = new JRadioButton("Nữ");
		radioBtn_nu.setFont(new Font("Arial", Font.PLAIN, 25));
		radioBtn_nu.setBounds(544, 563, 103, 21);
		contentPane.add(radioBtn_nu);
		btn_nam_nu.add(radioBtn_nu);
		btn_nam_nu.add(radioBtn_nam);
		JButton btn_themnhankhau_save = new JButton("SAVE");
		btn_themnhankhau_save.setBackground(new Color(255, 192, 203));
		btn_themnhankhau_save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themnhankhau_save.setBounds(449, 636, 103, 37);
		btn_themnhankhau_save.setFocusable(false);
		btn_themnhankhau_save.addActionListener(this);
		contentPane.add(btn_themnhankhau_save);
		
		JButton btn_themnhankhau_reset = new JButton("RESET");
		btn_themnhankhau_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themnhankhau_reset.setBackground(new Color(255, 192, 203));
		btn_themnhankhau_reset.setBounds(637, 636, 103, 37);
		btn_themnhankhau_reset.setFocusable(false);
		btn_themnhankhau_reset.addActionListener(this);
		contentPane.add(btn_themnhankhau_reset);
		
		textField_mahokhau = new JTextField();
		textField_mahokhau.setToolTipText("");
		textField_mahokhau.setColumns(10);
		textField_mahokhau.setBackground(new Color(255, 255, 240));
		textField_mahokhau.setBounds(163, 245, 215, 42);
		contentPane.add(textField_mahokhau);
		this.setTitle("Thêm nhân khẩu");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "RESET") {
			this.setNull();
		}
		if(src == "SAVE") {
			nhankhau_model nhankhau = new nhankhau_model();
			nhankhau.name_nhankhau = textField_hoten.getText();
			nhankhau.cmnd = textField_cmnd.getText();
			nhankhau.dantoc = textField_dantoc.getText();
			nhankhau.hokhau = new hokhau_model();
			nhankhau.hokhau.maho =textField_mahokhau.getText() ;
			nhankhau.quanheChuho = textField_qhchuho.getText();
			nhankhau.diachi = textField_diachi.getText();
			nhankhau.age_nhankhau =Integer.parseInt(textField_age.getText()) ;
			nhankhau.sdt = textField_sdt.getText();
			if(radioBtn_nam.isSelected()) {
				nhankhau.gioitinh = "Nam";
			}
			else {
				nhankhau.gioitinh = "Nu";
			}
			//DefaultTableModel model_table = (DefaultTableModel)View1.table_nhankhau.getModel();
			
			//model_table.addRow(new Object[] {ts.mssv + "",ts.name+"",ts.queQuan.tentinh,ts.ngaysinh,ts.gioitinh,ts.diemmon1 + "",ts.diemmon2 + "",ts.diemmon3+ ""});
			//model_table.addRow(new Object[] {nhankhau.name_nhankhau,nhankhau.cmnd+"",nhankhau.hokhau.maho, nhankhau.age_nhankhau + "",nhankhau.diachi,nhankhau.gioitinh,nhankhau.sdt,nhankhau.quanheChuho});
			screen_view.themNhanKhau(nhankhau);
			JOptionPane.showInternalMessageDialog(null, "Insert Success");
			this.setNull();
		}
	}
	public void setNull() {
		textField_hoten.setText("");
		textField_cmnd.setText("");
		textField_dantoc.setText("");
		textField_diachi.setText("");
		textField_sdt.setText("");
		textField_age.setText("");
		textField_qhchuho.setText("");
		btn_nam_nu.clearSelection();
		textField_mahokhau.setText("");
	}
}
