package RegistrationForm;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordTF;
	private JPasswordField passwordField_1;
	private JTextField FirstNameTF;
	private JTextField LastNameTF;
	private JTextField EmailTF;
	private JTextField MobileNoTF;
	private final JLabel lblX = new JLabel("X");
	private JTextField usernameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(466, 103, 116, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New User Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1.setBounds(285, 27, 284, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password     :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(466, 162, 146, 37);
		contentPane.add(lblNewLabel_2);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(601, 169, 160, 29);
		contentPane.add(passwordTF);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password   :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(432, 235, 173, 29);
		contentPane.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(621, 238, 160, 29);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("First Name   : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(62, 88, 116, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Last Name   : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(62, 144, 116, 24);
		contentPane.add(lblNewLabel_5);
		
		FirstNameTF = new JTextField();
		FirstNameTF.setBounds(211, 89, 160, 29);
		contentPane.add(FirstNameTF);
		FirstNameTF.setColumns(10);
		
		LastNameTF = new JTextField();
		LastNameTF.setBounds(211, 144, 160, 31);
		contentPane.add(LastNameTF);
		LastNameTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email address  : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(50, 210, 139, 13);
		contentPane.add(lblNewLabel_6);
		
		EmailTF = new JTextField();
		EmailTF.setBounds(211, 206, 195, 27);
		contentPane.add(EmailTF);
		EmailTF.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile No.  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(54, 269, 124, 22);
		contentPane.add(lblNewLabel_7);
		
		MobileNoTF = new JTextField();
		MobileNoTF.setBounds(211, 269, 160, 29);
		contentPane.add(MobileNoTF);
		MobileNoTF.setColumns(10);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(255, 0, 0));
		lblX.setBounds(756, 0, 37, 49);
		contentPane.add(lblX);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = usernameTF.getText();
				String password = passwordTF.getText();
				String  mobileNo = MobileNoTF.getText();
				String firstname = FirstNameTF.getText();
				String lastname = LastNameTF.getText();
				String email = EmailTF.getText();
				
				long mobileNo1 = 0l;
				try {
					mobileNo1 = Long.parseLong(mobileNo);
				}catch(NumberFormatException e1) {
					e1.printStackTrace();
				}
				
				String msg = ""+firstname;
				msg += " \n";
				
				int len = mobileNo.length();
				if(len != 10) {
					JOptionPane.showMessageDialog(btnNewButton, "Enter a Valid Mobile No.");
				}
				
				if(len == 10) {
				
				try {
					String class1 = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/mysql";
					String uname = "root";
					String pwd = "Jaibalayya123";
					
					//Loading and Registering the class
					Class.forName(class1);
					
					//Creating Connection
					Connection conn = DriverManager.getConnection(url,uname,pwd);
					
					String query = "INSERT INTO StudentData VALUES('"+firstname+"','"+ lastname +"','"+ username+"','"+ password +"','"+email +"',"+mobileNo1+")";
					
		
					
					// Statement
					Statement st = conn.createStatement();
					int x = st.executeUpdate(query);
					
					if(x == 0) {
						JOptionPane.showMessageDialog(btnNewButton, "This  is already Exist ");
					}
					
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Welcome "+msg+"  Your account is successfully created");
					//	dispose();
					}
					
					conn.close();
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
					
				}
				
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(346, 339, 124, 29);
		contentPane.add(btnNewButton);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(601, 108, 160, 26);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
	}
}
