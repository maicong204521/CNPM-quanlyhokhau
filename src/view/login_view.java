package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class login_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public login_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 548);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(85, 204, 115, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(85, 281, 115, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_user = new JTextField();
		textField_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_user.setBounds(238, 204, 287, 36);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phần mềm quản lý sổ hộ khẩu");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(94, 53, 442, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton button_login = new JButton("LOGIN");
		button_login.setForeground(new Color(0, 0, 205));
		button_login.setFont(new Font("Arial", Font.BOLD, 25));
		button_login.setBackground(new Color(216, 191, 216));
		button_login.setBounds(213, 384, 181, 74);
		button_login.setFocusable(false);
		button_login.addActionListener(this);
		contentPane.add(button_login);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 281, 287, 36);
		
		contentPane.add(passwordField);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src == "LOGIN") {
			System.out.print("Mai dinh cong");
			screen_view screen  = new screen_view();
			//this.setVisible(false);
			screen.setView();
			this.setVisible(false);
		}
	}
}
