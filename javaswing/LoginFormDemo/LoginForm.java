package javaswing.LoginFormDemo;

import java.awt.*;
import javax.swing.*;


public class LoginForm extends JFrame{

	
	JButton b1;
	JLabel username,password;
	JPasswordField tfP;
	JTextField tfU;
	JPanel panel;
	
	LoginForm(){
		
		
		panel = new JPanel();
		panel.setBounds(150,100,250,250);
		panel.setBackground(Color.MAGENTA);
		
		
		username = new JLabel();
		
		username.setText("Username");
		
		tfU = new JTextField();
		tfU.setBounds(30,20,100,30);
		tfU.setBackground(Color.green);
		panel.add(tfU);
		
		password = new JLabel("Password");
		
		
		panel.add(username);
		
		//panel.add(password);
		
		setSize(500,500);
		setVisible(true);
		setLayout(null);
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	
	
	public static void main(String args[]) {
		
		LoginForm login = new LoginForm();
	}
}