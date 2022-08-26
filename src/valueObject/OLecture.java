package valueObject;

import model.MLecture;

public class OLecture {
	String id;
	String name;
	String professor;
	String gradePoint;
	String time;
	
	
	public void set(MLecture mLecture) {
		this.id = mLecture.getId();
		this.name = mLecture.getName();
		this.professor = mLecture.getProfessor();
		this.gradePoint = mLecture.getGradePoint();
		this.time = mLecture.getTime();
				
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

	
	

}
