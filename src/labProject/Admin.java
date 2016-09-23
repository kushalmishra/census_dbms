package labProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Admin extends JFrame implements ActionListener {
	HashMap<String, Citizen> map = new HashMap<String, Citizen>();
	JLabel l, l1;
	JButton b1, b2, b3, back, home;
	JTextField t1;
	Citizen c;


	public Citizen getC() {
		return c;
	}

	Admin() {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("url4.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(400, 399, Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);

		setResizable(false);
		setTitle("Admin");
		setIconImage(new ImageIcon("census.jpg").getImage());

		Font f = new Font("Arial", Font.BOLD, 15);

		l = new JLabel("Admin Section");
		l.setBounds(70, 70, 260, 50);
		l.setFont(new Font("Arial", Font.BOLD, 30));
		add(l);

		l1 = new JLabel("Aadhar No.");
		l1.setBounds(50, 150, 100, 20);
		l1.setFont(new Font("Arial", Font.BOLD, 15));
		add(l1);

		t1 = new JTextField(10);
		t1.setBounds(200, 150, 100, 20);
		t1.setFont(f);
		add(t1);

		b1 = new JButton("Add");
		b1.setBounds(50, 250, 70, 20);
		add(b1);

		b2 = new JButton("Search");
		b2.setBounds(150, 250, 90, 20);
		add(b2);

		b3 = new JButton("Delete");
		b3.setBounds(270, 250, 70, 20);
		add(b3);

		back = new JButton(new ImageIcon(
				((new ImageIcon("backb.png").getImage().getScaledInstance(50,
						40, java.awt.Image.SCALE_SMOOTH)))));
		back.setBounds(0, 0, 50, 40);
		add(back);

		home = new JButton(new ImageIcon(
				((new ImageIcon("home.png").getImage().getScaledInstance(50,
						40, java.awt.Image.SCALE_SMOOTH)))));
		home.setBounds(350, 0, 50, 40);
		add(home);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 400) / 2);
		int y = (int) ((dimension.getHeight() - 399) / 2);
		setLocation(x, y);

		setSize(400, 399);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		String aad = t1.getText();
		if (aad.length() <= 0
				&& (ae.getSource() == b1 || ae.getSource() == b2 || ae
						.getSource() == b3))
			JOptionPane.showMessageDialog(this, "Insert Aadhar No.!!!");
		if (ae.getSource() == b1) {
			new AddCitizen(1, Integer.parseInt(aad));
			setVisible(false);
		} else if (ae.getSource() == b2) {
			 
			 search();
			// new SearchDetails();
			 

		} else if (ae.getSource() == b3) {
			
			try {
				delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if (ae.getSource() == back) {
			new AdminFrame();
			this.setVisible(false);
		} else if (ae.getSource() == home) {
			new FirstFrame();
			this.setVisible(false);
		}
	
	}
	
	void search(){
		HashMap<String, Citizen> map = new HashMap<String, Citizen>();
		String aad = t1.getText();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:db2://localhost:50001/census", "KUSHAL MISHRA",
					"lemonade");
			PreparedStatement stmt = con
					.prepareStatement("select * from citizen");
			java.sql.ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				int aadhar = rs.getInt("Aadhar");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				char sex = rs.getString("SEX").charAt(0);
				int hno = rs.getInt("HNO");
				String street = rs.getString("STREET");
				String area = rs.getString("AREA");
				String phno = rs.getString("PHONE");
				String mail = rs.getString("MAIL");
				String rel = rs.getString("RELIGION");
				String categ = rs.getString("CATEGORY");

				Citizen cz = new Citizen(aadhar, hno, fname, lname, street,
						area, phno, mail, rel, categ, sex);
				map.put(Integer.toString(aadhar), cz);
				
			}
			if(!map.containsKey(aad)){
				JOptionPane.showMessageDialog(this, "This Citizen does not exist..!!!");
			}
			else{
			c = map.get(aad);
			new SearchDetails(c);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	void delete() throws SQLException{
		String aad = t1.getText();
		int aadhar = Integer.valueOf(aad);
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50001/census","KUSHAL MISHRA", "lemonade");
		PreparedStatement stmt1=con.prepareStatement("delete from commodity where ownerid = ?");
		stmt1.setInt(1, aadhar);
		stmt1.executeUpdate();
		PreparedStatement stmt2=con.prepareStatement("delete from citizen where aadhar = ?");
		stmt2.setInt(1, aadhar);
		stmt2.executeUpdate();
		
		
		con.close();
		stmt1.close();
		stmt2.close();
		
		JOptionPane.showMessageDialog(this , "This citizen has been deleted succesfully..!!!");
	}
}