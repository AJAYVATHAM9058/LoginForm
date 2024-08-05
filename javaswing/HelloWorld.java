package javaswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;

/*
 * This class demonstrates simple Hello World  swing program
 * 
 * */

public class HelloWorld {

	   HelloWorld(){
		
		JFrame jf = new JFrame("hello world");
		JButton jb = new JButton("Click Me");
		jb.setBounds(15,50,150,40);
		jf.add(jb);

		JLabel label = new JLabel("Hello Java Swing");
		Border border = BorderFactory.createLineBorder(Color.black);
		label.setBorder(border);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		label.setText("hello Ajay");
		
		
		jf.add(label);
		
		jf.setSize(400,400);
		jf.setLayout(new FlowLayout());
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HelloWorld();
	}

}
