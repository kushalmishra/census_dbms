package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;
//import javax.swing.border.*;

public class Queries extends JFrame implements ActionListener
 {
	JLabel l1;
	JButton b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,back,home;
	JComboBox<String> cb1;
	JTextArea ta;
	Connection con;
	PreparedStatement stmt,stmt1;
	ResultSet rs;
	 
	Queries(){
		
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
		setTitle("Regional Queries");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		//Font f=new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Region");
		l1.setBounds(170, 70, 70, 20);
		l1.setFont(new Font("Arial", Font.BOLD,15));
		add(l1);
		
		cb1 = new JComboBox<String>();
		cb1.addItem(" <- select -> ");
		cb1.addItem("Jaipur");
		cb1.addItem("C-Scheme");
		cb1.addItem("Raja Park");
		cb1.addItem("Mansarovar");
		cb1.addItem("Vaishali Nagar");
		cb1.addItem("Malviya Nagar");
		cb1.addItem("Vidyadhar Nagar");
		cb1.setBounds(300, 70, 150, 20);
		add(cb1);
		
		b2 = new JButton("Pincode");
		b2.setBounds(120, 150, 150, 20);
		add(b2);
		
		b3 = new JButton("Population");
		b3.setBounds(320, 150, 160, 20);
		add(b3);
		
		b4 = new JButton("Sex Ratio");
		b4.setBounds(120, 200, 150, 20);
		add(b4);
		
		b5 = new JButton("Caste Proportion");
		b5.setBounds(320, 200, 160, 20);
		add(b5);
		
		b6 = new JButton("Religion Proportion");
		b6.setBounds(120, 250, 150, 20);
		add(b6);
		
		b7 = new JButton("Commodity Details");
		b7.setBounds(320, 250, 160, 20);
		add(b7);
		
		b8 = new JButton("Marital Proportion");
		b8.setBounds(120, 300, 150, 20);
		add(b8);
		
		b9 = new JButton("Qualification Division");
		b9.setBounds(320, 300, 160, 20);
		add(b9);
		
		ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200,100));
		ta.setBounds(200 ,400 , 300 ,200);
		add(ta);
		
		back = new JButton(new ImageIcon(new ImageIcon(
        "backb.png").getImage()
        .getScaledInstance(50, 40,
                java.awt.Image.SCALE_SMOOTH)));
		back.setBounds(0, 0, 50, 40);
		add(back);
		
		home = new JButton(new ImageIcon(new ImageIcon(
        "home.png").getImage()
        .getScaledInstance(50, 40,
                java.awt.Image.SCALE_SMOOTH)));
		home.setBounds(550, 0, 50, 40);
		add(home);
		
		back.addActionListener(this);
		home.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600) / 2);
		int y = (int) ((dimension.getHeight() - 699) / 2);
		setLocation(x, y);
		
		setVisible(true);
		setSize(600,699);
	}
 
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource()==back){
			new FirstFrame();
			this.setVisible(false);
		}
		else if (ae.getSource()==home){
			new FirstFrame();
			this.setVisible(false);
		}
		
		if (ae.getSource()== b2){
			
			if(cb1.getSelectedItem()== "Jaipur"){
			
			
			try {
				con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
				stmt = con.prepareStatement("Select name , pincode from region");
				rs = stmt.executeQuery();
				
	            while(rs.next()){
	            	ta.append(rs.getString("name")+ "    -    "+ rs.getString("pincode")+"\n");
	            
	            }
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	}
			else {
				String ar = (String) cb1.getSelectedItem();
				try{
				con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
				stmt = con.prepareStatement("Select name , pincode from region where name = ?");
				stmt.setString(1, ar);
				rs = stmt.executeQuery();
				if (rs.next())ta.append(rs.getString("name")+ "    -    "+ rs.getString("pincode")+"\n");
	            
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		
		}
		
		else if (ae.getSource()== b3){
			
			if (cb1.getSelectedItem() == "Jaipur"){
				try {
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select sum(Total) as ans from region");
					rs = stmt.executeQuery();
					
					
		            if(rs.next())
		            	ta.append("Total population of city is "+ rs.getString("ans")+ "\n");
		            	//System.out.print("Total population of city is "+ rs.getString("ans"));
			            
		            
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select Total from region where name = ? ");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					if (rs.next())ta.append("Total population of" + ar + "is" +rs.getString("Total") + "\n");
		            
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		else if(ae.getSource()==b4){
			if (cb1.getSelectedItem()=="Jaipur"){
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select sum(male) as m,sum(female) as f from region");
					rs = stmt.executeQuery();
					
					if (rs.next()){
					int ans = (1000*rs.getInt("F"))/(rs.getInt("M")); 
			            
			      	ta.append("Sexratio of Jaipur City is " + ans + "\n");
			            }

				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select male , female  from region where name = ? ");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					if (rs.next()) {
						int ans = (1000*rs.getInt("female"))/(rs.getInt("male"));
					
						ta.append("Sex Ratio of" + ar + "is" + ans +"\n");
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		else if (ae.getSource() == b5){
			
			if (cb1.getSelectedItem() == "Jaipur"){
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select sum(GENERAL) as gen , sum(SC) as sc , sum(ST) as st , sum(OBC) as obc from region ");
					rs = stmt.executeQuery();
					
					if (rs.next()){
						ta.append("General = "+ rs.getInt("GEN")+ "\n SC = "+ rs.getInt("SC") + "\n ST = "+ rs.getInt("ST") + "\n OBC = "+ rs.getInt("OBC")+ "\n");
			            
			            }
				
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select GENERAL , SC , ST , OBC from region where name = ?");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					if (rs.next()) {
						ta.append("General = "+ rs.getInt("GENERAL")+ "\n SC = "+ rs.getInt("SC") + "\n ST = "+ rs.getInt("ST") + "\n OBC = "+ rs.getInt("OBC")+ "\n");
			            
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
   }
			else if (ae.getSource() == b6){
			
				if (cb1.getSelectedItem() == "Jaipur"){
					try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select RELIGION as r, count(*) as c from citizen group by RELIGION  ");
					rs = stmt.executeQuery();
					
					while (rs.next()){
						ta.append(""+rs.getString("r")+ "=" + rs.getInt("c")+ "\n");
			            
			            }
				
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select RELIGION as r , count(*) as c from citizen where area = (?) group by RELIGION");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					while (rs.next()) {
						ta.append(""+rs.getString("r")+ "=" + rs.getInt("c")+ "\n");
			            
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
		
	
   }
		else if (ae.getSource() == b7){
			
			if (cb1.getSelectedItem() == "Jaipur"){
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select TYPE as t, sum(NUMBER) as num  from commodity group by TYPE ");
					rs = stmt.executeQuery();
				
					while (rs.next()){
						ta.append(rs.getString("t")+" = "+ rs.getInt("num") + "\n ");
		            
		            }
			
		}
				catch (SQLException e) {
					e.printStackTrace();
			}
	}
		else {
			String ar = (String)cb1.getSelectedItem();
			try{
				con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
				stmt = con.prepareStatement("select type as t , sum(number) as n from ( select * from commodity A inner join citizen B on A.ownerid = B.aadhar) where area = (?) group by type");
				stmt.setString(1,ar);
				rs = stmt.executeQuery();
				while (rs.next()) {
					ta.append( rs.getString("t")+ " = "+ rs.getInt("n") + "\n" );
		            
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
			else if (ae.getSource() == b8){
			
				if (cb1.getSelectedItem() == "Jaipur"){
					try{
						con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
						stmt = con.prepareStatement("Select sum(SINGLE) as sin, sum(MARRIED) as mar  from region ");
						rs = stmt.executeQuery();
					
						if (rs.next()){
							ta.append("Single = "+ rs.getInt("sin")+ "\n MARRIED = "+ rs.getInt("mar") + "\n ");
			            
			            }
				
			}
					catch (SQLException e) {
						e.printStackTrace();
				}
		}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select SINGLE , MARRIED from region where name = ?");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					if (rs.next()) {
						ta.append("Single = "+ rs.getInt("SINGLE")+ "\n Married = "+ rs.getInt("MARRIED") + "\n" );
			            
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
   }
		
			else if (ae.getSource() == b9){
				
				if (cb1.getSelectedItem() == "Jaipur"){
					try{
						con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
						stmt = con.prepareStatement("Select sum(SCHOOLING) as sch, sum(HIGHEDU) as hed  from region ");
						rs = stmt.executeQuery();
					
						if (rs.next()){
							ta.append("Schooling = "+ rs.getInt("sch")+ "\n Higher Education = "+ rs.getInt("hed") + "\n ");
			            
			            }
				
			}
					catch (SQLException e) {
						e.printStackTrace();
				}
		}
			else {
				String ar = (String)cb1.getSelectedItem();
				try{
					con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
					stmt = con.prepareStatement("Select SCHOOLING , HIGHEDU from region where name = ?");
					stmt.setString(1,ar);
					rs = stmt.executeQuery();
					if (rs.next()) {
						ta.append("Schooling = "+ rs.getInt("SCHOOLING")+ "\n Higher Education = "+ rs.getInt("HIGHEDU") + "\n" );
			            
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		
	
   }
}
 }