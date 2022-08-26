package valueObject;

import model.MHwewon;

public class OHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String  hwakgwa;


	public OHwewon() {
	}

	// setters & getters

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public void setPassword(char[] password) {
		String passwordSt="";
		for(int i =0; i<password.length; i++) {
			passwordSt+=password[i];
		}
		this.password=passwordSt;

	}
	public String getName() {	return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {	return address;}
	public void setAddress(String address) {this.address = address;}
	public String getHwakgwa() {return hwakgwa;}
	public void setHwakgwa(String hwakgwa) {this.hwakgwa = hwakgwa;}

	public void set(MHwewon mHweown) {
		this.id = mHweown.getId();
		this.password = mHweown.getPassword();
		this.name = mHweown.getName();
		this.address = mHweown.getAddress();
		this.hwakgwa = mHweown.getMajor();

	}

	// �� ������ �����ͼ� �ٷξ��°� ������ ������ ���



}
