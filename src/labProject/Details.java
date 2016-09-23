package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

//import java.awt.image.BufferedImage.*;
//import javax.swing.border.*;

public class Details extends JFrame implements ActionListener
 {
	JLabel l1,l2,l3,l4,l5;
	JComboBox<String> cb1,cb4,cb3;
	JTextField t5,t2;
	JButton b1,b2,b3,admin;
	
	Citizen z;
	
	Details(Citizen y){
		this.z = y;
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("url4.jpg"));	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(500, 600,Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		
		setResizable(false);
		setSize(500,600);
		setTitle("Add Further Details");
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Marital Status : ");
		l1.setBounds(50, 50, 100, 20);
		l1.setFont(new Font("Arial", Font.BOLD,12));
		add(l1);
		
		
		cb1 = new JComboBox<String>();
		cb1.addItem(" -- ");
		cb1.addItem("Single");
		cb1.addItem("Married");
		cb1.addItem("Divorced");
		cb1.addItem("Widow");
		cb1.setBounds(200, 50, 150, 20);
		add(cb1);
		
		l2 = new JLabel("No.of Children : ");
		l2.setBounds(50, 100, 100, 20);
		l2.setFont(new Font("Arial", Font.BOLD,12));
		add(l2);
		
		t2 = new JTextField(3);
		t2.setBounds(200, 100, 150, 20);
		t2.setFont(f);
		add(t2);
		
		l3 = new JLabel("Qualification : ");
		l3.setBounds(50, 150, 100, 20);
		l3.setFont(new Font("Arial", Font.BOLD,12));
		add(l3);
		
		cb3 = new JComboBox<String>();
		cb3.addItem(" -- ");
		cb3.addItem("No Qualification");
		cb3.addItem("Secondary");
		cb3.addItem("Senior Secondary");
		cb3.addItem("Graduation");
		cb3.addItem("Post Graduation");
		cb3.addItem("Ph D");
		cb3.setBounds(200, 150, 150, 20);
		add(cb3);
		
		l4 = new JLabel("Occupation : ");
		l4.setBounds(50, 200, 100, 20);
		l4.setFont(new Font("Arial", Font.BOLD,12));
		add(l4);
		
		cb4 = new JComboBox<String>();
		cb4.addItem(" -- ");
		cb4.addItem("Student");
		cb4.addItem("Agriculture");
		cb4.addItem("Banking Services");
		cb4.addItem("Business");
		cb4.addItem("Defence Services");
		cb4.addItem("Doctor");
		cb4.addItem("Engineer");
		cb4.addItem("Govt. Services");
		cb4.addItem("Police");
		cb4.addItem("Railway Services");
		cb4.addItem("Teaching");
		cb4.addItem("Others");
		cb4.setBounds(200, 200, 150, 20);
		add(cb4);
		
		l5 = new JLabel("Annual Income(in K's) : ");
		l5.setBounds(50, 250, 100, 20);
		l5.setFont(new Font("Arial", Font.BOLD,12));
		add(l5);
		
		t5 = new JTextField(10);
		t5.setBounds(200, 250, 150, 20);
		t5.setFont(f);
		add(t5);
		
		b1 = new JButton("Save");
		b1.setBounds(100, 350, 80, 20);
		add(b1);
		
		b2 = new JButton("Next");
		b2.setBounds(250, 350, 80, 20);
		add(b2);
		b2.setEnabled(false);
		
		b3 = new JButton("Reset");
		b3.setBounds(400, 350, 80, 20);
		add(b3);
		
		admin = new JButton("admin");
		admin.setBounds(450,0,50,40);
		add(admin);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		admin.addActionListener(this);
		
		b2.setEnabled(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int p = (int) ((dimension.getWidth() - 500) / 2);
		int q = (int) ((dimension.getHeight() - 600) / 2);
		setLocation(p, q);
		
		setVisible(true);
		setSize(500,600);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == admin){
			int response  = JOptionPane.showConfirmDialog(this, "Your data will be lost..Do u still want ti exit???","confirm", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION){
				setVisible(false);
				new Admin();
			}
		}
		if (ae.getSource()==b1){
			String a = t2.getText();
			int child = Integer.parseInt(a);
			String b = t5.getText();
			int inc = Integer.parseInt(b);
			String mar = cb1.getSelectedItem().toString();
			String qual = cb3.getSelectedItem().toString();
			String occ = cb4.getSelectedItem().toString();
			
			if(a.isEmpty() ||  b.isEmpty() ||  
					 cb3.getSelectedItem().toString().equals(" -- ")
					|| cb1.getSelectedItem().toString().equals(" -- ")
					|| cb4.getSelectedItem().toString().equals(" -- ")){
				JOptionPane.showMessageDialog(this, "Enter Complete Details");
			}
				else {
					z.addDetails(child, inc, mar, qual, occ);
					b2.setEnabled(true);
				}
			}
		
		else if (ae.getSource()==b2){
			try {
				z.register();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			new Commodity(z.aadharNo);
			this.setVisible(false);
		}
		
		else if (ae.getSource() == b3){
			cb1.setSelectedItem(" -- ");
			t2.setText("");
			cb3.setSelectedItem(" -- ");
			cb4.setSelectedItem(" -- ");
			t5.setText("");
			
		}
		
		}
		
	}
	
	

