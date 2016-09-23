package labProject;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.image.BufferedImage.*;
import javax.swing.border.*;

public class AddCitizen extends JFrame implements ActionListener
 {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t6,t7,t8,t9,t10,t11,t43;
	JButton b1,b2,b3,admin;
	JComboBox<String> cb12,cb11,cb41,cb42;
	JRadioButton r1 , r2;    
	ButtonGroup grp;
	Citizen z;
	
	AddCitizen(int act , int aad)
	{	
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("url4.jpg"));	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(600, 699,Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		
		setResizable(false);
		setTitle("Add Citizen Details");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Aadhar No. : ");
		l1.setBounds(50, 50, 100, 20);
		l1.setFont(new Font("Arial", Font.BOLD,12));
		add(l1);
		
		t1 = new JTextField(10);
		t1.setBounds(200, 50, 150, 20);
		t1.setFont(f);
		add(t1);
		t1.setText(aad+"");
		t1.setEnabled(false);
		
		l2 = new JLabel("First Name : ");
		l2.setBounds(50, 90, 100, 20);
		l2.setFont(new Font("Arial", Font.BOLD,12));
		add(l2);
		
		t2 = new JTextField(20);
		t2.setBounds(200, 90, 150, 20);
		t2.setFont(f);
		add(t2);
		
		l3 = new JLabel("Last Name : ");
		l3.setBounds(50, 130, 100, 20);
		l3.setFont(new Font("Arial", Font.BOLD,12));
		add(l3);
		
		t3 = new JTextField(20);
		t3.setBounds(200, 130, 150, 20);
		t3.setFont(f);
		add(t3);
		
		l4 = new JLabel("Date of Birth");
		l4.setBounds(50, 170, 100, 20);
		l4.setFont(new Font("Arial", Font.BOLD,12));
		add(l4);
		
		cb41 = new JComboBox<String>();
		for(int i=1;i<=31;i++)
		{	String c;
			if(i<=9) c="0";
			else c="";
			cb41.addItem(new String(c+i));
		}
		cb41.setBounds(200, 170, 40 , 20);
		add(cb41);
		
		cb42 = new JComboBox<String>();
		for(int i=1;i<=12;i++)
		{
			String c;
			if(i<=9) c="0";
			else c="";
			cb42.addItem(new String(c+i));
		}
		cb42.setBounds(260, 170, 40 , 20);
		add(cb42);
		
		t43 = new JTextField(5);
		t43.setBounds(310,170,60,20);
		add(t43);
		
		l5 = new JLabel("Gender");
		l5.setBounds(50, 210, 100, 20);
		l5.setFont(new Font("Arial", Font.BOLD,12));
		add(l5);
		
		r1 = new JRadioButton("Male", true);
		r2 = new JRadioButton("Female", false);
		grp =  new ButtonGroup();
		grp.add(r1);
		grp.add(r2);
		r1.setBounds(200,210,75,20);
		r2.setBounds(280,210,75,20);
		add(r1);
		add(r2);
		
		l6 = new JLabel("House No.");
		l6.setBounds(50, 250, 100, 20);
		l6.setFont(new Font("Arial", Font.BOLD,12));
		add(l6);
		
		t6 = new JTextField(10);
		t6.setBounds(200, 250, 150, 20);
		t6.setFont(f);
		add(t6);
		
		l7 = new JLabel("Street");
		l7.setBounds(50, 290, 100, 20);
		l7.setFont(new Font("Arial", Font.BOLD,12));
		add(l7);
		
		t7 = new JTextField(10);
		t7.setBounds(200, 290, 150, 20);
		t7.setFont(f);
		add(t7);
		
		l8 = new JLabel("Area");
		l8.setBounds(50, 330, 100, 20);
		l8.setFont(new Font("Arial", Font.BOLD,12));
		add(l8);
		
		t8 = new JTextField(10);
		t8.setBounds(200, 330, 150, 20);
		t8.setFont(f);
		add(t8);
		
		l9 = new JLabel("Phone No. :");
		l9.setBounds(50, 370, 100, 20);
		l9.setFont(new Font("Arial", Font.BOLD,12));
		add(l9);
		
		t9 = new JTextField(15);
		t9.setBounds(200, 370, 150, 20);
		t9.setFont(f);
		add(t9);
		
		l10 = new JLabel("Email ID :");
		l10.setBounds(50, 410, 100, 20);
		l10.setFont(new Font("Arial", Font.BOLD,12));
		add(l10);
		
		t10 = new JTextField(30);
		t10.setBounds(200, 410, 150, 20);
		t10.setFont(f);
		add(t10);
		
		l11 = new JLabel("Religion");
		l11.setBounds(50, 450, 100, 20);
		l11.setFont(new Font("Arial", Font.BOLD,12));
		add(l11);
		
		cb11 = new JComboBox<String>();
		cb11.addItem(" -- ");
		cb11.addItem("Hindu");
		cb11.addItem("Muslim");
		cb11.addItem("Sikh");
		cb11.addItem("Christian");
		cb11.addItem("Others");
		cb11.setBounds(200, 450, 150, 20);
		add(cb11);
		
		
		l12 = new JLabel("Category :");
		l12.setBounds(50, 490, 100, 20);
		l12.setFont(new Font("Arial", Font.BOLD,12));
		add(l12);
		
		cb12 = new JComboBox<String>();
		cb12.addItem(" -- ");
		cb12.addItem("General");
		cb12.addItem("SC");
		cb12.addItem("ST");
		cb12.addItem("OBC");
		cb12.setBounds(200, 490, 150, 20);
		add(cb12);
		
		b1 = new JButton("Save");
		b1.setBounds(100, 580, 80, 20);
		add(b1);
		
		b2 = new JButton("Next");
		b2.setBounds(250, 580, 80, 20);
		add(b2);
		b2.setEnabled(false);
		
		b3 = new JButton("Reset");
		b3.setBounds(400, 580, 80, 20);
		add(b3);
		
		admin = new JButton(new ImageIcon(((new ImageIcon(
        "admin.png").getImage()
        .getScaledInstance(80, 80,
                java.awt.Image.SCALE_SMOOTH)))));
		admin.setBounds(530,10, 60, 60);
		add(admin);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		admin.addActionListener(this);
		
		b2.setEnabled(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600) / 2);
		int y = (int) ((dimension.getHeight() - 700) / 2);
		setLocation(x, y);
		
		setVisible(true);
		setSize(600,700);
		
  }
	public void actionPerformed(ActionEvent ae){
		
		
		if (ae.getSource() == admin){
			int response  = JOptionPane.showConfirmDialog(this, "Your data will be lost..Do u still want to exit???","confirm", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION){
				setVisible(false);
				new Admin();
			}
		}
		if (ae.getSource()==b1){
			try{
			String a = t1.getText();
			int ano = Integer.parseInt(a);
			String fn = t2.getText();
			String ln = t3.getText();
			String b = t6.getText();
			int hno = Integer.parseInt(b);
			String st = t7.getText();
			String ar = t8.getText();
			String ph = t9.getText();
			String mail = t10.getText();
			String dt = t43.getText()+"-"+cb42.getSelectedItem().toString()+"-"+cb41.getSelectedItem().toString();
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(dt);

			java.sql.Date sql = new java.sql.Date(date.getTime());
			String rel = cb11.getSelectedItem().toString();
			String cat = cb12.getSelectedItem().toString();
			char gen = (r1.isSelected()?'m':'f');
			
			if(a.isEmpty() || fn.isEmpty() || ln.isEmpty() || b.isEmpty() || 
					st.isEmpty() || ar.isEmpty() || ph.isEmpty() || 
					t43.getText().isEmpty() || mail.isEmpty()|| cb11.getSelectedItem().toString().equals(" -- ")
					|| cb12.getSelectedItem().toString().equals(" -- ")){
				JOptionPane.showMessageDialog(this, "Enter Complete Details");
			}
				else{
					z = new Citizen(ano ,hno , fn ,ln , sql ,st ,ar , ph ,mail ,rel ,cat ,gen);
					b2.setEnabled(true);
				}
			}
			catch (ParseException e) {
				e.printStackTrace();
			}	
		}
		
		else if (ae.getSource()==b2){
			new Details(z);
			this.setVisible(false);
		}
		else if (ae.getSource() == b3){
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t43.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
			cb11.setSelectedItem(" -- ");
			cb12.setSelectedItem(" -- ");
		}
		
	}
}