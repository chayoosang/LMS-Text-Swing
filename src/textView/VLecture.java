package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OLecture;

public class VLecture {

	private CLecture cLecture;
	private Scanner sc;
	public VLecture(Scanner sc) {
		this.sc = sc;
		this.cLecture = new CLecture();
	}

	public OLecture show(String string) {
		System.out.println("강좌를 선택해주세요.");
		OLecture oLecture = new OLecture();
		Vector<OLecture> lectures = cLecture.getAll(string);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.getId() +" "+ lecture.getName() +" "+lecture.getProfessor()+" "+lecture.getGradePoint()+" "+lecture.getTime());
		}
		String id = this.sc.next();
		for(OLecture lecture : lectures) {
			if(lecture.getId().equals(id)) {
				return lecture;
			}
		}
		return null;
	}
}


