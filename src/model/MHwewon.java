package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.OHwewon;

public class MHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String major;


	public boolean read(Scanner scanner) {
		if(scanner.hasNext()) {
			this.id = scanner.next();
			this.password = scanner.next();
			this.name = scanner.next();
			this.address = scanner.next();
			this.major = scanner.next();
			return true;
		}
		return false;
	}

	public void save(FileWriter fileWriter, OHwewon oHweown) {
		this.set(oHweown);
		try {
			String str = id +"\n" + password+"\n" +name+"\n" +address+"\n" + major +"\n\n";
			fileWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void set (OHwewon oHweown) {
		this.id = oHweown.getId();
		this.password = oHweown.getPassword();
		this.name = oHweown.getName();
		this.address = oHweown.getAddress();
		this.major = oHweown.getHwakgwa();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}



}

