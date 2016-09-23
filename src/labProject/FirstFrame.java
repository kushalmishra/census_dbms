package labProject;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.image.BufferedImage.*;
//import javax.swing.border.*;

public class FirstFrame extends JFrame implements ActionListener
 {
	JLabel l1,l2;
	JButton b1,b2,admin,user;
	FirstFrame(){
	BufferedImage img = null;
		try {
			img = ImageIO.read(new File("url4.jpg"));	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(500, 500,Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		
		setResizable(false);
		setTitle("Census 2021");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		Font f=new Font("Raleway",Font.BOLD,45);
		
		l1 = new JLabel("CENSUS 2021");
		l1.setBounds(80, 80, 300, 50);
		l1.setFont(f);
		add(l1);
		
		admin = new JButton(new ImageIcon(((new ImageIcon(
        "admin.png").getImage()
        .getScaledInstance(80, 80,
                Image.SCALE_SMOOTH)))));
		admin.setBounds(150,260, 80, 80);
		add(admin);
		
		user = new JButton(new ImageIcon(((new ImageIcon(
        "user.png").getImage()
        .getScaledInstance(80, 80,
                Image.SCALE_SMOOTH)))));
		user.setBounds(260, 260, 80, 80);
		add(user);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500) / 2);
		int y = (int) ((dimension.getHeight() - 500) / 2);
		setLocation(x, y);
		
		setSize(500,500);
		setVisible(true);
		
		admin.addActionListener(this);
		user.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==admin){
			new AdminFrame();
			setVisible(false);
		}
		else if(ae.getSource()==user){
			new Queries();
			setVisible(false);
			
		}
	}
}