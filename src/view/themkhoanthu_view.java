package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.khoanthu_model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class themkhoanthu_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	public JTextField textField_makhoanthu;
	public JTextField textField_tenkhoanthu;
	public JTextField textField_sotiendaunguoi;
	JComboBox comboBox_loaikhoanthu;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public themkhoanthu_view() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 614, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHOẢN THU");
		lblNewLabel.setBackground(new Color(204, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(147, 20, 369, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khoản thu: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(83, 122, 157, 30);
		contentPane.add(lblNewLabel_1);
		
		textField_makhoanthu = new JTextField();
		textField_makhoanthu.setBounds(275, 123, 226, 37);
		contentPane.add(textField_makhoanthu);
		textField_makhoanthu.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khoản thu: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(83, 200, 157, 30);
		contentPane.add(lblNewLabel_1_1);
		
		textField_tenkhoanthu = new JTextField();
		textField_tenkhoanthu.setColumns(10);
		textField_tenkhoanthu.setBounds(275, 201, 226, 37);
		contentPane.add(textField_tenkhoanthu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại khoản thu: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(83, 281, 157, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số tiền/đầu người: ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(83, 363, 173, 30);
		contentPane.add(lblNewLabel_1_3);
		
		textField_sotiendaunguoi = new JTextField();
		textField_sotiendaunguoi.setColumns(10);
		textField_sotiendaunguoi.setBounds(275, 364, 226, 37);
		contentPane.add(textField_sotiendaunguoi);
		
		comboBox_loaikhoanthu = new JComboBox();
		comboBox_loaikhoanthu.setBounds(275, 281, 226, 37);
		comboBox_loaikhoanthu.addItem("");
		comboBox_loaikhoanthu.addItem("Bắt buộc");
		comboBox_loaikhoanthu.addItem("Tự nguyện");
		contentPane.add(comboBox_loaikhoanthu);
		
		JButton btn_themkhoanthu_save = new JButton("SAVE");
		btn_themkhoanthu_save.setBackground(new Color(173, 255, 47));
		btn_themkhoanthu_save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themkhoanthu_save.setBounds(259, 436, 112, 37);
		btn_themkhoanthu_save.setFocusable(false);
		btn_themkhoanthu_save.addActionListener(this);
		contentPane.add(btn_themkhoanthu_save);
		
		JButton btn_themkhoanthu_reset = new JButton("RESET");
		btn_themkhoanthu_reset.setBackground(new Color(173, 255, 47));
		btn_themkhoanthu_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_themkhoanthu_reset.setBounds(412, 436, 112, 37);
		btn_themkhoanthu_reset.setFocusable(false);
		btn_themkhoanthu_reset.addActionListener(this);
		contentPane.add(btn_themkhoanthu_reset);
		
		this.setLocationRelativeTo(null);
		this.setTitle("Thêm khoản thu");
		this.setVisible(true);
	}
	public void setnull() {
		textField_makhoanthu.setText("");
		textField_tenkhoanthu.setText("");
		textField_sotiendaunguoi.setText("");
		comboBox_loaikhoanthu.setSelectedIndex(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "SAVE") {
			khoanthu_model khoanthu = new khoanthu_model();
			khoanthu.loaikhoanthu = comboBox_loaikhoanthu.getSelectedItem().toString();
			khoanthu.tenkhoanthu = textField_tenkhoanthu.getText();
			khoanthu.makhoanthu = textField_makhoanthu.getText();
			khoanthu.Sotien =Integer.parseInt(textField_sotiendaunguoi.getText()) ;
			screen_view.themKhoanThu(khoanthu);
			JOptionPane.showInternalMessageDialog(null, "insert success!");
			this.setnull();
		}
		else if(src == "RESET") {
			this.setnull();
		}
	}
}
