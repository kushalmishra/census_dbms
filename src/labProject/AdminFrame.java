package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.awt.image.*;

import javax.imageio.*;

//import java.awt.image.BufferedImage.*;
//import javax.swing.border.*;

public class AdminFrame extends JFrame implements ActionListener
  {
	JLabel l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1,back,home;
	
	AdminFrame(){
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("url4.jpg"));	
		} 
		catch (IOException e) {
			e.printStackTrace();
			
		}
		Image dimg = img.getScaledInstance(300, 300,Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		
		setResizable(false);
		setTitle("Admin");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Username");
		l1.setBounds(50, 100, 100, 20);
		add(l1);
		
		t1 = new JTextField(30);
		t1.setBounds(150, 100, 100, 20);
		t1.setFont(f);
		add(t1);
		
		l2 = new JLabel("Password");
		l2.setBounds(50, 150, 100, 20);
		add(l2);
		
		p1 = new JPasswordField(30);
		p1.setBounds(150, 150, 100, 20);
		//p1.setFont(f);
		add(p1);
		
		b1 = new JButton("Login");
		b1.setBounds(110, 200, 80, 20);
		add(b1);
		
		back = new JButton(new ImageIcon(((new ImageIcon(
        "backb.png").getImage()
        .getScaledInstance(50, 40,
                java.awt.Image.SCALE_SMOOTH)))));
		back.setBounds(0, 0, 50, 40);
		add(back);
		
		home = new JButton(new ImageIcon(((new ImageIcon(
        "home.png").getImage()
        .getScaledInstance(50, 40,
                java.awt.Image.SCALE_SMOOTH)))));
		home.setBounds(250, 0, 50, 40);
		add(home);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 300) / 2);
		int y = (int) ((dimension.getHeight() - 300) / 2);
		setLocation(x, y);
		
		setSize(300,300);
		setVisible(true);
		
		b1.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae){
	
		if(ae.getSource()==b1){
			
			try {
				int access = validate(t1.getText(), new String(p1.getPassword()));
				
				if(access==0) {
					JOptionPane.showMessageDialog(this, "Id Doesn't Exist");
					t1.setText("");
					p1.setText("");
				}
				
				else if(access==1) {
					JOptionPane.showMessageDialog(this, "Wrong Password");
					t1.setText("");
					p1.setText("");
				}
				
				if(access==2) {
					new Admin();
					setVisible(false);
				}
			
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			
		}
		else if (ae.getSource()==back){
			new FirstFrame();
			this.setVisible(false);
		}
		else if (ae.getSource()==home){
			new FirstFrame();
			this.setVisible(false);
		}
	}
	
	private int validate(String id, String pass) throws SQLException{
		int b =0;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
		PreparedStatement stmt = con.prepareStatement("select username , pass from admin where username = ?");
		stmt.setString(1,id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next() == true){                                        //to check username and password
			b++;
			if(rs.getString("pass").equals(pass)) b++;
		}
		con.close();
		stmt.close();
		return b;
	}
}
