package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class suaNopTien extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa thông tin nộp tiền");
		lblNewLabel.setBounds(202, 31, 269, 33);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
