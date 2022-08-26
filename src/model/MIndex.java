package model;

import java.util.Scanner;

public class MIndex {

	private String id;
	private String name;
	private String fileName;
	
	public MIndex() {
		
	}
	
	public boolean read(Scanner sc) {
		if(sc.hasNext()) {
			this.id = sc.next();
			this.name = sc.next();
			this.fileName = sc.next();
			return true;
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
