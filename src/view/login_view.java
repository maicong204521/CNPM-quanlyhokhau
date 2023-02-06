package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.checking_login;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;

public class login_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_user;
	private JPasswordField passwordField;
	JLabel label_warning ;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public login_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 528);
		this.setLocationRelativeTo(null);
		this.setTitle("App quản lý hộ khẩu");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(69, 168, 115, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(69, 275, 115, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_user = new JTextField();
		textField_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_user.setBounds(222, 168, 287, 36);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phần mềm quản lý sổ hộ khẩu");
		lblNewLabel_2.setBackground(new Color(204, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_2.setBounds(69, 40, 465, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_dangnhap = new JButton("Đăng nhập");
		btn_dangnhap.setForeground(new Color(248, 248, 255));
		btn_dangnhap.setFont(new Font("Arial", Font.BOLD, 22));
		btn_dangnhap.setBackground(new Color(30, 144, 255));
		btn_dangnhap.setBounds(167, 383, 158, 43);
		btn_dangnhap.setFocusable(false);
		btn_dangnhap.addActionListener(this);
		contentPane.add(btn_dangnhap);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 275, 287, 36);
		
		contentPane.add(passwordField);
		
		JButton btn_dangki = new JButton("Đăng kí");
		btn_dangki.setForeground(new Color(248, 248, 255));
		btn_dangki.setFont(new Font("Arial", Font.BOLD, 22));
		btn_dangki.setFocusable(false);
		btn_dangki.setBackground(new Color(30, 144, 255));
		btn_dangki.setBounds(351, 383, 158, 43);
		btn_dangki.addActionListener(this);
		contentPane.add(btn_dangki);
		
		label_warning = new JLabel("!!Vui lòng điền đầy đủ thông tin");
		label_warning.setForeground(new Color(255, 0, 0));
		label_warning.setFont(new Font("Arial", Font.BOLD, 10));
		label_warning.setBounds(355, 321, 170, 13);
		//contentPane.add(label_warning);
		
		lblNewLabel = new JLabel("!!Tên đăng nhập hoặc mật khẩu không chính xác.");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(248, 321, 277, 13);
		
		
		//*******************************************************************************************//
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "Đăng nhập") {
			String user = textField_user.getText();
			String password = passwordField.getText();
			if(user.equals("")||password.equals("")) {
				contentPane.add(label_warning);
				contentPane.repaint();
				contentPane.revalidate();
			}
			else {
				boolean check = checking_login.check(user, password);
				if(check) {
					screen_view screen  = new screen_view();
					screen.setView();
					this.setVisible(false);
				}
				else {
					contentPane.remove(label_warning);
					contentPane.add(lblNewLabel);
					contentPane.repaint();
					contentPane.revalidate();
				}
			}
		}
		else if(src == "Đăng kí") {
			this.setVisible(false);
			new dangki_view();
			
		}
	}
}
