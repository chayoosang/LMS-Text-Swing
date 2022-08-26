package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.OLecture;

public class MLecture {

	String id;
	String name;
	String professor;
	String gradePoint;
	String time;
	
	public boolean read(Scanner sc) {
		if(sc.hasNext()) {
			this.id = sc.next();
			this.name = sc.next();
			this.professor = sc.next();
			this.gradePoint = sc.next();
			this.time = sc.next();
			return true;
		}
		return false;
	}

	
	private void set (OLecture oLecture) {
		this.id = oLecture.getId();
		this.name = oLecture.getName();
		this.professor = oLecture.getProfessor();
		this.gradePoint = oLecture.getGradePoint();
		this.time = oLecture.getTime();
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
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getGradePoint() {
		return gradePoint;
	}
	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}



	public void save(FileWriter fileWriter, OLecture oLecture) {
		this.set(oLecture);
		try {
			fileWriter.write( id +" "+ name + " " + professor + " " +gradePoint + " " +time + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
