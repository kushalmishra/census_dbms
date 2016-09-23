package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Comm { 
	int aadhar , wheeler4, wheeler2, ac, fridge, tv, geyser;

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public int getWheeler4() {
		return wheeler4;
	}

	public void setWheeler4(int wheeler4) {
		this.wheeler4 = wheeler4;
	}

	public int getWheeler2() {
		return wheeler2;
	}

	public void setWheeler2(int wheeler2) {
		this.wheeler2 = wheeler2;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getFridge() {
		return fridge;
	}

	public void setFridge(int fridge) {
		this.fridge = fridge;
	}

	public int getTv() {
		return tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int getGeyser() {
		return geyser;
	}

	public void setGeyser(int geyser) {
		this.geyser = geyser;
	}
	
	Comm(int aadhar, int wheeler4, int wheeler2, int ac, int fridge, int tv, int geyser){
		
		this.aadhar = aadhar;
		this.wheeler4 = wheeler4;
		this.wheeler2 = wheeler2; 
		this.ac = ac;
		this.fridge = fridge;
		this.tv = tv;
		this.geyser = geyser;
	}

	void register()throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
		PreparedStatement stmt = con.prepareStatement("insert into commodity values(?,?,?)");
		
		stmt.setInt(1, aadhar);
		//stmt.setString(2, "wheeler2");
		//stmt.setInt(3, wheeler2);
		//System.out.println(""+ wheeler2);
		//stmt.executeUpdate();
		
		//System.out.println("DWAS");
		if(wheeler2>0) { stmt.setString(2, "wheeler2");stmt.setInt(3, wheeler2); stmt.executeUpdate();}
		if(ac>0) { stmt.setString(2, "ac");stmt.setInt(3, ac); stmt.executeUpdate();}
		if(fridge>0) { stmt.setString(2, "fridge");stmt.setInt(3, fridge); stmt.executeUpdate();}
		if(tv>0) { stmt.setString(2, "tv");stmt.setInt(3, tv); stmt.executeUpdate();}
		if(geyser>0) { stmt.setString(2, "geyser");stmt.setInt(3, geyser); stmt.executeUpdate();}
		if(wheeler4>0) { stmt.setString(2, "wheeler4");stmt.setInt(3, wheeler4); stmt.executeUpdate();}
		
		con.close();
		stmt.close();
		
		
}
}