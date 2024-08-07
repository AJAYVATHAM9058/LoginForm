package javaForm;

import java.util.*;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(26, 22, 342, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Keep learning");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_3.setBounds(45, 231, 287, 62);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Login Form");
		lblNewLabel_2.setBounds(0, 0, 344, 198);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/images/bg_img.jpg")));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Login Form");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(69, 303, 177, 56);
		panel.add(lblNewLabel_5);
		
		Button button = new Button("Login");
		
		button.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				try {
					String Class1 = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/mysql";
					String uname = "root";
					String pwd = "Jaibalayya123";
					
					//Loading and registering the class
					Class.forName(Class1);
					
					//establishing the connection
					Connection con = DriverManager.getConnection(url,uname,pwd);
					
					//sql query
					String query = "select * from StudentData where username = ? and password = ?";
					
					//statement
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, username);
					ps.setString(2, password);
					
					
					ResultSet res = ps.executeQuery();
					
					if(res.next()) {
						
//						UserHome ah = new UserHome(username);
//						ah.setTitle("Welcome");
//						ah.setVisible(true);
						JOptionPane.showMessageDialog(button, "Hello "+username+"\nYou Have Successfully Logged in");
					}
					
					else {
						JOptionPane.showMessageDialog(button, "Invalid Credentials, Please Enter Valid Credentials");
					}
						
				}
				catch(Exception sqlException) {
					sqlException.printStackTrace();
				}
				
				
			}
		});
		
		button.setFont(new Font("Dialog", Font.BOLD, 17));
		button.setBackground(new Color(0, 128, 192));
		button.setBounds(572, 292, 169, 46);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(408, 91, 146, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(564, 91, 220, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(408, 170, 135, 24);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(564, 159, 220, 37);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4.setBounds(764, 22, 38, 37);
		contentPane.add(lblNewLabel_4);
	}
}
