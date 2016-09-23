package labProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SearchDetails extends Admin{
	
	JTextArea ta;
	
	SearchDetails(Citizen c){
		
		Citizen c1 = c;
		
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
		setTitle("Regional Queries");
		setIconImage(new ImageIcon("census.jpg").getImage());
		
		//Font f=new Font("Arial",Font.BOLD,15);
		
		ta = new JTextArea();
		ta.setPreferredSize(new Dimension(500,500));
		ta.setBounds(50 ,50 , 300 ,300);
		add(ta);
		
		ta.append("NAME =" + c1.fName+ " " + c1.lName + " \n PHONE =" +c1.phone + "\n MAIL ="+ c1.mail + "\n ADDRESS ="+ c1.hNo + " , "
		              +c1.street +" , " + c1.area + "\n CATEGORY =" +c1.category + " \n RELIGION ="+ c1.religion + "\n");
	}

}
