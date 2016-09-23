package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;
import javax.swing.border.*;

public class Commodity extends JFrame implements ActionListener {
	
	JLabel l;
	JTextField t,t1,t2,t3,t4,t5,t6;
	JPanel p;
	ButtonGroup grp;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;
	JButton b1,b2,b3,admin;
	int aadhar;
	
	Commodity(int ad){
		this.aadhar = ad;
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
		setTitle("Add Commodity Details");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		l = new JLabel("Aadhar No. : ");
		l.setBounds(50, 50, 100, 20);
		l.setFont(new Font("Arial", Font.BOLD,12));
		add(l);
		
		t = new JTextField(20);
		t.setText(""+aadhar);
		t.setBounds(200, 50, 100, 20);
		t.setFont(f);
		add(t);
		
		cb1 = new JCheckBox("4 Wheeler");
		cb1.setBounds(80, 150, 100, 20);
		add(cb1);
		
		t1 = new JTextField(3);
		t1.setBounds(200, 150, 50, 20);
		t1.setFont(f);
		add(t1);
		t1.setText(""+0);
		t1.setEnabled(false);
		
		cb2 = new JCheckBox("2 Wheeler");
		cb2.setBounds(80, 190, 100, 20);
		add(cb2);
		
		t2 = new JTextField(3);
		t2.setBounds(200, 190, 50, 20);
		t2.setFont(f);
		add(t2);
		t2.setText(""+0);
		t2.setEnabled(false);
		
		cb3 = new JCheckBox("AC");
		cb3.setBounds(80, 230, 100, 20);
		add(cb3);
		
		t3 = new JTextField(3);
		t3.setBounds(200, 230, 50, 20);
		t3.setFont(f);
		add(t3);
		t3.setText(""+0);
		t3.setEnabled(false);
		
		cb4 = new JCheckBox("Refrigerator");
		cb4.setBounds(80, 270, 100, 20);
		add(cb4);
		
		t4 = new JTextField(3);
		t4.setBounds(200, 270, 50, 20);
		t4.setFont(f);
		add(t4);
		t4.setText(""+0);
		t4.setEnabled(false);
		
		cb5 = new JCheckBox("Television");
		cb5.setBounds(80, 310, 100, 20);
		add(cb5);
		
		t5 = new JTextField(3);
		t5.setBounds(200, 310, 50, 20);
		t5.setFont(f);
		add(t5);
		t5.setText(""+0);
		t5.setEnabled(false);
		
		cb6 = new JCheckBox("Geyser");
		cb6.setBounds(80, 350, 100, 20);
		add(cb6);
		
		t6 = new JTextField(3);
		t6.setBounds(200, 350, 50, 20);
		t6.setFont(f);
		add(t6);
		t6.setText(""+0);
		t6.setEnabled(false);
		
		b1 = new JButton("Save");
		b1.setBounds(100, 450, 80, 20);
		add(b1);
		
		b2 = new JButton("Reset");
		b2.setBounds(250, 450, 80, 20);
		add(b2);
		b2.setEnabled(false);
		
		admin = new JButton(new ImageIcon(((new ImageIcon(
        "admin.png").getImage()
        .getScaledInstance(80, 80,
                java.awt.Image.SCALE_SMOOTH)))));
		admin.setBounds(440,0, 60, 60);
		add(admin);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		cb3.addActionListener(this);
		cb4.addActionListener(this);
		cb5.addActionListener(this);
		cb6.addActionListener(this);
		admin.addActionListener(this);
		
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500) / 2);
		int y = (int) ((dimension.getHeight() - 600) / 2);
		setLocation(x, y);
		
		
		setVisible(true);
		setSize(500,600);
	}
	
	
	public void actionPerformed(ActionEvent ae){
		
		if (ae.getSource()==b1){
			String a = t.getText();
			int ano = Integer.parseInt(a);
			String b = t1.getText();
			int w4 = Integer.parseInt(b);
			String c = t2.getText();
			int w2 = Integer.parseInt(c);
			String d = t3.getText();
			int ac = Integer.parseInt(d);
			String e = t4.getText();
			int fr = Integer.parseInt(e);
			String f = t5.getText();
			int tv = Integer.parseInt(f);
			String g = t6.getText();
			int gy = Integer.parseInt(g);

			Comm co = new Comm(ano , w4 , w2 , tv , fr , ac , gy);
			try {
				co.register();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
					}
		if (ae.getSource()==cb1){
			if(cb1.isSelected()==true)t1.setEnabled(true);
			else {t1.setEnabled(false); t1.setText(""+0);}
		}
		if (ae.getSource()==cb2){
			if(cb2.isSelected()==true)t2.setEnabled(true);
			else {t2.setEnabled(false);t2.setText(""+0);}
		}
		if (ae.getSource()==cb3){
			if(cb3.isSelected()==true)t3.setEnabled(true);
			else {t3.setEnabled(false);t3.setText(""+0);}
		}
		if (ae.getSource()==cb4){
			if(cb4.isSelected()==true)t4.setEnabled(true);
			else {t4.setEnabled(false);t4.setText(""+0);}
		}
		if (ae.getSource()==cb5){
			if(cb5.isSelected()==true)t5.setEnabled(true);
			else {t5.setEnabled(false);t5.setText(""+0);}
		}
		if (ae.getSource()==cb6){
			if(cb6.isSelected()==true)t6.setEnabled(true);
			else {t6.setEnabled(false);t6.setText(""+0);}
		}

		if (ae.getSource()==admin){
			new Admin();
			this.setVisible(false);
		}
		else if (ae.getSource() == b2){
			cb1.setSelected(false);
			cb2.setSelected(false);
			cb3.setSelected(false);
			cb4.setSelected(false);
			cb5.setSelected(false);
			cb6.setSelected(false);
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			
			
		}
	}
}
