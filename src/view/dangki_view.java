package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.add_account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class dangki_view extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_user;
	private JPasswordField password_user;
	private JLabel lblNewLabel_1_2;
	private JPasswordField password_xacnhan;
	private JButton btn_dangki;
	private JLabel label_warning;
	private JLabel label_warning2;
	private JButton btn_quaylai;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public dangki_view() {
		setDefaultCloseOperation(1);
		setBounds(100, 100, 520, 403);
		this.setTitle("Đăng Kí");
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên người dùng");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 85, 155, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Đăng Kí Tài Khoản");
		lblNewLabel.setBounds(136, 22, 232, 30);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		textField_user = new JTextField();
		textField_user.setBounds(239, 85, 183, 30);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		password_user = new JPasswordField();
		password_user.setBounds(239, 160, 183, 30);
		contentPane.add(password_user);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(55, 161, 155, 25);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("Xác nhận");
		lblNewLabel_1_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(55, 237, 155, 25);
		contentPane.add(lblNewLabel_1_2);
		
		password_xacnhan = new JPasswordField();
		password_xacnhan.setBounds(239, 236, 183, 30);
		contentPane.add(password_xacnhan);
		
		btn_dangki = new JButton("Đăng Kí");
		btn_dangki.setBackground(new Color(30, 144, 255));
		btn_dangki.setForeground(new Color(248, 248, 255));
		btn_dangki.setFont(new Font("Arial", Font.BOLD, 20));
		btn_dangki.setBounds(166, 304, 119, 33);
		btn_dangki.addActionListener(this);
		btn_dangki.setFocusable(false);
		contentPane.add(btn_dangki);
		
		btn_quaylai = new JButton("Quay Lại");
		btn_quaylai.setForeground(new Color(248, 248, 255));
		btn_quaylai.setFont(new Font("Arial", Font.BOLD, 20));
		btn_quaylai.setFocusable(false);
		btn_quaylai.setBackground(new Color(30, 144, 255));
		btn_quaylai.setBounds(303, 304, 119, 33);
		btn_quaylai.addActionListener(this);
		contentPane.add(btn_quaylai);
		
		label_warning2 = new JLabel("!!Tên người dùng đã tồn tại");
		label_warning2.setForeground(new Color(255, 0, 0));
		label_warning2.setBounds(262, 268, 172, 13);
		
		
		label_warning = new JLabel("!!Các mật khẩu đã nhập không trùng khớp. Vui lòng thử lại");
		label_warning.setForeground(new Color(255, 0, 0));
		label_warning.setBounds(95, 272, 327, 13);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		String password = password_user.getText();
		String xacnhan = password_xacnhan.getText();
		String user = textField_user.getText();
		if(src == "Đăng Kí") {
			if(textField_user.getText().equals("")||password_user.getPassword().toString().equals("")||password_xacnhan.getPassword().toString().equals("")) {
				JOptionPane.showMessageDialog(null,"Vui lòng điền đầy đủ thông tin !");
			}
			else {
				
				System.out.print(password+"\n");
				System.out.print(xacnhan+"\n");
				if(!password.equals(xacnhan)) {
					contentPane.remove(label_warning2);
					contentPane.add(label_warning);
					contentPane.repaint();
					contentPane.revalidate();
				}
				else {
					boolean check = add_account.addAccount(user, password);
					if(check == false) {
						contentPane.add(label_warning2);
						contentPane.remove(label_warning);
						contentPane.repaint();
						contentPane.revalidate();
					}else {
						JOptionPane.showMessageDialog(null, "Đăng kí thành công");
						new login_view();
						this.setVisible(false);
						
					}
					
				}
			}
		}
		else if(src == "Quay Lại") {
			this.setVisible(false);
			new login_view();
			
		}
	}
	
}
