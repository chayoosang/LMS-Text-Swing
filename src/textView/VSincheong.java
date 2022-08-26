package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;


public class VSincheong {
	
	private Scanner sc;
	private CLecture cLecture;
	private int totalGradepoint = 18;
	private int gradepoint;
	public VSincheong(Scanner sc) {
		this.sc  = sc;
		this.cLecture = new CLecture();
	}
	
	private int getGradepoint(OHwewon oHwewon) {
		int gradepoint =0;
		Vector<OLecture> lectures = this.cLecture.getSincheong(oHwewon.getId());
		for(OLecture oLecture : lectures) {
			gradepoint+= Integer.parseInt(oLecture.getGradePoint());
		}
		return (this.totalGradepoint - gradepoint);
	}
	
	public void show(OLecture oLecture, OHwewon oHwewon) {
		this.gradepoint = getGradepoint(oHwewon);
		if(this.gradepoint > Integer.parseInt(oLecture.getGradePoint())) {
		cLecture.saveLecture(oLecture, oHwewon,"sincheong");
		}
		else
			System.out.println("수강가능한 학점을 초과하셨습니다.");
	}

	
	

}
