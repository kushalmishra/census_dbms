package labProject;

import java.sql.*;

public class Citizen {
	int aadharNo , hNo , child , income;
	String fName , lName  , street , area , phone , mail , religion , category , marStatus , qual , occu;
	char sex;
	Date dob;
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMarStatus() {
		return marStatus;
	}
	public void setMarStatus(String marStatus) {
		this.marStatus = marStatus;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getOccu() {
		return occu;
	}
	public void setOccu(String occu) {
		this.occu = occu;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	Citizen(int aadharNo ,int hNo , String fName ,String lName ,Date dob ,String street ,String area ,String phone ,String mail ,String religion ,String category ,char sex){
		this.aadharNo = aadharNo;
		this.hNo = hNo;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.street = street;
		this.area = area;
		this.phone = phone;
		this.mail = mail;
		this.religion = religion;
		this.category = category;
		this.sex = sex;
		}
	
	Citizen(int aadharNo ,int hNo , String fName ,String lName ,String street ,String area ,String phone ,String mail ,String religion ,String category ,char sex){
		this.aadharNo = aadharNo;
		this.hNo = hNo;
		this.fName = fName;
		this.lName = lName;
		this.street = street;
		this.area = area;
		this.phone = phone;
		this.mail = mail;
		this.religion = religion;
		this.category = category;
		this.sex = sex;
		}
	
	void addDetails(int child ,int income, String marStatus ,String qual ,String occu){
		this.child = child;
		this.income = income;
		this.marStatus = marStatus;
		this.qual = qual;
		this.occu = occu;
	}
	
	void register()throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50001/census" , "KUSHAL MISHRA" , "lemonade");
		PreparedStatement stmt = con.prepareStatement("insert into citizen values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setInt(1,aadharNo);
		stmt.setString(2, fName);
		stmt.setString(3, lName);
		stmt.setDate(4, dob);
		stmt.setString(5, String.valueOf(sex));
		stmt.setInt(6,hNo);
		stmt.setString(7, street);
		stmt.setString(8, area);
		stmt.setString(9, phone);
		stmt.setString(10, mail);
		stmt.setString(11, religion);
		stmt.setString(12, category);
		stmt.setInt(13, child);
		stmt.setString(14, marStatus);
		stmt.setString(15, qual);
		stmt.setString(16, occu);
		stmt.setInt(17, income);
		
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
}
